/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.model;

import java.util.ArrayList;

/**
 *
 * @author Alex
 */
public class StockItemFactory {
    
    private ArrayList stockList;
    
    
    /**
     * Default constructor
     * init the item list
     */
    public StockItemFactory() {
        stockList = new ArrayList();
    }
    
    /**
     * NEEDS TO BE UPDATED
     * Creates a new StockItem and adds it to the
     * stockList
     * @param id
     * @param name
     * @param description
     * @param stockLevel
     * @return 
     */
    public StockItem CreateStockItem(int id, String name, String description, int stockLevel) {
        return new StockItem(id, name, description, stockLevel);
    }
    
}
