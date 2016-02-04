/**
 * This class follows the singleton pattern so there is only
 * one instance of the GUI running at any one time.
 * It is first created when the user logs into the system and
 * is then hidden/shown when it is not needed, and only closed when
 * the entire application is closed.
 */

package com.mrburtyyy.stockcontrol.controller;

import javax.swing.JFrame;

/**
 *
 * @author Alex
 */
public class ViewController implements IViewController {
    
    private static ViewController instance = null;
    
    public ViewController() {
        
    }
    
    public static ViewController GetInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        
        return instance;
    }

    @Override
    public void OpenNewAndClose(JFrame open, JFrame close) {
        open.setVisible(true);
        close.setVisible(false);
    }

    @Override
    public void OpenWindow(JFrame open) {
        open.setVisible(true);
    }

    @Override
    public void CloseWindow(JFrame close) {
        close.setVisible(false);
    }
    
    @Override
    public int CloseWindowAndDispose(JFrame close) {
        try {
            close.setVisible(false);
            close.dispose();
            return 0;
        }
        catch (NullPointerException ex) {
            System.out.println(ex.toString());
            return 1;
        }        
    }
    
    /**
     * Close with error code 0 (Good exit)
     */
    @Override
    public void CloseApplication() {
        System.exit(0);
    }
    
}
