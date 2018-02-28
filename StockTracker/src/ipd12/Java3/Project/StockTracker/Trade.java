package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class Trade {
    long id;
    Date opDate;
    String symbol;
    Type type;
    int numerOfShares;
    BigDecimal opPrice;
    long portfolioId;
    
    enum Type {Buy, Sell, ShortSell, CoverAShort};

    public Trade(long id, Date opDate, String symbol, Type type, int numerOfShares, BigDecimal opPrice, long portfolioId) {
        this.id = id;
        this.opDate = opDate;
        this.symbol = symbol;
        this.type = type;
        this.numerOfShares = numerOfShares;
        this.opPrice = opPrice;
        this.portfolioId = portfolioId;
    }
    
    
}
