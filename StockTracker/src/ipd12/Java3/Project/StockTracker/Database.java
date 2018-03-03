package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

class RecordNotFoundException extends SQLException {

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String msg) {
        super(msg);
    }

    public RecordNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

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

    public Connection getConn() {
        return conn;
    }

    boolean checkLogin(String userN, String pass) throws SQLException {

        String sql = "SELECT * FROM users WHERE username=" + "'" + userN + "'";

        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String username = result.getString("username");

                
                String password = result.getString("password");
                boolean isDef = result.getBoolean("isDefault");

                if (password.equals(pass)) {

                    return true;
                } else {
                    return false;
                }
            } else {
                throw new RecordNotFoundException("Username or password are incorrect!");

                // return null;
            }
        }
    }

    void signUp(String name, String userN, String pass, boolean def)throws SQLException {
        String sql = "INSERT INTO users (name, username, password, isDefault) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, userN);
            stmt.setString(3, pass);
            stmt.setBoolean(4,def);
            
            
            
            stmt.executeUpdate();
        }
    }

     void updateByPortfolio(long id) throws UnsupportedOperationException {
        
    }

    ArrayList<Portfolio> getAllPortfolios()throws SQLException {
        String sql = "SELECT * FROM portfolios";
        ArrayList<Portfolio> list = new ArrayList<>();
        
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                Portfolio.Type type = Portfolio.Type.valueOf(result.getString("type"));
                
                boolean isDef = result.getBoolean("isDefault");
                //long userId = result.getLong("userId");
                BigDecimal amount = result.getBigDecimal("availCash");
                Portfolio portfolio = new Portfolio(id, name,isDef, type, amount);
                list.add(portfolio);
            }
        }
        return list;
    }

    void addPortfolio(Portfolio p) throws SQLException {
        String sql = "INSERT INTO portfolios (name, type, userId, isDefault, availCash) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getType()+"");            
            stmt.setLong(3,Globals.currentUser.getId());
            
            stmt.setBoolean(4, p.isIsDefault());
            stmt.setBigDecimal(5, p.getAmount());
            
            
            
            stmt.executeUpdate();
        }
    }

    long getCurrentUserId(String userN)  throws SQLException {
       String sql = "SELECT * FROM users WHERE username=" + "'" + userN + "'";

        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                long id = result.getInt("id");
              
               return id;
            } else {
                throw new RecordNotFoundException("Record not found!");

               
            }
        }
    }

    String getCurrentUserName(String userN)throws SQLException {
       String sql = "SELECT * FROM users WHERE username=" + "'" + userN + "'";

        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                long id = result.getInt("id");
                String name = result.getString("name");
                String username = result.getString("username");                             
                String password = result.getString("password");
                boolean isDef = result.getBoolean("isDefault");

               return username;
            } else {
                throw new RecordNotFoundException("Record not found!");

               
            }
        }
    }

    void updateIsDefaultUserSetFalse() throws SQLException {
       String sql = "UPDATE users set isDefault = 0 where isDefault >0";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }

    void updateIsDefaultUserSetTrue()throws SQLException {
       String sql = "UPDATE users set isDefault = 1 where id ="+  "'" + Globals.currentUser.getId() + "'";
        System.out.println(Globals.currentUser.getId());
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }

    void updateIsDefaultUserSignUpSetFalse() throws SQLException {
       String sql = "UPDATE users set isDefault = 0 where isDefault >0 and id<"
               +"'" + Globals.currentUser.getId() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }
}
