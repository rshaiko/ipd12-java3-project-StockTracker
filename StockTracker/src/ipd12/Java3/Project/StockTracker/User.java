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
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.isDefault = isDefault;
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