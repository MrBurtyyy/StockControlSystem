/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import java.util.Arrays;

/**
 *
 * @author Alex
 */
public class LoginAuth implements ILoginAuth {

    @Override
    public boolean CheckUsername(String username) {
        return "MrBurtyyy".equals(username);
    }

    @Override
    public boolean CheckPassword(char[] password) {
        return Arrays.equals(password, "password".toCharArray());
    }
    
}
