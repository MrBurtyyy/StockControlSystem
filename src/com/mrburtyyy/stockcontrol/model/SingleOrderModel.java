/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.model;

import com.mrburtyyy.stockcontrol.orm.Item;
import com.mrburtyyy.stockcontrol.orm.OrderItems;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class SingleOrderModel extends AbstractTableModel {
    
    private final String[] columnNames = { "Item ID", "Item Make", "Item Model", "Quantity", "Price" };
    
    private final List<Item> data;
    
    public SingleOrderModel(List<Item> newData) {
        this.data = newData;
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
        Item order = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = order.getItemID();
                break;
            case 1:
                order.getMake();
                break;
            case 2:
                order.getModel();
                break;
            case 3:
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
        
    public Item getItemAt(int row) {
        return data.get(row);
    }
    
}
