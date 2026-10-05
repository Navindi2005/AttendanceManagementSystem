/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.attendancemanagementsystem;


import com.mycompany.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teacher extends User implements Reportable {
       private String subject;

    public Teacher(String userId, String firstName, String lastName, String address,
                    String dob, String email, String contactNo, String username,
                    String password, String subject) throws InvalidDataException {
        super(userId, firstName, lastName, "Teacher", address, dob, email, contactNo, username, password);
        validateRequired(subject, "Subject");
        this.subject = subject;
    }

 
    public Teacher(String userId, String firstName, String lastName) throws InvalidDataException {
        this(userId, firstName, lastName, "", "", "", "", "", "", "Unassigned");
    }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public String getResponsibilities() {
        return "Teaches one class, reviews attendance, receives feedback.";
    }

    @Override
    public String generateReport() {
        return "Teacher report for " + getFirstName() + " " + getLastName() + " - subject: " + subject;
    }

    
    @Override
    public boolean saveToDatabase() {
        String sql = "INSERT INTO teacher (teacher_id, first_name, last_name, address, dob, "
                + "email, contact_no, username, subject) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, getUserId());
            stmt.setString(2, getFirstName());
            stmt.setString(3, getLastName());
            stmt.setString(4, getAddress());
            stmt.setString(5, getDob());
            stmt.setString(6, getEmail());
            stmt.setString(7, getContactNo());
            stmt.setString(8, getUsername());
            stmt.setString(9, subject);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Database error while saving teacher: " + e.getMessage());
            return false;
        }
    }

}
