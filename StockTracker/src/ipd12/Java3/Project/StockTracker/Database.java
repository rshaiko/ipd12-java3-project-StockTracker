package ipd12.Java3.Project.StockTracker;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

                //char[] password = (result.getString("password")).toCharArray();
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

    void signUp(String userN, String pass, String passConf, boolean def)throws SQLException {
        String sql = "INSERT INTO users (name, username, password, isDefault) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userN);
            stmt.setString(2, pass);
            stmt.setString(3, passConf);
            stmt.setBoolean(4,def);
            
            
            
            stmt.executeUpdate();
        }
    }

     void updateByPortfolio(long id) throws UnsupportedOperationException {
        
    }
}
