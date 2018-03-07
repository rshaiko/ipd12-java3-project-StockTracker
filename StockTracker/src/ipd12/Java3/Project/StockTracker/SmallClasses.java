
package ipd12.Java3.Project.StockTracker;

import ipd12.Java3.Project.StockTracker.Trade.TradeType;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class SmallClasses {
}

//to create new Trade
class NewTrade {
    long indexId;
    TradeType tradeType;
    BigDecimal price;
    int quantity;

    public NewTrade(long indexId, TradeType tradeType, BigDecimal price, int quantity) {
        this.indexId = indexId;
        this.tradeType = tradeType;
        this.price = price;
        this.quantity = quantity;
    }

    NewTrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 class CurrencyTableCellRenderer extends DefaultTableCellRenderer {

    private static final NumberFormat FORMAT = NumberFormat.getCurrencyInstance();

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        final Component result = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            setHorizontalAlignment(JLabel.RIGHT);
            setText(FORMAT.format(value));
        } else {
            setText("");
        }
        return result;
    }
}
class PercentTableCellRenderer extends DefaultTableCellRenderer {

    private static final NumberFormat FORMAT = NumberFormat.getPercentInstance();

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        final Component result = super.getTableCellRendererComponent(table, value,
                isSelected, hasFocus, row, column);
        if (value instanceof Number) {
            setHorizontalAlignment(JLabel.RIGHT);
            setText(FORMAT.format(value));
        } else {
            setText("");
        }
        return result;
    }
}