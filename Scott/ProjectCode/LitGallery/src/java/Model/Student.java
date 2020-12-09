/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author K00240022
 */
public class Student {

    private String name;
    private String kNumber;
    private String username;
    private String password;
    private String email;
    private int phone;
    private String department;
    private String course;
    private String year;
    private int StudentID;

    public Student() {
    }

    public Student(String name, String kNumber, String username, String password, String email, int phone, String department, String course, String year, int StudentID) {
        this.name = name;
        this.kNumber = kNumber;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.course = course;
        this.year = year;
        this.StudentID = StudentID;
    }

    public Student(String name, String kNumber, String username, String password, String email, int phone, String department, String course, String year) {
        this.name = name;
        this.kNumber = kNumber;
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

    public String getkNumber() {
        return kNumber;
    }

    public void setkNumber(String kNumber) {
        this.kNumber = kNumber;
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

    public boolean createStudent() {

        StudentDB studentdb = new StudentDB(name, kNumber, username, password, email, phone, department, course, year);
        return studentdb.createStudent();

    }
//     public ArrayList<Student> findAllStudents() { 
//    StudentDB studentdb = new StudentDB();
//    
//   return studentdb.findAllStudents();
//        
//     
//    }

    public void print() {

        System.out.println("name " + name);
        System.out.println("knumber " + kNumber);
        System.out.println("username " + username);
        System.out.println("email " + email);
        System.out.println("phone " + phone);
        System.out.println("department" + department);
        System.out.println("course " + course);
        System.out.println("year " + year);

        System.out.println("****************************");

    }

    public Student Login(String username, String password) {
        StudentDB studentdb = new StudentDB();
        return studentdb.Login(username, password);

    }

}
