
package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class Portfolio {
    public long id;
    public String name;
    public boolean isDefault;
    public Type type;
    public enum Type {Real, Test};
    public BigDecimal amount;

    public Portfolio(long id, String name, boolean isDefault, Type type, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.isDefault = isDefault;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public String toString(){
        //we have to skip current amount in Track Mode
        String amountOutput = "";
        if (!amount.toString().equals("0.00")  ){
            amountOutput = ": $" + amount.toString();
        }
        return String.format("%d. %s", id, name)+ amountOutput;
    }
}
