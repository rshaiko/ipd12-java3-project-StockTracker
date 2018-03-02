
package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class Portfolio {
    private long id;
    private String name;
    private boolean isDefault;
    private Type type;
    public enum Type {Real, Test};
    //private long userId;
    private BigDecimal amount;

    public Portfolio(long id, String name, boolean isDefault, Type type, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.isDefault = isDefault;
        this.type = type;
        //this.userId = userId;
        this.amount = amount;
    }

    

    @Override
    public String toString(){
        //we have to skip current amount in Track Mode
        String amountOutput = "";
        if (!amount.toString().equals("0.00")  ){
            amountOutput = ": $" + getAmount().toString();
        }
        return String.format("%d. %s", getId(), getName())+ amountOutput;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the isDefault
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault the isDefault to set
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

   /* public long getUserId() {
        return userId;
    }*/

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
