package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query3 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query3publisher = "UPDATE publishers SET publisherName = 'Anchon123456' WHERE publisherID = 13";
            stmt.executeUpdate(query3publisher);
            System.out.println("The publisher is updated");
            System.out.println("Show all publishers");
            String query = "SELECT * FROM publishers";
            ResultSet rs3 = stmt.executeQuery(query);
            while (rs3.next()) {
                int id = rs3.getInt("publisherID");
                String pubName = rs3.getString("publisherName");
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