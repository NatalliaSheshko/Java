package org.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/car_sales";;
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static DBConnector dbconnector = null;
    public static Connection connection = null;

    public static  final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private DBConnector() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("-------------------------------------------");
            System.out.println("|  Подключение к базе данных установлено  |");
            System.out.println("-------------------------------------------\n");

        } catch (SQLException e) {
            System.out.println("-------------------------------------------");
            System.out.println("|  Не удалось подключиться к базе данных  |");
            System.out.println("-------------------------------------------\n");
            e.printStackTrace();
        }


    }

    public static Connection getInstanse() {
        if (dbconnector == null) {
            dbconnector = new DBConnector();
        }
        return connection;
    }

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }

    public static String getDatabaseUrl() {
        return DATABASE_URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static Connection getConnection() {
        return null;
    }
}
