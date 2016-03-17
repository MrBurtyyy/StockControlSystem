/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import com.mrburtyyy.stockcontrol.view.StockGUI;
import com.mrburtyyy.stockcontrol.view.ViewOrderGUI;
import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public interface IViewController {
    
    void OpenNewAndClose(JFrame open, JFrame close);
    
    void OpenNewItemFrame(StockGUI toBeUpdated);
    
    void OpenViewOrderFrame(StockGUI toBeUpdated, ViewOrderGUI orderGUI);
    
    void OpenWindow(JFrame open);
    
    void CloseWindow(JFrame close);
    
    void CloseApplication();
    
    int CloseWindowAndDispose(JFrame close);
    
}
