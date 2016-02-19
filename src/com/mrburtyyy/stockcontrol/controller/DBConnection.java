/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

/**
 *
 * @author Alex
 */
public class DBConnection implements Runnable {
    
    private Thread t;
    private final String threadName;
    
    public static final DBConnection instance = new DBConnection();
    
    public DBConnection() {
        
    }
    
    public DBConnection GetInstance() {
        return instance;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
