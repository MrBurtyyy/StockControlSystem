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
    private String description;
    private final int stockLevel;
    
    public StockItem(int p1, String p2, String p3, int p4) {
        this.id = p1;
        this.name = p2;
        this.description = p3;
        this.stockLevel = p4;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockLevel() {
        return stockLevel;
    }
    
}
