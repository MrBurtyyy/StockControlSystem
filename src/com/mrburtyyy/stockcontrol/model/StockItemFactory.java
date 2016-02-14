/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.model;

import com.mrburtyyy.stockcontrol.controller.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class StockItemFactory {
    
    private static ArrayList StockList;    
    
    /**
     * Default constructor
     * Initialises the ArrayList holding the item objects     
     */
    public StockItemFactory() {
        StockList = new ArrayList();
    }
    
    /**
     * NEEDS TO BE UPDATED
     * Creates a new StockItem and adds it to the
     * stockList
     * @param ID
     * @param Make
     * @param Model
     * @param Description
     * @param Price
     * @param StockLevel
     * @param ImageLink
     * @return 
     */
    public static StockItem CreateStockItem(int ID, String Make, String Model, String Description, float Price, int StockLevel, String ImageLink) {
        StockItem item = new StockItem(ID, Make, Model, Description, Price, StockLevel, ImageLink);
        StockList.add(item);
        return item;
    }
    
    /**
     * Returns the stock list as an ArrayList
     * @return
     */
    public ArrayList getStockList() {
        return StockItemFactory.StockList;
    }
    
    public ArrayList updateStockList() {
        PreparedStatement getStock = null;
        String selectStatement = "SELECT StockID, Make, Model, Price, Description, StockLevel FROM stockitems";
        int ID, StockLevel;
        String Model, Make, Description, ImageLink;
        float Price;
        int Iterations = 0;
        
        try {
            Connection conn = DBConnection.GetInstance().GetConnection();
            getStock = conn.prepareStatement(selectStatement);
            
            // Execute select SQL statement
            ResultSet rs = getStock.executeQuery();
            
            while (rs.next()) {
                ID = rs.getInt("ID");
                Make = rs.getString("Make");
                Model = rs.getString("Model");
                Description = rs.getString("Description");
                Price = rs.getBigDecimal("Price").floatValue();
                StockLevel = rs.getInt("StockLevel");
                ImageLink = rs.getString("ImageLink");
                
                StockList.add(CreateStockItem(ID, Make, Model, Description, Price, StockLevel, ImageLink));
            }     
        }   catch (SQLException ex) {
            Logger.getLogger(StockItemFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return StockList;
    }
    
}
