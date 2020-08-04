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
@Table(name = "INSTRUMENTS", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Instruments.findAll", query = "SELECT i FROM Instruments i")
    , @NamedQuery(name = "Instruments.findByKod", query = "SELECT i FROM Instruments i WHERE i.kod = :kod")
    , @NamedQuery(name = "Instruments.findByNane", query = "SELECT i FROM Instruments i WHERE i.nane = :nane")})
public class Instruments implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KOD")
    private Integer kod;
    @Column(name = "NANE")
    private String nane;

    public Instruments() {
    }

    public Instruments(Integer kod) {
        this.kod = kod;
    }

    public Integer getKod() {
        return kod;
    }

    public void setKod(Integer kod) {
        Integer oldKod = this.kod;
        this.kod = kod;
        changeSupport.firePropertyChange("kod", oldKod, kod);
    }

    public String getNane() {
        return nane;
    }

    public void setNane(String nane) {
        String oldNane = this.nane;
        this.nane = nane;
        changeSupport.firePropertyChange("nane", oldNane, nane);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kod != null ? kod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instruments)) {
            return false;
        }
        Instruments other = (Instruments) object;
        if ((this.kod == null && other.kod != null) || (this.kod != null && !this.kod.equals(other.kod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inst.Instruments[ kod=" + kod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
