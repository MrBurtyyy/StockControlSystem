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
    
    // END VARIABLE DECLARATION

    public DBConnection() {
        emf = Persistence.createEntityManagerFactory("StockControlSystemPU");
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
        EntityManager em = emf.createEntityManager();
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
        EntityManager em = emf.createEntityManager();
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
        EntityManager em = emf.createEntityManager();
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
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> q = em.createNamedQuery("Item.findAll", Item.class);
        return q.getResultList();
    }
    
    /**
     * Uses a TypedQuery to find all Customer Orders in the database
     * and returns a List<> with all CustomerOrders contained.
     * @return 
     */
    public List<CustomerOrder> FindAllOrders() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CustomerOrder> q = em.createNamedQuery("CustomerOrder.findAll", CustomerOrder.class);
        return q.getResultList();
    }
    
    public CustomerOrder GetOrderByID(int orderID) {
        EntityManager em = emf.createEntityManager();
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
        Item item = new Item(model, stockID, make, price, description, stockLevel, imageLink);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(item);
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
    }

}
