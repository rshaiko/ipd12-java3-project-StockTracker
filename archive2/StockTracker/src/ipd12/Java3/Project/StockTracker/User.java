/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipd12.Java3.Project.StockTracker;

/**
 *
 * @author 1796143
 */
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
         if (!userName.matches("[A-Za-z0-9_-]{3,10}")) {
                    throw new IllegalArgumentException("Username must contain  "
                            + " minimum 3 and maximum 10 characters, can be made up of letters, numbers, underscore and hyphen");
                }
        
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
        if (!name.matches("[A-Za-z]{2,25}")) {
                    throw new IllegalArgumentException("Name must contain"
                            + " letters only and be between 2 and 15 characters");
                }
        
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
//         if (!name.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{5,10}")) {
//                    throw new IllegalArgumentException("Password must be between  5 and 10 characters, contain at "
//                            + "least one uppercase letter, one lowercase letter and one number");
//                }
        
        this.password = password;
    }

    public long getId() {
        return id;
    }
    
    
}