/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipd12.Java3.Project.StockTracker;

import javax.swing.table.AbstractTableModel;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class MyTableModel extends AbstractTableModel {
        private static final String[] MYCOLUMNNAMES = {"Symbol", "Quantity", "Entry", "Last", "Change", "Value", "Gain/Loss", "%"};
                
        public MyTableModel(Object[][] data) {
            this.columnNames = MYCOLUMNNAMES;
            this.data = data;
        }
        public String[] columnNames = {};

        public Object[][] data = {};

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }
        
        public void setData(Object[][] data) {
                    this.data = data;
        }
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
     * JTable uses this method to determine the default renderer/ editor for
     * each cell. If we didn't implement this method, then the last column
     * would contain text ("true"/"false"), rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }
    }
