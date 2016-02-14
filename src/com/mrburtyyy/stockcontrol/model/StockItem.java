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
    
    private final int ID;
    private final String Make;
    private final String Model;
    private final String Description;
    private float Price;
    private int StockLevel;
    private final String ImageLink;    
    
    /**
     * Sets the variables to their initial data. 
     * @param ID
     * @param Make
     * @param Model
     * @param Description
     * @param Price
     * @param StockLevel
     * @param ImageLink
     */
    public StockItem(int ID, String Make, String Model, String Description, float Price, int StockLevel, String ImageLink) {
        this.ID = ID;
        this.Make = Make;
        this.Model = Model;
        this.Description = Description;
        this.Price = Price;
        this.StockLevel = StockLevel;
        this.ImageLink = ImageLink;    }
    
        
    // <editor-fold defaultstate="collapsed" desc="Mutator Methods">

    /**
     *
     * @return
     */
    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(int StockLevel) {
        this.StockLevel = StockLevel;
    }

    public int getID() {
        return ID;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public String getDescription() {
        return Description;
    }

    public String getImageLink() {
        return ImageLink;
    }
    
    // </editor-fold>
    
}
