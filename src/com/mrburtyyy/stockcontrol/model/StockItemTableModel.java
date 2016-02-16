/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class StockItemTableModel extends AbstractTableModel {
    
    private final String[] columnNames = { "ID", "Make", "Model", "Description", "Price", "# Remaining" };
    
    private final List<StockItem> data;
    
    public StockItemTableModel(ArrayList items) {
        this.data = items;
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        StockItem item = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = item.getID();
                break;
            case 1:
                value = item.getMake();
                break;
            case 2:
                value = item.getModel();
                break;
            case 3:
                value = item.getDescription();
                break;
            case 4:
                value = item.getPrice();
                break;
            case 5:
                value = item.getStockLevel();
                break;
                
        }        
        return value;        
    }
    
    @Override
    public String getColumnName(int col) {
        return this.columnNames[col];
    }
    
    @Override
    public Class getColumnClass(int col) {
        return getValueAt(0, col).getClass();
    }
        
    public StockItem getItemAt(int row) {
        return data.get(row);
    }
    
}
