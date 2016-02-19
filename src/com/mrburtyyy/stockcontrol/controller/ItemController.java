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
import javax.persistence.Query;

/**
 *
 * @author Alex
 */
public class ItemController {
    
    public List<Item> updateInformation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StockControlSystemPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT i FROM Item i");
        return q.getResultList();
    }
    
}
