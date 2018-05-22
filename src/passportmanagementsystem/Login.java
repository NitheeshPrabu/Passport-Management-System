/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nithe
 */
public class Login extends LoginUI{
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String role;
    
    public Login() {
        role = "none";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/passportsystem?useSSL=false";
            con = DriverManager.getConnection(db,"root","root");
            stmt = con.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        } 
    }
    
    public String login(String uString, String pString) {
        username = uString;
        password = pString;
        try {
            String sql = "SELECT role FROM login WHERE username='" + username
                + "' AND password='" + password + "'";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                JOptionPane.showMessageDialog(null,"Login successful!");
                return rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null,"Login failed!");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return role;
    }
    
    public boolean register(String uString, String pString) {
        username = uString;
        password = pString;
        try {
            PreparedStatement pstmt = null;
            String sql = "INSERT INTO login(username,password) VALUES(?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(null,"User registered!");
            pstmt.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"User already exists!");
            return false;
        } 
        return true;
    }
    
    protected void finalize() {
        try{
            stmt.close();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}