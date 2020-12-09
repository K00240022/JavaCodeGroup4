/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author K00240022
 */
public class Viewer {

    private String name;
    private String username;
    private String password;
    private String email;
    private String address;
    private int phone;
    private int viewerID;

    public Viewer() {
    }

    public Viewer(String name, String username, String password, String email, String address, int phone, int viewerID) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.viewerID = viewerID;
    }

    public Viewer(String name, String username, String password, String email, String address, int phone) {
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

    public boolean createViewer() {

        ViewerDB viewerdb = new ViewerDB(name, username, password, email, address,phone);
        return viewerdb.createViewer();

    }

    public Viewer Login(String username, String password) {
   
        ViewerDB viewerdb = new ViewerDB();
        return viewerdb.Login(username,password);
        
        
     
    }

    public void print() {
       
        System.out.println("name " + name);
        System.out.println("username " + username);
        System.out.println("email " + email);
        System.out.println("phone " + phone);
        System.out.println("address " + address);
    }

}
