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
import java.util.ArrayList;

/**
 *
 * @author K00240022
 */
public class StudentDB {
    
    private String name;
    private String knumber;
    private String username;
    private String password;
    private String email;
    private int phone;
    private String department;
    private String course;
    private String year;
    private int StudentID;

    public StudentDB() {
    }

    public StudentDB(String name, String knumber, String username, String password, String email, int phone, String department, String course, String year, int StudentID) {
        this.name = name;
        this.knumber = knumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.course = course;
        this.year = year;
        this.StudentID = StudentID;
    }

    public StudentDB(String name, String knumber, String username, String password, String email, int phone, String department, String course, String year) {
        this.name = name;
        this.knumber = knumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.course = course;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getknumber() {
        return knumber;
    }

    public void setknumber(String kNumber) {
        this.knumber = kNumber;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    boolean createStudent() {
        Connection c = DatabaseHelper.getConnection();
        String template = "INSERT INTO Student (name,knumber,username,password,email,phone,department,course,year) VALUES (?,?,?,?,?,?,?,?,?)";
        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                inserter.setString(1, this.name);
                inserter.setString(2, this.knumber);
                inserter.setString(3, this.username);
                inserter.setString(4, this.password);
                inserter.setString(5, this.email);
                inserter.setInt(6, this.phone);
                inserter.setString(7, this.department);
                inserter.setString(8, this.course);
                inserter.setString(9, this.year);
                int i = inserter.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
                return false;
            }
           
        }  
        return true;
    }


    Student Login(String username, String password) {
      
       Student student = null;
       
        System.out.println("Login Student");
        Connection c = DatabaseHelper.getConnection();

        String template = "SELECT * FROM student where username = ? and password = ?";
        
        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                inserter.setString(1, username);
                inserter.setString(2, password);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println(inserter);
                while (resultSet.next()) {
                  
                    student = new Student();
                    student.setName(resultSet.getString("studentID"));
                    student.setName(resultSet.getString("name"));
                    student.setkNumber(resultSet.getString("knumber"));
                    student.setPassword(resultSet.getString("password"));
                    student.setUsername(resultSet.getString("username"));
                    student.setEmail(resultSet.getString("email"));
                    student.setPhone(resultSet.getInt("phone"));
                    student.setDepartment(resultSet.getString("department"));
                    student.setCourse(resultSet.getString("course"));
                    student.setYear(resultSet.getString("year"));
                    
               
                   
                }
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }
        return student;
        
    }
    
    
    
    
    
     }
    

