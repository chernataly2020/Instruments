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
@Table(name = "ZAYAVKI", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Zayavki_1.findAll", query = "SELECT z FROM Zayavki_1 z")
    , @NamedQuery(name = "Zayavki_1.findByKodz", query = "SELECT z FROM Zayavki_1 z WHERE z.kodz = :kodz")
    , @NamedQuery(name = "Zayavki_1.findByDatez", query = "SELECT z FROM Zayavki_1 z WHERE z.datez = :datez")
    , @NamedQuery(name = "Zayavki_1.findByKodinst", query = "SELECT z FROM Zayavki_1 z WHERE z.kodinst = :kodinst")
    , @NamedQuery(name = "Zayavki_1.findByKol", query = "SELECT z FROM Zayavki_1 z WHERE z.kol = :kol")
    , @NamedQuery(name = "Zayavki_1.findByEdizm", query = "SELECT z FROM Zayavki_1 z WHERE z.edizm = :edizm")
    , @NamedQuery(name = "Zayavki_1.findByKodc", query = "SELECT z FROM Zayavki_1 z WHERE z.kodc = :kodc")
    , @NamedQuery(name = "Zayavki_1.findByKodsotr", query = "SELECT z FROM Zayavki_1 z WHERE z.kodsotr = :kodsotr")})
public class Zayavki_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KODZ")
    private Integer kodz;
    @Column(name = "DATEZ")
    private String datez;
    @Column(name = "KODINST")
    private Integer kodinst;
    @Column(name = "KOL")
    private Integer kol;
    @Column(name = "EDIZM")
    private String edizm;
    @Column(name = "KODC")
    private Integer kodc;
    @Column(name = "KODSOTR")
    private Integer kodsotr;

    public Zayavki_1() {
    }

    public Zayavki_1(Integer kodz) {
        this.kodz = kodz;
    }

    public Integer getKodz() {
        return kodz;
    }

    public void setKodz(Integer kodz) {
        Integer oldKodz = this.kodz;
        this.kodz = kodz;
        changeSupport.firePropertyChange("kodz", oldKodz, kodz);
    }

    public String getDatez() {
        return datez;
    }

    public void setDatez(String datez) {
        String oldDatez = this.datez;
        this.datez = datez;
        changeSupport.firePropertyChange("datez", oldDatez, datez);
    }

    public Integer getKodinst() {
        return kodinst;
    }

    public void setKodinst(Integer kodinst) {
        Integer oldKodinst = this.kodinst;
        this.kodinst = kodinst;
        changeSupport.firePropertyChange("kodinst", oldKodinst, kodinst);
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        Integer oldKol = this.kol;
        this.kol = kol;
        changeSupport.firePropertyChange("kol", oldKol, kol);
    }

    public String getEdizm() {
        return edizm;
    }

    public void setEdizm(String edizm) {
        String oldEdizm = this.edizm;
        this.edizm = edizm;
        changeSupport.firePropertyChange("edizm", oldEdizm, edizm);
    }

    public Integer getKodc() {
        return kodc;
    }

    public void setKodc(Integer kodc) {
        Integer oldKodc = this.kodc;
        this.kodc = kodc;
        changeSupport.firePropertyChange("kodc", oldKodc, kodc);
    }

    public Integer getKodsotr() {
        return kodsotr;
    }

    public void setKodsotr(Integer kodsotr) {
        Integer oldKodsotr = this.kodsotr;
        this.kodsotr = kodsotr;
        changeSupport.firePropertyChange("kodsotr", oldKodsotr, kodsotr);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodz != null ? kodz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zayavki_1)) {
            return false;
        }
        Zayavki_1 other = (Zayavki_1) object;
        if ((this.kodz == null && other.kodz != null) || (this.kodz != null && !this.kodz.equals(other.kodz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inst.Zayavki_1[ kodz=" + kodz + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
