
package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */
public class PortfolioTest extends Portfolio {
    BigDecimal amount;
    public PortfolioTest(long id, String name, boolean isDefault, Type type, BigDecimal amount) {
        super.id = id;
        super.name = name;
        super.isDefault = isDefault;
        super.type = type;
        this.amount = amount;
    }
    @Override
    public String toString(){
        return String.format("%d. %s %s", id, name, amount.toString());
    }
}
