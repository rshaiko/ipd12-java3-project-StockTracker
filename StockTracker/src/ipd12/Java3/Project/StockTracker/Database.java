
package ipd12.Java3.Project.StockTracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Roman Shaiko, Dmitrii Kudrik
 */
public class Database {
    private final static String HOSTNAME = "den1.mysql3.gear.host";
    private final static String DBNAME = "stocktracker";
    private final static String USERNAME = "stocktracker";
    private final static String PASSWORD = "Fx4Sq8vm?!zv";
    
    private final Connection conn;
    
    public Database() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://" + HOSTNAME + "/" + DBNAME,
                USERNAME, PASSWORD); 
        System.out.println("Connection to database established!");
    }

    //R
    void updateByPortfolio(long id) throws UnsupportedOperationException {
        
    }
    
}
