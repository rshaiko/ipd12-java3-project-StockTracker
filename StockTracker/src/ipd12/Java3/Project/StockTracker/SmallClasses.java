
package ipd12.Java3.Project.StockTracker;

import ipd12.Java3.Project.StockTracker.Trade.TradeType;
import java.math.BigDecimal;

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