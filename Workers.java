/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inst;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Наташа
 */
@Entity
@Table(name = "WORKERS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Workers.findAll", query = "SELECT w FROM Workers w")
    , @NamedQuery(name = "Workers.findByKodw", query = "SELECT w FROM Workers w WHERE w.kodw = :kodw")
    , @NamedQuery(name = "Workers.findByNamew", query = "SELECT w FROM Workers w WHERE w.namew = :namew")
    , @NamedQuery(name = "Workers.findByPhone", query = "SELECT w FROM Workers w WHERE w.phone = :phone")
    , @NamedQuery(name = "Workers.findByHomeaddress", query = "SELECT w FROM Workers w WHERE w.homeaddress = :homeaddress")})
public class Workers implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KODW")
    private Integer kodw;
    @Column(name = "NAMEW")
    private String namew;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "HOMEADDRESS")
    private String homeaddress;

    public Workers() {
    }

    public Workers(Integer kodw) {
        this.kodw = kodw;
    }

    public Integer getKodw() {
        return kodw;
    }

    public void setKodw(Integer kodw) {
        Integer oldKodw = this.kodw;
        this.kodw = kodw;
        changeSupport.firePropertyChange("kodw", oldKodw, kodw);
    }

    public String getNamew() {
        return namew;
    }

    public void setNamew(String namew) {
        String oldNamew = this.namew;
        this.namew = namew;
        changeSupport.firePropertyChange("namew", oldNamew, namew);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        String oldHomeaddress = this.homeaddress;
        this.homeaddress = homeaddress;
        changeSupport.firePropertyChange("homeaddress", oldHomeaddress, homeaddress);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodw != null ? kodw.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workers)) {
            return false;
        }
        Workers other = (Workers) object;
        if ((this.kodw == null && other.kodw != null) || (this.kodw != null && !this.kodw.equals(other.kodw))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inst.Workers[ kodw=" + kodw + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
