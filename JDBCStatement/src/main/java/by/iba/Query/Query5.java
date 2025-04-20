package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query5 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query5author = "INSERT INTO authors (firstName, lastName) VALUES ('Nikolay', 'Nosov')";
            stmt.executeUpdate(query5author);
            System.out.println("New author added");
            System.out.println("Show all authors:");
            String query = "SELECT * FROM authors";
            ResultSet rs5 = stmt.executeQuery(query);
            while (rs5.next()) {
                int id = rs5.getInt("authorID");
                String firstName = rs5.getString("firstName");
                String lastName = rs5.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();


        }
    }
}
