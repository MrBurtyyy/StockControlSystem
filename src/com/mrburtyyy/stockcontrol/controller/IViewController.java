/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public interface IViewController {
    
    void OpenNewAndClose(JFrame open, JFrame close);
    
    public void OpenAddItemAndObserver(Observer observer);
    
    void OpenWindow(JFrame open);
    
    void CloseWindow(JFrame close);
    
    void CloseApplication();
    
    int CloseWindowAndDispose(JFrame close);
    
}
