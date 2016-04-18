/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import com.mrburtyyy.stockcontrol.orm.CustomerOrder;
import com.mrburtyyy.stockcontrol.orm.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alex
 */
public class DBConnection {
    
    // START VARIABLE DECLARATION

    private static DBConnection instance = null;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    // END VARIABLE DECLARATION

    public DBConnection() {
        emf = Persistence.createEntityManagerFactory("StockControlSystemPU");
        em = emf.createEntityManager();
    }

    /**
     * Returns and instance of the Singleton class of DBConnection.
     *
     * @return
     */
    public static DBConnection GetInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    /**
     * Returns and instance of the EntityManagerFactory.
     *
     * @return
     */
    public EntityManagerFactory GetEntityManagerFactory() {
        return emf;
    }

    /**
     * Executes a supplied query and returns a List of Objects that meet the
     * criteria supplied in the Query.
     *
     * @param query
     * @return
     */
    public List<Item> ExecuteQuery(Query query) {
        return query.getResultList();
    }
    
    public List<Item> FindItemsByOrder(int orderID) {
        TypedQuery<Item> q = em.createNamedQuery("OrderItems.findByOrderID", Item.class);
        return q.getResultList();
    }

    /**
     * Uses a TypedQuery to find a singular Item by its model code, returns an
     * Item object.
     *
     * @param itemModel
     * @return
     */
    public Item FindItemByModel(String itemModel) {
        TypedQuery<Item> q = em.createNamedQuery("Item.findByModel", Item.class);
        q.setParameter("model", itemModel);
        return q.getSingleResult();
    }

    /**
     * Uses a TypedQuery to find a singular Item by its StockID, returns an Item
     * object.
     *
     * @param itemID
     * @return
     */
    public Item FindItemByID(int itemID) {
        TypedQuery<Item> q = em.createNamedQuery("Item.findByItemID", Item.class);
        q.setParameter("itemID", itemID);
        return q.getSingleResult();
    }

    /**
     * Uses a TypedQuery to find all Items in the database and returns a List<>
     * with all Items contained.
     *
     * @return
     */
    public List<Item> FindAllItems() {
        TypedQuery<Item> q = em.createNamedQuery("Item.findAll", Item.class);
        return q.getResultList();
    }
    
    /**
     * Uses a TypedQuery to find all Customer Orders in the database
     * and returns a List<> with all CustomerOrders contained.
     * @return 
     */
    public List<CustomerOrder> FindAllOrders() {
        TypedQuery<CustomerOrder> q = em.createNamedQuery("CustomerOrder.findAll", CustomerOrder.class);
        return q.getResultList();
    }
    
    public CustomerOrder GetOrderByID(int orderID) {
        TypedQuery<CustomerOrder> q = em.createNamedQuery("CustomerOrder.findByOrderID", CustomerOrder.class);
        q.setParameter("orderID", orderID);
        return q.getSingleResult();
    }

    /**
     * Using the Java Persistence API, add an Item to the database by persisting
     * it. Rolls back transaction if error occurs.
     *
     * @param make
     * @param stockID
     * @param model
     * @param price
     * @param description
     * @param stockLevel
     * @param imageLink
     */
    public void AddItem(String make, int stockID, String model, BigDecimal price, String description, int stockLevel, String imageLink) {
        Item item = new Item(stockID, make, model, price, description, stockLevel, imageLink);
        em.getTransaction().begin();
        try {
            em.persist(item);
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
    }
    
    public List<CustomerOrder> GetProcessingPendingOrders() {
        TypedQuery<CustomerOrder> q = em.createNamedQuery("CustomerOrder.findProcessingPendingOrder", CustomerOrder.class);
        return q.getResultList();
    }
    
    /**
     * Updates the status of an order.
     * @param order
     * @param status 
     */
    public void UpdateOrderStatus(CustomerOrder order, int status) {
        em.getTransaction().begin();
        try {
            order.setStatus(status);
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
        
        em.getTransaction().commit();
    }
    
    /**
     * Update the quantity of stock in the warehouse.
     * @param itemID
     * @param newQuantity 
     */
    public void UpdateQuantity(int itemID, int newQuantity) {
        Item i = em.find(Item.class, itemID);
        
        int newStockLevel = i.getStockLevel() - newQuantity;
        
        i.setStockLevel(newStockLevel);
    }

}
