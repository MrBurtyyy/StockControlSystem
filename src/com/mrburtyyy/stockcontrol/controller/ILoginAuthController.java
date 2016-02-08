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
public interface ILoginAuthController {
        
    public boolean CheckPassword(String hash, String salt, String passwordToCheck, int iterations);
    
    public boolean VerifyLogin(String usernameToCheck, char[] passwordToCheck);
    
}
