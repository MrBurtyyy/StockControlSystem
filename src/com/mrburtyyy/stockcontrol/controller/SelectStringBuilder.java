/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import javax.swing.JComboBox;

/**
 *
 * @author Alex
 */
public class SelectStringBuilder {
    
    private final JComboBox make, price, stockLevel;
    
    public SelectStringBuilder(JComboBox makeComboBox, JComboBox priceComboBox, JComboBox stockLevelComboBox) {
        this.make = makeComboBox;
        this.price = priceComboBox;
        this.stockLevel = stockLevelComboBox;
    }
    
    public String getMakeFilter() {
        if (make.getSelectedIndex() == 0) {
            
        }
        
        return "Hello World";
    }
    
    public String BuildString() {
        return "Hello World";
    }
    
    
    
    
}
