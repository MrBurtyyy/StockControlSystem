/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import com.mrburtyyy.stockcontrol.orm.Item;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alex
 */
public class DBConnection {    
    
    private static DBConnection instance = null;    
    private static EntityManagerFactory emf;
    
    public DBConnection() {
        emf = Persistence.createEntityManagerFactory("StockControlSystemPU");
    }
    
    public static DBConnection GetInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Item FindItemByModel(String itemModel) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> q = em.createNamedQuery("Item.findByModel", Item.class);
        q.setParameter("model", itemModel);
        return q.getSingleResult();
    }
    
    public Item FindItemByID(int itemID) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> q = em.createNamedQuery("Item.findByStockID", Item.class);
        q.setParameter("stockID", itemID);
        return q.getSingleResult();
    }
    
    public List<Item> FindAllItems() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Item> q = em.createNamedQuery("Item.findAll", Item.class);
        return q.getResultList();
    }
    
}
