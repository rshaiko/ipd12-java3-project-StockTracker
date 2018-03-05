package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class Trade {
    long id;
    long symbolID;
    Date opDate;
    String symbol;
    TradeType tradeType;
    int numerOfShares;
    BigDecimal sharePrice;
    String sector;
    String industry;
    
    
    enum TradeType {Buy, ShortSell};

    public Trade(long id, long symbolID, Date opDate, String symbol, TradeType tradeType, int numerOfShares, BigDecimal sharePrice, String sector, String industry) {
        this.id = id;
        this.symbolID = symbolID;
        this.opDate = opDate;
        this.symbol = symbol;
        this.tradeType = tradeType;
        this.numerOfShares = numerOfShares;
        this.sharePrice = sharePrice;
        this.sector = sector;
        this.industry = industry;
    }

    
    
    
}
