package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query2 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query2publisher = "INSERT INTO publishers (publisherName) VALUES\n" +
                    "('NewPublisher')";
            stmt.executeUpdate(query2publisher);
            System.out.println("New publisher added");
            System.out.println("Show all publishers");
            String query = "SELECT * FROM publishers";
            ResultSet rs2 = stmt.executeQuery(query);
            while (rs2.next()) {
                int id = rs2.getInt("publisherID");
                String pubName = rs2.getString("publisherName");
                System.out.println(id + "\t" + pubName);
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