package org.example.demo.repository;

// Класс DBConfigManager управляет вводом, сохранением и загрузкой конфигурации подключения к БД
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class DBConfigManager {
    private static final String CONFIG_FILE = "dbconfig.properties";

    public static void inputConfig() {//считала данные
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter database URL: ");
        String url = scanner.nextLine();
        System.out.print("Enter database user: ");
        String user = scanner.nextLine();
        System.out.print("Enter database password: ");
        String password = scanner.nextLine();
        saveConfig(url, user, password);
    }

    public static void saveConfig(String url, String user, String password) {//записала данные в файл
        Properties properties = new Properties();//класс Properties используется для хранения списков значений, в которых ключ является String, а значение также является String
        properties.setProperty("url", url);
        properties.setProperty("user", user);
        properties.setProperty("password", password);

        try (FileOutputStream fos = new FileOutputStream(CONFIG_FILE)) {//создаю файл и записываю туда данные?
            properties.store(fos, "Database Configuration");
            System.out.println("Configuration saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }

    public static Properties loadConfig() {//загрузила файл с данными
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
            properties.load(fis);
        }
        catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        }
        return properties;
    }
}
