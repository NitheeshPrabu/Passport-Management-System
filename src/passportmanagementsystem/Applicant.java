/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

import java.util.Date;

/**
 *
 * @author nithe
 */
public class Applicant extends Person {
    
    protected String Native, fathersName, pan;
    protected long aadharNo;
    protected Date dob;
    
    public void openApplicationUI() {
        new ApplicationUI().setVisible(true);
    }
}
