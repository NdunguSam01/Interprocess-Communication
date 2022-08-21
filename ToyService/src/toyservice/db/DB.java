/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyservice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rees
 */
public class DB {
   static String dbURL = "jdbc:mysql://localhost:3306/toyservice";
   static String username = "root";
   static String password = "";

    public static Connection connect() throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(dbURL, username, password);

        if (conn != null) {
            //System.out.println("Connected");
        }
        return conn;
    }
    
    public static void insert(String sql) throws SQLException, ClassNotFoundException{
        Connection conn = connect();
        PreparedStatement statement = conn.prepareStatement(sql);

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Record was inserted successfully!");
        }
    }
    
    public static ResultSet select(String sql) throws SQLException, ClassNotFoundException{
        Connection conn = connect();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }
    
}
