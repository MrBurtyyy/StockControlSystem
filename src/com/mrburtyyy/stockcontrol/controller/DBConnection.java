package com.mrburtyyy.stockcontrol.controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public final class DBConnection {
    
    private static DBConnection instance = null;
    private Connection conn = null;
    
    public DBConnection() {
        try {
            GetConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBConnection GetInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection GetConnection() throws SQLException {
        if (conn == null || !conn.isValid(100)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
                System.out.println("Connection has been made to database!");
            } catch (SQLException ex) {
                System.out.println("Database connection error: " + ex.toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
    
    
    
}
