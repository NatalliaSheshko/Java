package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query4 {

    public static void main(String[] args) {


        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query4publisher = "SELECT * FROM titles join publishers \n" +
                    "ON titles.publisherID = publishers.publisherID\n" +
                    "WHERE publishers.publisherID = 1\n" +
                    "ORDER BY titles.title;";
            System.out.println("Show books the publisher:");
            ResultSet rs4 = stmt.executeQuery(query4publisher);
            while (rs4.next()) {
                String title = rs4.getString("title");
               System.out.println(title);
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
