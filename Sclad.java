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
@Table(name = "SCLAD", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Sclad.findAll", query = "SELECT s FROM Sclad s")
    , @NamedQuery(name = "Sclad.findByKod", query = "SELECT s FROM Sclad s WHERE s.kod = :kod")
    , @NamedQuery(name = "Sclad.findByKodinst", query = "SELECT s FROM Sclad s WHERE s.kodinst = :kodinst")
    , @NamedQuery(name = "Sclad.findByEdizm", query = "SELECT s FROM Sclad s WHERE s.edizm = :edizm")
    , @NamedQuery(name = "Sclad.findByKol", query = "SELECT s FROM Sclad s WHERE s.kol = :kol")
    , @NamedQuery(name = "Sclad.findByPrice", query = "SELECT s FROM Sclad s WHERE s.price = :price")
    , @NamedQuery(name = "Sclad.findBySklad", query = "SELECT s FROM Sclad s WHERE s.sklad = :sklad")})
public class Sclad implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KOD")
    private Integer kod;
    @Column(name = "KODINST")
    private Integer kodinst;
    @Column(name = "EDIZM")
    private String edizm;
    @Column(name = "KOL")
    private Integer kol;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "SKLAD")
    private String sklad;

    public Sclad() {
    }

    public Sclad(Integer kod) {
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

    public Integer getKodinst() {
        return kodinst;
    }

    public void setKodinst(Integer kodinst) {
        Integer oldKodinst = this.kodinst;
        this.kodinst = kodinst;
        changeSupport.firePropertyChange("kodinst", oldKodinst, kodinst);
    }

    public String getEdizm() {
        return edizm;
    }

    public void setEdizm(String edizm) {
        String oldEdizm = this.edizm;
        this.edizm = edizm;
        changeSupport.firePropertyChange("edizm", oldEdizm, edizm);
    }

    public Integer getKol() {
        return kol;
    }

    public void setKol(Integer kol) {
        Integer oldKol = this.kol;
        this.kol = kol;
        changeSupport.firePropertyChange("kol", oldKol, kol);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        Integer oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public String getSklad() {
        return sklad;
    }

    public void setSklad(String sklad) {
        String oldSklad = this.sklad;
        this.sklad = sklad;
        changeSupport.firePropertyChange("sklad", oldSklad, sklad);
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
        if (!(object instanceof Sclad)) {
            return false;
        }
        Sclad other = (Sclad) object;
        if ((this.kod == null && other.kod != null) || (this.kod != null && !this.kod.equals(other.kod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inst.Sclad[ kod=" + kod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
