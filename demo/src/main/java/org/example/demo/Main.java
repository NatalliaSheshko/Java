package org.example.demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.demo.controller.AvtoEditDialogController;
import org.example.demo.controller.MainController;
import org.example.demo.model.Avto;
import org.example.demo.repository.DBConnector;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

import static org.example.demo.repository.DBConnector.*;



public class Main extends Application {

    private Stage stage;

    //ObservableList используется для синхронизации представления данных с самими данными
    public ObservableList<Avto> avtoData = FXCollections.observableArrayList();

    //Конструктор для создания начальных данных:
    public Main() {
        // Добавляет данные о модели:
        avtoData.add(new Avto("COOLRAY"));
        avtoData.add(new Avto("CITYRAY"));
        avtoData.add(new Avto("MONJARO"));
        avtoData.add(new Avto("ATLAS"));
        avtoData.add(new Avto("OKAVANGO"));
    }

    //Возвращает данные в виде списка моделей авто:
    public ObservableList<Avto> getAvtoData() {
        return avtoData;
    }
    //запускаю сцену из fxml:
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("Main.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        stage.setScene(new Scene(root));
        stage.show();

        //Даёт контроллеру доступ к главному приложению:
        MainController controller = loader.getController();
        controller.setMain(this);

    }

    //Открывает диалоговое окно для изменения деталей указанного автомобиля:
    public boolean showAvtoEditDialog(Avto avto) {
        try {
            // Загружает fxml-файл и создаёт новую сцену для всплывающего диалогового окна.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AvtoEditDialog.fxml"));
            AnchorPane page = loader.load();

            // Создаёт диалоговое окно Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Измените данные");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Передаёт модель авто в контроллер.
            AvtoEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setAvto(avto);

            // Отображает диалоговое окно и ждёт, пока пользователь его не закроет
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    //Возвращает главную сцену.
    public Stage getStage() {
        return stage;
    }

    public static void main(String[] args) throws
            ClassNotFoundException, SQLException {
        launch(args);
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL, USER,
                        PASSWORD);

        System.out.println("Executing statement...");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM developers";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
        }

        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();
        connection.close();
    }
    public static void DeleteFromBD() throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("DELETE from employees where Id = 3");
        System.out.printf("%d row(s) deleted \n", rows);
    }
    public static void InsertIntoBD() throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("INSERT employees (firstName, secondName, category, salary) VALUES ('Александр', 'Македонский', 'Высшая', 5000)," +
                "('Зинаида', 'Петрова', 'Первая', 4000)");
        System.out.printf("Added %d rows \n" , rows);
    }
    public static void UpdateTableBD() throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("UPDATE employees SET salary = '6000' where Id = 4");
        System.out.printf("Updated %d row(s) \n", rows);

    }
    public static void FindInBD() throws SQLException {
        Connection connection = DBConnector.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from employees where category = 'Первая'";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");//получаю и записываю данные результата из запроса БД
            String firstName = resultSet.getString("firstName");
            String secondName = resultSet.getString("secondName");
            String category = resultSet.getString("category");
            int salary = resultSet.getInt("salary");
            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("FirstName: " + firstName);
            System.out.println("SecondName: " + secondName);
            System.out.println("Сategory: " + category);
            System.out.println("Salary: $" + salary);
        }
    }
}


