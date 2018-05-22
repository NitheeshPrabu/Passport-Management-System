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
import java.text.Format;
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
public class Passport extends Profile {
    
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int PID;
    private Date DOE, DOI;
    
    public Passport() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Format f = new SimpleDateFormat("dd-MM-yyyy");
        try {
            DOI = formatter.parse(f.format(c.getTime()));
            c.add(Calendar.YEAR,5);
            DOE = formatter.parse(f.format(c.getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(Passport.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/passportsystem?useSSL=false";
            con = DriverManager.getConnection(db,"root","root");
            stmt = con.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        } 
    }
    
    public int createPassport(int id) {
        rs = getApplication(id);
        PID = -1;
        try {
            name = rs.getString(1);
            dob = rs.getDate(2);
            Native = rs.getString(3);
            fathersName = rs.getString(4);
            aadharNo = rs.getLong(7);
            pan = rs.getString(8);
            java.sql.Date sqlDoi = new java.sql.Date(DOI.getTime());
            java.sql.Date sqlDoe = new java.sql.Date(DOE.getTime());
            PreparedStatement pstmt = null;
            String sql = "INSERT INTO passport(name,dob,doi,doe,native,fathersName,"
                + "aadharNo,pan) VALUES(?,?,?,?,?,?,?,?)";
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setDate(2, (java.sql.Date) dob);
            pstmt.setDate(3,sqlDoi);
            pstmt.setDate(4,sqlDoe);
            pstmt.setString(5,Native);
            pstmt.setString(6,fathersName);
            pstmt.setLong(7,aadharNo);
            pstmt.setString(8,pan);
            pstmt.executeUpdate();
            pstmt.close();
            String query = "SELECT LAST_INSERT_ID()";
            rs = stmt.executeQuery(query);
            rs.next();
            PID = rs.getInt(1);
            sql = "UPDATE documentregister SET pid=" + PID + " WHERE appID=" + id;
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Passport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PID;
    }
    
    public ResultSet getPassport(int id) {
        rs = null;
        try {
            String sql = "SELECT * FROM passport WHERE pid="+ id;
            rs = stmt.executeQuery(sql);
            if(rs.next());
        } catch(Exception e) {
            System.out.println(e);
        }
        return rs;
    }
    
    public ResultSet getPassports() {
        rs = null;
        try {
            String sql = "SELECT * FROM passport";
            rs = stmt.executeQuery(sql);
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
