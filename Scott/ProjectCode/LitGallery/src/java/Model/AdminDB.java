/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author K00240022
 */
public class AdminDB {
    private String username;
    private String name;
    private String password;
    private String email;
    private String phone;
    private int adminID;

    public AdminDB() {
    }

    public AdminDB(String name, String password, String email, String phone, int adminID) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.adminID = adminID;
    }

    public AdminDB(String name, String password, String email, String phone) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    //
    public Admin Login(String username, String password) {
      Admin admin =  null;
        
       
        System.out.println("Login Admin");
        Connection c = DatabaseHelper.getConnection();

        String template = "SELECT * FROM admin where username = ? and password = ?";
        
        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                inserter.setString(1, username);
                inserter.setString(2, password);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println(inserter);
                while (resultSet.next()) {
                  
                    
                    admin = new Admin();
                    admin.setAdminID(resultSet.getInt("adminID"));
                    admin.setName(resultSet.getString("name"));
                    admin.setPassword(resultSet.getString("password"));
                    admin.setEmail(resultSet.getString("email"));
                    admin.setPhone(resultSet.getString("phone"));
                    
                    
                   
                    
               
                   
                }
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }
        return admin;
        
       

    }
    
    
    
    
    
    
}
