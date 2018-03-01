
package ipd12.Java3.Project.StockTracker;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */
public class PortfolioTrack extends Portfolio {

    public PortfolioTrack(long id, String name, boolean isDefault, Type type) {
        super.id = id;
        super.name = name;
        super.isDefault = isDefault;
        super.type = type;
    }
    @Override
    public String toString(){
        return String.format("%d. %s", id, name);
    }
}
