package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class Trade {
    long id;
    long symbolID;
    String name;
    Date opDate;
    String symbol;
    TradeType tradeType;
    int numerOfShares;
    BigDecimal sharePrice;
    String sector;
    String industry;
    
    
    enum TradeType {Buy, ShortSell};
        
        //to store current trades
    public Trade(long id, long symbolID, String name, Date opDate, String symbol, TradeType tradeType, int numerOfShares, BigDecimal sharePrice, String sector, String industry) {
        this.id = id;
        this.symbolID = symbolID;
        this.name = name;
        this.opDate = opDate;
        this.symbol = symbol;
        this.tradeType = tradeType;
        this.numerOfShares = numerOfShares;
        this.sharePrice = sharePrice;
        this.sector = sector;
        this.industry = industry;
    }

        //to create new trade
    public Trade(long symbolID, TradeType tradeType, int numerOfShares, BigDecimal sharePrice) {
        this.id = 0;
        this.symbolID = symbolID;
        this.name = "";
        this.opDate = Date.valueOf(LocalDate.now());
        this.symbol = "";
        this.tradeType = tradeType;
        this.numerOfShares = numerOfShares;
        this.sharePrice = sharePrice;
        this.sector = "";
        this.industry = "";
        
    }
    

    
    
    
}
