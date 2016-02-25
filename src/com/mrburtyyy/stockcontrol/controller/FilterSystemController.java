/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import com.mrburtyyy.stockcontrol.orm.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class FilterSystemController {
    
    public void FilterSystemController() {
        
    }
    
    /**
     * Iterates through every item and adds one of each
     * make into an ArrayList to be used in a ComboBox.
     * @return 
     */
    public ArrayList GetMakes() {
        ArrayList itemMakes = new ArrayList();
        itemMakes.add("No Filter");
        List<Item> itemList = DBConnection.GetInstance().FindAllItems();
        for (Item temp : itemList) {
            if (!itemMakes.contains(temp.getMake())) {
                itemMakes.add(temp.getMake());
            }
        }
        
        return itemMakes;
    }
    
    /**
     * Adds a set of strings into an ArrayList to be
     * used in a ComboBox.
     * @return 
     */
    public ArrayList GetPrices() {
        ArrayList priceList = new ArrayList();
        priceList.add("No Filter");
        priceList.add("Less than £50");
        priceList.add("£50-£150");
        priceList.add("£151 - £250");
        priceList.add("£251 - £350");
        priceList.add("Greater than £350");
        return priceList;
    }
    
    /**
     * Adds a set of strings into an ArrayList to be
     * used in a ComboBox for the price filter.
     * @return 
     */
    public ArrayList GetStockLevel() {
        ArrayList stockLevelList = new ArrayList();
        stockLevelList.add("No Filter");
        stockLevelList.add("Less than 10");
        stockLevelList.add("11-20");
        stockLevelList.add("21-30");
        stockLevelList.add("31-40");
        stockLevelList.add("41-50");
        stockLevelList.add("Greater than 50");
        return stockLevelList;
    }
    
}
