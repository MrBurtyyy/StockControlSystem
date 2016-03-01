/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.orm;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(catalog = "ecommerce", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ItemID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i ORDER BY i.itemID ASC"),
    @NamedQuery(name = "Item.findByItemID", query = "SELECT i FROM Item i WHERE i.itemID = :itemID"),
    @NamedQuery(name = "Item.findByMake", query = "SELECT i FROM Item i WHERE i.make = :make"),
    @NamedQuery(name = "Item.findByModel", query = "SELECT i FROM Item i WHERE i.model = :model"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByDescription", query = "SELECT i FROM Item i WHERE i.description = :description"),
    @NamedQuery(name = "Item.findByStockLevel", query = "SELECT i FROM Item i WHERE i.stockLevel = :stockLevel"),
    @NamedQuery(name = "Item.findByImageLink", query = "SELECT i FROM Item i WHERE i.imageLink = :imageLink"),
    @NamedQuery(name = "Item.findLastID", query = "SELECT i FROM Item i ORDER BY i.itemID DESC")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false)
    private int itemID;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String make;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String model;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal price;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String description;
    @Basic(optional = false)
    @Column(nullable = false)
    private int stockLevel;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String imageLink;

    public Item() {
    }

    public Item(String model) {
        this.model = model;
    }

    public Item(String model, int itemID, String make, BigDecimal price, String description, int stockLevel, String imageLink) {
        this.model = model;
        this.itemID = itemID;
        this.make = make;
        this.price = price;
        this.description = description;
        this.stockLevel = stockLevel;
        this.imageLink = imageLink;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (model != null ? model.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.model == null && other.model != null) || (this.model != null && !this.model.equals(other.model))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mrburtyyy.stockcontrol.orm.Item[ model=" + model + " ]";
    }
    
}
