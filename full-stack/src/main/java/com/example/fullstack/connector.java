package com.example.fullstack;
import java.sql.*;

public class connector {
    public static Connection con(){
         final String URL = "jdbc:mysql://localhost:3306/book_management";
         final String USER = "root";
         final String PASSWORD = "1221";
        try{
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;
        } catch(SQLException e)

        {
            return null;


        }
    }



}