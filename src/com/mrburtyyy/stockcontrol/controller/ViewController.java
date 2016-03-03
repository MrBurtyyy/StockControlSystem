/**
 * This class follows the singleton pattern so there is only
 * one instance of the GUI running at any one time.
 * It is first created when the user logs into the system and
 * is then hidden/shown when it is not needed, and only closed when
 * the entire application is closed.
 */

package com.mrburtyyy.stockcontrol.controller;

import com.mrburtyyy.stockcontrol.view.AddNewItemGUI;
import java.awt.Component;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class ViewController implements IViewController {
    
    private static ViewController instance = null;
    
    public ViewController() {
        
    }
    
    /**
     * Follows the singleton pattern, and creates a
     * new instance of the object if there is not one
     * currently in the system, then returns the instance
     * of the object.
     * @return 
     */
    public static ViewController GetInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        
        return instance;
    }
    
    @Override
    public void OpenAddItemAndObserver(Observer observer) {
        AddNewItemGUI gui = new AddNewItemGUI();
        gui.addObserver(observer);
    }
    
    /**
     * Shows an error message using the JOptionPane.
     * @param comp
     * @param errorMessage 
     */
    public void ShowErrorMessage(Component comp,String errorMessage) {
        JOptionPane.showMessageDialog(comp, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Opens a new window and sets it to visible,
     * and closes the old window by making it not
     * visible.
     * @param open
     * @param close 
     */
    @Override
    public void OpenNewAndClose(JFrame open, JFrame close) {
        open.setVisible(true);
        close.setVisible(false);
    }

    /**
     * Opens a new window and sets it to be visible.
     * @param open 
     */
    @Override
    public void OpenWindow(JFrame open) {
        open.setVisible(true);
    }
    
    /**
     * Closes a window by hiding it, but does
     * not dispose of the object.
     * @param close 
     */
    @Override
    public void CloseWindow(JFrame close) {
        close.setVisible(false);
    }
    
    /**
     * Closes the window and disposes of the object.
     * @param close
     * @return 
     */
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
