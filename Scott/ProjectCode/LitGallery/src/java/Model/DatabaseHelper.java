/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elizabeth.Bourke
 */
public class DatabaseHelper {
    
    public static Connection getConnection() {
        
        String host = "localhost";
        String dbName = "litgallery";
        int port = 3306;
        String mySqlUrl = "jdbc:mysql://" + host + ":" + port+ "/" + dbName;

        Properties userInfo = new Properties();
        userInfo.put("user", "root");
        userInfo.put("password", "");
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection(mySqlUrl, userInfo);

            return connection;

        } catch (Exception ex) {
            System.out.println("Error: database helper class" + ex);
            
        }
        return null;
    }

    }

    

