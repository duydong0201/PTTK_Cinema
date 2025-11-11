package com.pttk.cinema.dao;

import com.pttk.cinema.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO {

    public User login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setFullName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createSampleUsers() {
        String sql = "INSERT INTO users (username, password, role, full_name, email) VALUES (?, ?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE username=username";
        
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            // Tạo user quản lý mẫu
            ps.setString(1, "admin");
            ps.setString(2, "admin123");
            ps.setString(3, "manager");
            ps.setString(4, "Quản lý hệ thống");
            ps.setString(5, "admin@cinema.com");
            ps.executeUpdate();
            
        } catch (SQLException e) {
            // Nếu bảng chưa tồn tại, sẽ bỏ qua
            System.out.println("Chưa có database, vui lòng tạo database và bảng users trước");
        }
    }
}

