
package ipd12.Java3.Project.StockTracker;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */

public abstract class Portfolio {
    long id;
    String name;
    boolean isDefault;
    public Type type;
    enum Type {Real, Test};
}
