package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query1 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {

            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query1Author = "SELECT * FROM authors order BY firstName, lastName";
            System.out.println("Show all authors ordered BY firstName, lastName");
            ResultSet rs1 = stmt.executeQuery(query1Author);
            while (rs1.next()) {
                int id = rs1.getInt("authorID");
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
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