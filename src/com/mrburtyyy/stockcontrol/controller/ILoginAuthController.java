/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

/**
 *
 * @author Alex
 */
public interface ILoginAuth {
    
    public boolean CheckUsername(String username);
    
    public boolean CheckPassword(char[] password);   
    
}
