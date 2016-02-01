/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class ViewController implements IViewController {
    
    private static ViewController instance = null;
    
    public ViewController() {
        
    }
    
    public static ViewController GetInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        
        return instance;
    }

    @Override
    public void OpenNewAndClose(JFrame open, JFrame close) {
        open.setVisible(true);
        close.setVisible(false);
    }

    @Override
    public void Open(JFrame open) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Close(JFrame close) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
