/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.attendancemanagementsystem;


public abstract class User {
 
    private String userId;
    private String firstName;
    private String lastName;
    private String role;
    private String address;
    private String dob;
    private String email;
    private String contactNo;
    private String username;
    private String password;

    public User(String userId, String firstName, String lastName, String role,
                String address, String dob, String email, String contactNo,
                String username, String password) throws InvalidDataException {
        validateRequired(userId, "User ID");
        validateRequired(firstName, "First name");
        validateRequired(username, "Username");
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.contactNo = contactNo;
        this.username = username;
        this.password = password;
    }

    protected void validateRequired(String value, String fieldName) throws InvalidDataException {
        if (value == null || value.isBlank()) {
            throw new InvalidDataException(fieldName + " cannot be empty.");
        }
    }

    public String getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getRole() { return role; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getDob() { return dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContactNo() { return contactNo; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public String getUsername() { return username; }
    public void setPassword(String password) { this.password = password; }

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    /** ABSTRACTION + POLYMORPHISM: a short description of duties, distinct from the role label. */
    public abstract String getResponsibilities();


    public abstract boolean saveToDatabase();

    @Override
    public String toString() {
        return role + " [" + userId + "] " + firstName + " " + lastName;
    }

}
