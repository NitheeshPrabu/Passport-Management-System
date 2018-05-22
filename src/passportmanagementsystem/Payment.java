/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nitheesh
 */
public class Payment extends PaymentUI {
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private Profile p;
    
    public Payment() {
        p = new Profile();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/passportsystem?useSSL=false";
            con = DriverManager.getConnection(db,"root","root");
            stmt = con.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        } 
    }
    
    public boolean makePayment(int uAppID, long uAccNo, int uPIN, int uAmount) {
        appID = uAppID;
        accNo = uAccNo;
        PIN = uPIN;
        amount = uAmount;
        try {
            if(p.getStatus(appID).equals("not paid")) {
                if(verifyPayment()) {
                    JOptionPane.showMessageDialog(null,"Payment successful");
                    p.setStatus(appID,"paid");
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null,"Payment already made");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean verifyPayment() {
        try {
            String sql = "SELECT balance FROM payment WHERE accno=" + accNo
                + " AND PIN=" + PIN;
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                if(rs.getInt(1) >= 1000) {
                    sql = "UPDATE payment SET balance=balance-1000 WHERE "
                        + "accNo=" + accNo;
                    stmt.executeUpdate(sql);
                } else {
                    JOptionPane.showMessageDialog(null,"Not enough balance");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null,"Invalid account details");
                return false;
            }
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
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
