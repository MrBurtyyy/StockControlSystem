/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import com.mrburtyyy.stockcontrol.orm.Item;
import javax.persistence.Query;
import javax.swing.JComboBox;

/**
 *
 * @author Alex
 */
public class QueryStringBuilder {
    
    private final JComboBox make, price, stockLevel;
    
    private boolean first = true;
    
    public QueryStringBuilder(JComboBox makeComboBox, JComboBox priceComboBox, JComboBox stockLevelComboBox) {
        this.make = makeComboBox;
        this.price = priceComboBox;
        this.stockLevel = stockLevelComboBox;
    }
    
    /**
     * Checks the selected index of the item make ComboBox
     * and returns the correct part of the SELECT String.
     * @return 
     */
    public String getMakeFilter() {
        
        // If the selected index is 0, return an empty string.
        if (make.getSelectedIndex() == 0) {
            return "";
        }
        
        // If this is the first part of the SELECT string to be added,
        // return it without a comma.
        if (first) {
            first = false;
            return " i.make = '" + make.getSelectedItem().toString() + "'";
        }
        
        // If all other IF's failed, return the SELECT string with a comma.
        return "AND i.make = '" + make.getSelectedItem().toString() + "'";
    }
    
    /**
     * Checks the selected index of the item make ComboBox
     * and returns the correct part of the SELECT String.
     * @return 
     */
    public String getPriceFilter() {
        String result = "";
        
        if (first && price.getSelectedIndex() != 0) {
            result += " ";
            first = false;
        } else {
            result += "AND ";
        }
        
        switch (price.getSelectedIndex()) {
            case 1:
                result += "i.price < 50";
                break;
            case 2:
                result += "i.price >= 50 AND i.price <= 150";
                break;
            case 3:
                result += "i.price >= 151 AND i.price <= 250";
                break;
            case 4:
                result += "i.price >= 251 AND i.price <= 350";
                break;
            case 5:
                result += "i.price > 350";
                break;
            default:
                result = "";
                break;
        }
        
        return result;
    }
    
    public String getStockLevelFilter() {
        String result = "";
        
        if (first && stockLevel.getSelectedIndex() != 0) {
            result += " ";
            first = false;
        } else {
            result += "AND ";
        }
        
        switch (stockLevel.getSelectedIndex()) {
            case 1:
                result += "i.stockLevel < 10";
                break;
            case 2:
                result += "i.stockLevel >= 11 AND i.stockLevel <= 20";
                break;
            case 3:
                result += "i.stockLevel >= 21 AND i.stockLevel <= 30";
                break;
            case 4:
                result += "i.stockLevel >= 31 AND i.stockLevel <= 40";
                break;
            case 5:
                result += "i.stockLevel >= 41 AND i.stockLevel <= 50";
                break;
            case 6:
                result += "i.stockLevel > 50";
                break;
            default:
                result = "";
                break;
        }
        
        return result;
    }
    
    /**
     * Builds a query based off the filter ComboBoxes.
     * @return 
     */
    public Query BuildQuery() {
        String queryString = "";
        
        if (IsNoFilter()) {
            queryString = "SELECT i FROM Item i";
        } else {
            queryString = "SELECT i FROM Item i WHERE" + getMakeFilter() + getPriceFilter() + getStockLevelFilter();
        }
        
        Query query = DBConnection.GetInstance().GetEntityManagerFactory().createEntityManager().createQuery(queryString, Item.class);
        return query;
    }
    
    /**
     * Checks to see if all of the filter ComboBoxes are set on 'No Filter'
     * @return 
     */
    public Boolean IsNoFilter() {
        return make.getSelectedIndex() == 0 && price.getSelectedIndex() == 0 && stockLevel.getSelectedIndex() == 0;
    }
    
    
    
    
}
