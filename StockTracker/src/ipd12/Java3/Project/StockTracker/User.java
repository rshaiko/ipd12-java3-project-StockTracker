
package ipd12.Java3.Project.StockTracker;

public class User {
    public static long id;
    public String name;
    String userName;
    String password;
    public boolean isDefault;

    public User(long id, String name, String userName, String password, boolean isDefault) {
        setId(id);
        setName(name);
        setUserName(userName);
        setPassword(password);
        isIsDefault();
    }

    public static void setId(long id) {
        User.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
         
        
        this.userName = userName;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
       
        
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        
        this.password = password;
    }

    public long getId() {
        return id;
    }
    
    
}