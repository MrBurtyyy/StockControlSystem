/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import javax.management.timer.Timer;

/**
 *
 * @author Alex
 */
public class TimedUpdateController {
    
    private static TimedUpdateController instance;
    
    private Timer timi = null;
    
    private TimedUpdateController() {
        instance = new TimedUpdateController();
        timi = new Timer();
        timi.start();
    }
    
    public TimedUpdateController GetInstance() {
        if (instance == null) {
            instance = new TimedUpdateController();
        }
        
        return instance;
    }
    
    
    
}
