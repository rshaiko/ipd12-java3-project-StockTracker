
package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public class Portfolio {
    private long id;
    private String name;
    private boolean isDefault;
    private PortType portType;
    public enum PortType {Real, Test};
    private BigDecimal amount;

    public Portfolio(long id, String name, boolean isDefault, PortType portType, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.isDefault = isDefault;
        this.portType = portType;
        this.amount = amount;
    }

    

    @Override
    public String toString(){
        //we have to skip current amount in Track Mode
        String amountOutput = "";
        if (!amount.toString().equals("0.00")  ){
            amountOutput = ": $" + getAmount().toString();
        }
        return String.format("%s", getName())+ amountOutput;
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
    public PortType getPortType() {
        return portType;
    }


    public void setPortType(PortType portType) {
        this.portType = portType;
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
