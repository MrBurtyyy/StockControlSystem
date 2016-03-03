/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Alex
 */
public class ItemController extends Observable {
    
    private List<Observer> observers;
    
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }
    
    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }
    
    @Override
    public synchronized void notifyObservers() {
        this.notifyAll();
    }
    
}
