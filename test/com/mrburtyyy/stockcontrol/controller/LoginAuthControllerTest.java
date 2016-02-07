/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.controller;

import junit.framework.TestCase;

/**
 *
 * @author Alex
 */
public class LoginAuthControllerTest extends TestCase {
    
    public LoginAuthControllerTest(String testName) {
        super(testName);
    }

    /**
     * Test of CheckUsername method, of class LoginAuthController.
     */
    public void testCheckUsername() {
        System.out.println("* LoginAuthControllerTest: testCheckUsername()");
        // Check to make sure it returns TRUE when passing in the correct username
        assertTrue(new LoginAuthController().CheckUsername("MrBurtyyy"));
        // Check to make sure it returns FALSE when passing in the wrong username
        assertFalse(new LoginAuthController().CheckUsername("MrsBurtyyy"));        
    }
    
}
