/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.model;

/**
 *
 * @author Alex
 */
public class StockItem {
    
    private final int id;
    private final String name;
    private final String description;
    private int stockLevel;
    
    
    /**
     * Sets the variables to their initial data.
     * @param p1
     * @param p2
     * @param p3
     * @param p4 
     */
    public StockItem(int p1, String p2, String p3, int p4) {
        this.id = p1;
        this.name = p2;
        this.description = p3;
        this.stockLevel = p4;
    }
    
    // ACCESSOR METHODS
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    
    // END ACCESSOR METHODS
    
}
