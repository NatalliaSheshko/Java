package org.example.demo.repository;

import java.sql.*;//импортирование пакета JDBC

public class DevelopersJdbcDemo {
    //JDBC Driver and database url
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/car_sales";//передаю URL базы данных
    //User and Password
    static final String USER = "root";
    static final String PASSWORD = "123456";
    public static void main(String[] args) throws
            ClassNotFoundException, SQLException {
        //Connection connection = null;
        //Statement statement = null;
        System.out.println("Registering JDBC driver...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Creating database connection...");
        Connection connection =
                DriverManager.getConnection(DATABASE_URL, USER,//устанавливаю соединение с БД
                        PASSWORD);
        System.out.println("Executing statement...");
        Statement statement = connection.createStatement();//создаю экземпляр Statement (для статических SQL-выражений), чтобы его использовать в дальнейшем
        String sql;
        sql = "SELECT * FROM employees";
        ResultSet resultSet = statement.executeQuery(sql);//создаю метод, который возвращает множество объектов в результате выполнения SQL-запроса
        System.out.println("Retrieving data from database...");
        System.out.println("\nEmployees:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");//получаю и записываю данные результата из запроса БД
            String firstName = resultSet.getString("firstName");
            String secondName = resultSet.getString("secondName");
            String category = resultSet.getString("category");
            int salary = resultSet.getInt("salary");
            System.out.println("\n================\n");
            System.out.println("Id: " + id);
            System.out.println("FirstName: " + firstName);
            System.out.println("SecondName: " + secondName);
            System.out.println("Category: " + category);
            System.out.println("Salary: $" + salary);
        }
        System.out.println("Closing connection and releasing resources...");
        resultSet.close();
        statement.close();//закрываю экземпляр Statement
        connection.close();//закрываю соединение
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
