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
public class ViewerDB {

    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private int phone;
    private int viewerID;

    public ViewerDB() {
    }

    public ViewerDB(String name, String username, String password, String email, String address, int phone, int viewerID) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.viewerID = viewerID;
    }

    public ViewerDB(String name, String username, String password, String email, String address, int phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getViewerID() {
        return viewerID;
    }

    public void setViewerID(int viewerID) {
        this.viewerID = viewerID;
    }

    boolean createViewer() {
        Connection c = DatabaseHelper.getConnection();
        String template = "INSERT INTO Viewer (name,username,password,email,phone,address) VALUES (?,?,?,?,?,?)";
        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);

                inserter.setString(1, this.name);
                inserter.setString(2, this.username);
                inserter.setString(3, this.password);
                inserter.setString(4, this.email);
                inserter.setInt(5, this.phone);
                inserter.setString(6, this.address);
                int i = inserter.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
                return false;
            }

        }
        return true;
    }

    Viewer Login(String username, String password) {

        Viewer viewer = null;
        System.out.println("Login Viewer");
        Connection c = DatabaseHelper.getConnection();

        String template = "SELECT * FROM viewer where username = ? and password = ?";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                inserter.setString(1, username);
                inserter.setString(2, password);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println(inserter);
                while (resultSet.next()) {

                    viewer = new Viewer();
                    viewer.setName(resultSet.getString("name"));
                    viewer.setUsername(resultSet.getString("username"));
                    viewer.setPassword(resultSet.getString("password"));
                    viewer.setEmail(resultSet.getString("email"));
                    viewer.setPhone(resultSet.getInt("phone"));
                    viewer.setAddress(resultSet.getString("address"));

                }
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }
        return viewer;
    }
}
