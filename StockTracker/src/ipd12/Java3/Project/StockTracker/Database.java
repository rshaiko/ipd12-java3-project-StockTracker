package ipd12.Java3.Project.StockTracker;

import static ipd12.Java3.Project.StockTracker.Globals.currentPortfolio;
import static ipd12.Java3.Project.StockTracker.Globals.currentUser;
import ipd12.Java3.Project.StockTracker.Portfolio.PortType;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
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

    ArrayList<Portfolio> getAllPortfolios()throws SQLException {
         String mode="Test";
        if (MainWindow.isRealMode){
            mode="Real";
        }
        String sql = "SELECT * FROM portfolios WHERE userId = " +
                Globals.currentUser.getId() + " AND type = '"+ mode + "'";
        ArrayList<Portfolio> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                long id = result.getLong("id");
                String name = result.getString("name");
                Portfolio.PortType type = Portfolio.PortType.valueOf(result.getString("type"));

                boolean isDef = result.getBoolean("isDefault");
                //long userId = result.getLong("userId");
                BigDecimal amount = result.getBigDecimal("availCash");
                Portfolio portfolio = new Portfolio(id, name, isDef, type, amount);
                list.add(portfolio);
            }
        }
        return list;
    }

    void addPortfolio(Portfolio p) throws SQLException {
        String sql = "INSERT INTO portfolios (name, type, userId, isDefault, availCash) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getPortType()+"");            
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
       PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }

    void updateIsDefaultUserSignUpSetFalse() throws SQLException {
       String sql = "UPDATE users set isDefault = 0 where isDefault >0 and id<"
               +"'" + Globals.currentUser.getId() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }

    public String checkDefaultUser()  {
        String sql = "SELECT username FROM users WHERE isDefault = 1";
        String defUser="";
        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                defUser = result.getString("username");
            } 
        }catch (SQLException e) {
        }
        return defUser;
    }

    ArrayList<Portfolio> getPortfolios() {
        
        String mode="Test";
        if (MainWindow.isRealMode){
            mode="Real";
        }
        String sql = "SELECT * FROM portfolios WHERE userId = " + currentUser.getId() + " AND type = '"+ mode + "'";
        ArrayList <Portfolio> list= new ArrayList<>();
      
        Long qId; String qName; PortType qType; boolean qIsDef; BigDecimal qCash;  
        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                qId = result.getLong("id");
                qName = result.getString("name");
                qType = PortType.valueOf(result.getString("type"));
                qIsDef = (result.getInt("isDefault") == 1);
                qCash = new BigDecimal(result.getString("availCash"));
                list.add(new Portfolio(qId, qName, qIsDef, qType, qCash));
            } 
        }catch (SQLException e) {
        }
        return list;
    }

    ArrayList<Trade> updateByPortfolio() {
        
        String sql = "SELECT t2.*, name, symbol, sector, industry FROM symbols as t1 JOIN\n"
                + "	(SELECT id, symbolId, type, opDate, numberOfShares, sharePrice\n"
                + "	 FROM trades\n"
                + "     WHERE potrfolioId= "+currentPortfolio.getId()+" AND isActive=1) as t2\n"
                + "ON t1.id=t2.symbolId\n"
                + "ORDER BY symbol, type, opDate DESC";
        
        ArrayList <Trade> list= new ArrayList<>();
      
        long id;
        long symbolID;
        Date opDate;
        String name, symbol;
        Trade.TradeType tradeType;
        int numerOfShares;
        BigDecimal sharePrice;
        String sector;
        String industry;
    
        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                id = result.getLong("id");
                symbolID = result.getLong("symbolId");
                name = result.getString("name");
                opDate = result.getDate("opDate");
                symbol = result.getString("symbol");
                tradeType = Trade.TradeType.valueOf(result.getString("type"));
                numerOfShares = result.getInt("numberOfShares");
                sharePrice = new BigDecimal(result.getString("sharePrice"));
                sector = result.getString("sector");
                industry = result.getString("industry");
                list.add(new Trade(id,symbolID,name, opDate,symbol,tradeType,numerOfShares,sharePrice, sector,industry));
            }
        }catch (SQLException e) {
        }
        return list;
    }
    
     void deletePortfolio(Portfolio delPort) throws SQLException {
        Object[] options
                = {
                    "Delete", "Cancel"
                };
        int decision = JOptionPane.showOptionDialog(null,
                "Are you sure you want to delete portfolio: " + delPort.toString() + " and"
                        + " all the data about trades in this portfolio?",
                "Confirm deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        if (decision == JOptionPane.YES_OPTION) {
            String sql = "DELETE  portfolios from portfolios inner join trades"
                    + " on trades.potrfolioId=portfolios.id where portfolios.id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, delPort.getId());
            statement.executeUpdate();

        }
    }

    void updatePortfolio(Portfolio p) throws SQLException {
        String sql = "UPDATE portfolios set name = ?, type = ?,userId=?, isDefault=?,"
                + "availCash=?  where id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, p.getName());
        stmt.setString(2, p.getPortType() + "");
        stmt.setLong(3, Globals.currentUser.getId());
        stmt.setBoolean(4, p.isIsDefault());
        stmt.setBigDecimal(5, p.getAmount());
        stmt.setLong(6, p.getId());
        stmt.executeUpdate();
    }

    int[] checkSymbol(String symbol) {

        String sql = "Select count(*) as cou, if(\n"
                + "(\n"
                + "	Select count(*) from symbols where symbol like '" + symbol + "'\n"
                + ")=1,(Select id from symbols where symbol like '" + symbol + "')\n"
                + "\n"
                + ",0) as indexId from symbols where symbol like '" + symbol + "%'";
        int [] numberReturned={0,0};
        try (Statement stmt = getConn().createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                numberReturned[0] = result.getInt("cou");
                numberReturned[1] = result.getInt("indexId");
            } 
        }catch (SQLException e) {
        }
        return numberReturned;
    }

    void addNewTrade(NewTrade nt) throws SQLException {
        String sql = "INSERT INTO trades (opDate, symbolId, type, numberOfShares, sharePrice, potrfolioId, isActive) VALUES (?, ?, ?, ?, ?, ?, ?)";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dateFormat.format(cal.getTime()));
            stmt.setLong(2, nt.indexId);            
            stmt.setString(3,nt.tradeType.toString());
            stmt.setInt(4, nt.quantity);
            stmt.setBigDecimal(5, nt.price);
            stmt.setLong(6, Globals.currentPortfolio.getId());
            stmt.setInt(7, 1);
            stmt.executeUpdate();
        }
    }

    void deleteTrade(long id) throws SQLException {
        String sql = "DELETE FROM trades WHERE id =" + id;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }
    
     void setDefaultPortfolio()throws SQLException {
         String sql = "UPDATE portfolios set isDefault = 1 where  id="
               +"'" + Globals.currentPortfolio.getId() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }

    void unselectDefaultPorfolio() throws SQLException {
         String sql = "UPDATE portfolios set isDefault = 0 where  id!="
               +"'" + Globals.currentPortfolio.getId() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }

    void setDefaultPortfolioTo0() throws SQLException {
         String sql = "UPDATE portfolios set isDefault = 0 where  id="
               +"'" + Globals.currentPortfolio.getId() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
       
        stmt.executeUpdate();
    }


        void updateTrade(NewTrade nt) throws SQLException {
        String sql = "UPDATE trades SET numberOfShares = ?, sharePrice = ? WHERE id = ? ";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nt.quantity);
            stmt.setBigDecimal(2, nt.price);            
            stmt.setLong(3,nt.indexId);
            stmt.executeUpdate();
        }
    }
}