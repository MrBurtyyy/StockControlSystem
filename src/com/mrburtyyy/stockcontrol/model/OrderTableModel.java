/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrburtyyy.stockcontrol.model;

import com.mrburtyyy.stockcontrol.orm.Customer;
import com.mrburtyyy.stockcontrol.orm.CustomerOrder;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alex
 */
public class OrderTableModel extends AbstractTableModel {
    
    private final String[] columnNames = { "OrderID", "Customer Name", "Date Placed", "Current Status" };
    
    private final List<CustomerOrder> data;
    
    public OrderTableModel(List<CustomerOrder> newData) {
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
        CustomerOrder order = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = order.getOrderID();
                break;
            case 1:
                value = order.getCustomerID().getTitle() + " " + order.getCustomerID().getFirstName() + 
                        " " + order.getCustomerID().getLastName();
                break;
            case 2:
                value = order.getDate();
                break;
            case 3:
                switch (order.getStatus()) {
                    case 0:
                        value = "Pending";
                        break;
                    case 1:
                        value = "Processing";
                        break;
                    case 2:
                        value = "Dispatched";
                        break;
                    default:
                        value = "Pending";
                        break;
                }      
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
        
    public CustomerOrder getItemAt(int row) {
        return data.get(row);
    }
    
}
