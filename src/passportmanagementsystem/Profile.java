/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nitheesh
 */
public class Profile extends ApplicationDetailsJFrame {
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    protected String status, remark;
    
    public Profile() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/passportsystem?useSSL=false";
            con = DriverManager.getConnection(db,"root","root");
            stmt = con.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        } 
    }
    
    public int register(String uName, String uDob, String uFathersName, 
        String uNative, long uAadharNo, String uPan){
        int appID = -1;
        name = uName;
        fathersName = uFathersName;
        Native = uNative;
        aadharNo = uAadharNo;
        pan = uPan;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        dob = null;
        try {
            dob = formatter.parse(uDob);
        } catch (ParseException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
        try {
            PreparedStatement pstmt = null;
            String sql = "INSERT INTO documentregister(name,dob,native,fathersName,"
                + "aadharNo,pan) VALUES(?,?,?,?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setDate(2,sqlDate);
            pstmt.setString(3,Native);
            pstmt.setString(4,fathersName);
            pstmt.setLong(5,aadharNo);
            pstmt.setString(6,pan);
            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(null,"Application created!");
            String query = "SELECT LAST_INSERT_ID()";
            rs = stmt.executeQuery(query);
            rs.next();
            appID = rs.getInt(1);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        } 
        return appID;
    }
    
    public String getStatus(int appID) {
        status = "";
        try {
            String sql = "SELECT status FROM documentregister WHERE appID=" + appID;
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                status = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null,"Please enter correct "
                    + "application ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public void setStatus(int appID, String status) {
        try {
            String sql = "UPDATE documentregister SET status='" + status + "' "
                        + "WHERE appID=" + appID;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getRemark(int appID) {
        remark = "";
        try {
            String sql = "SELECT remark FROM documentregister WHERE appID=" + appID;
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                remark = rs.getString(1);
            } else {
                JOptionPane.showMessageDialog(null,"Please enter correct "
                    + "application ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return remark;
    }
    
    public void setRemark(int appID, String remark) {
        try {
            String sql = "UPDATE documentregister SET remark='" + remark + "' "
                        + "WHERE appID=" + appID;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getApplications() {
        rs = null;
        try {
            String sql = "SELECT * FROM documentregister WHERE status='paid'";
            rs = stmt.executeQuery(sql);
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public ResultSet getApplication(int id) {
        rs = null;
        try {
            String sql = "SELECT * FROM documentregister WHERE appID="+ id;
            rs = stmt.executeQuery(sql);
            if(rs.next());
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    protected void finalize() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
