package by.iba.Query;

import by.iba.Connection.JDBC;

import java.sql.*;
import java.util.*;

public class Query7 {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();
            stmt = JDBC.connection.createStatement();
            String query7publisher = "INSERT INTO publishers (publisherName) VALUES ('NewNewPublisher')";
            stmt.executeUpdate(query7publisher);
            System.out.println("The publisher is added");

            String query7title = "INSERT INTO titles (isbn, title, editionNumber, YEAR, publisherID, price)\n" +
                    "VALUES (\"5555555\", \"The true story\", 12, 2020, \n" +
                    "(select publisherID from publishers where publisherName = 'Dell Books'), 100)";
            stmt.executeUpdate(query7title);
            System.out.println("The title is added");

            String query7authorisbn = "insert INTO authorisbn (authorID, isbn) VALUES \n" +
                    "((select authorID from authors where firstName = 'Nikolay' and lastName = 'Nosov'), 5555555);";
            stmt.executeUpdate(query7authorisbn);
            System.out.println("The authorisbn is added");

            System.out.println("Show added title:");
            String query1 = "SELECT p.publisherName, t.title, t.editionNumber, t.year, t.price \n" +
                    "FROM titles t\n" +
                    "JOIN publishers p\n" +
                    "ON p.publisherID = t.publisherID\n" +
                    "ORDER BY p.publisherName";
            ResultSet rs71 = stmt.executeQuery(query1);
            while (rs71.next()) {
                String publisherName = rs71.getString("publisherName");
                String title = rs71.getString("title");
                Integer editionNumber = rs71.getInt("editionNumber");
                String year = rs71.getString("year");
                String price = rs71.getString("price");
                System.out.println(publisherName + "\t" + title + "\t" + editionNumber + "\t" + year + "\t" + price);
            }

            System.out.println("Show added authors:");
            String query = "SELECT a.firstName, a.lastName, ab.isbn \n" +
                    "FROM authors a\n" +
                    "JOIN authorisbn ab\n" +
                    "ON a.authorID = ab.authorID\n" +
                    "ORDER BY a.firstName";
            ResultSet rs72 = stmt.executeQuery(query);
            while (rs72.next()) {

                String firstName = rs72.getString("firstName");
                String lastName = rs72.getString("lastName");
                int isbn = rs72.getInt("isbn");
                System.out.println(firstName + "\t" + lastName + "\t" + isbn);
            }

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } finally {
            //finally block used to close resources
            JDBC.close();
        }
    }
}
