/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

/**
 *
 * @author nitheesh
 */
public class SystemAdmin extends Person {
    
    public SystemAdmin() {
        name = "Admin";         //Default name for all admins
    }
    
    public void openStatusUI() {
        new StatusUI().setVisible(true);
    }
}
