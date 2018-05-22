/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author nitheesh
 */
@Entity
@Table(name = "documentregister", catalog = "passportsystem", schema = "")
@NamedQueries({
    @NamedQuery(name = "Documentregister.findAll", query = "SELECT d FROM Documentregister d")
    , @NamedQuery(name = "Documentregister.findByName", query = "SELECT d FROM Documentregister d WHERE d.name = :name")
    , @NamedQuery(name = "Documentregister.findByDob", query = "SELECT d FROM Documentregister d WHERE d.dob = :dob")
    , @NamedQuery(name = "Documentregister.findByNative1", query = "SELECT d FROM Documentregister d WHERE d.native1 = :native1")
    , @NamedQuery(name = "Documentregister.findByFathersName", query = "SELECT d FROM Documentregister d WHERE d.fathersName = :fathersName")
    , @NamedQuery(name = "Documentregister.findByStatus", query = "SELECT d FROM Documentregister d WHERE d.status = :status")
    , @NamedQuery(name = "Documentregister.findByAppID", query = "SELECT d FROM Documentregister d WHERE d.appID = :appID")
    , @NamedQuery(name = "Documentregister.findByAadharNo", query = "SELECT d FROM Documentregister d WHERE d.aadharNo = :aadharNo")
    , @NamedQuery(name = "Documentregister.findByPan", query = "SELECT d FROM Documentregister d WHERE d.pan = :pan")
    , @NamedQuery(name = "Documentregister.findByPid", query = "SELECT d FROM Documentregister d WHERE d.pid = :pid")
    , @NamedQuery(name = "Documentregister.findByRemark", query = "SELECT d FROM Documentregister d WHERE d.remark = :remark")})
public class Documentregister implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Column(name = "name")
    private String name;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "native")
    private String native1;
    @Column(name = "fathersName")
    private String fathersName;
    @Column(name = "status")
    private String status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appID")
    private Integer appID;
    @Column(name = "aadharNo")
    private BigInteger aadharNo;
    @Column(name = "pan")
    private String pan;
    @Column(name = "pid")
    private Integer pid;
    @Column(name = "remark")
    private String remark;

    public Documentregister() {
    }

    public Documentregister(Integer appID) {
        this.appID = appID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Date oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public String getNative1() {
        return native1;
    }

    public void setNative1(String native1) {
        String oldNative1 = this.native1;
        this.native1 = native1;
        changeSupport.firePropertyChange("native1", oldNative1, native1);
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        String oldFathersName = this.fathersName;
        this.fathersName = fathersName;
        changeSupport.firePropertyChange("fathersName", oldFathersName, fathersName);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Integer getAppID() {
        return appID;
    }

    public void setAppID(Integer appID) {
        Integer oldAppID = this.appID;
        this.appID = appID;
        changeSupport.firePropertyChange("appID", oldAppID, appID);
    }

    public BigInteger getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(BigInteger aadharNo) {
        BigInteger oldAadharNo = this.aadharNo;
        this.aadharNo = aadharNo;
        changeSupport.firePropertyChange("aadharNo", oldAadharNo, aadharNo);
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        String oldPan = this.pan;
        this.pan = pan;
        changeSupport.firePropertyChange("pan", oldPan, pan);
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        Integer oldPid = this.pid;
        this.pid = pid;
        changeSupport.firePropertyChange("pid", oldPid, pid);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        String oldRemark = this.remark;
        this.remark = remark;
        changeSupport.firePropertyChange("remark", oldRemark, remark);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appID != null ? appID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentregister)) {
            return false;
        }
        Documentregister other = (Documentregister) object;
        if ((this.appID == null && other.appID != null) || (this.appID != null && !this.appID.equals(other.appID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "passportmanagementsystem.Documentregister[ appID=" + appID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
