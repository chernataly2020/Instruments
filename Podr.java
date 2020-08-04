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
@Table(name = "PODR", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Podr.findAll", query = "SELECT p FROM Podr p")
    , @NamedQuery(name = "Podr.findByKodc", query = "SELECT p FROM Podr p WHERE p.kodc = :kodc")
    , @NamedQuery(name = "Podr.findByNamec", query = "SELECT p FROM Podr p WHERE p.namec = :namec")})
public class Podr implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KODC")
    private Integer kodc;
    @Column(name = "NAMEC")
    private String namec;

    public Podr() {
    }

    public Podr(Integer kodc) {
        this.kodc = kodc;
    }

    public Integer getKodc() {
        return kodc;
    }

    public void setKodc(Integer kodc) {
        Integer oldKodc = this.kodc;
        this.kodc = kodc;
        changeSupport.firePropertyChange("kodc", oldKodc, kodc);
    }

    public String getNamec() {
        return namec;
    }

    public void setNamec(String namec) {
        String oldNamec = this.namec;
        this.namec = namec;
        changeSupport.firePropertyChange("namec", oldNamec, namec);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodc != null ? kodc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Podr)) {
            return false;
        }
        Podr other = (Podr) object;
        if ((this.kodc == null && other.kodc != null) || (this.kodc != null && !this.kodc.equals(other.kodc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inst.Podr[ kodc=" + kodc + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
