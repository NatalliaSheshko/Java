package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query6 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query6author = "UPDATE authors SET firstName = 'Michalay' WHERE authorID = 31";
            stmt.executeUpdate(query6author);
            System.out.println("The author is updated");
            System.out.println("Show all authors");
            String query = "SELECT * FROM authors";
            ResultSet rs6 = stmt.executeQuery(query);
            while (rs6.next()) {
                int id = rs6.getInt("authorID");
                String firstName = rs6.getString("firstName");
                String lastName = rs6.getString("lastName");
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
