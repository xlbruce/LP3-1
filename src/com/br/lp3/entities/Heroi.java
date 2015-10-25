/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author willi
 */
@Entity
@Table(name = "HEROI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heroi.findAll", query = "SELECT h FROM Heroi h"),
    @NamedQuery(name = "Heroi.findByIdHeroi", query = "SELECT h FROM Heroi h WHERE h.idHeroi = :idHeroi"),
    @NamedQuery(name = "Heroi.findByNomeHeroi", query = "SELECT h FROM Heroi h WHERE h.nomeHeroi = :nomeHeroi")})
public class Heroi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HEROI")
    private Integer idHeroi;
    @Basic(optional = false)
    @Column(name = "NOME_HEROI")
    private String nomeHeroi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idheroi")
    private Collection<Histsugestao> histsugestaoCollection;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUser;
    @JoinColumn(name = "ID_CORPO", referencedColumnName = "ID_VESTIMENTA")
    @ManyToOne(optional = false)
    private Vestimenta idCorpo;
    @JoinColumn(name = "ID_CAPACETE", referencedColumnName = "ID_VESTIMENTA")
    @ManyToOne(optional = false)
    private Vestimenta idCapacete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idheroi")
    private Collection<Historia> historiaCollection;

    public Heroi() {
    }

    public Heroi(Integer idHeroi) {
        this.idHeroi = idHeroi;
    }

    public Heroi(Integer idHeroi, String nomeHeroi) {
        this.idHeroi = idHeroi;
        this.nomeHeroi = nomeHeroi;
    }

    public Integer getIdHeroi() {
        return idHeroi;
    }

    public void setIdHeroi(Integer idHeroi) {
        this.idHeroi = idHeroi;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    @XmlTransient
    public Collection<Histsugestao> getHistsugestaoCollection() {
        return histsugestaoCollection;
    }

    public void setHistsugestaoCollection(Collection<Histsugestao> histsugestaoCollection) {
        this.histsugestaoCollection = histsugestaoCollection;
    }

    public Usuario getIdUser() {
        return idUser;
    }

    public void setIdUser(Usuario idUser) {
        this.idUser = idUser;
    }

    public Vestimenta getIdCorpo() {
        return idCorpo;
    }

    public void setIdCorpo(Vestimenta idCorpo) {
        this.idCorpo = idCorpo;
    }

    public Vestimenta getIdCapacete() {
        return idCapacete;
    }

    public void setIdCapacete(Vestimenta idCapacete) {
        this.idCapacete = idCapacete;
    }

    @XmlTransient
    public Collection<Historia> getHistoriaCollection() {
        return historiaCollection;
    }

    public void setHistoriaCollection(Collection<Historia> historiaCollection) {
        this.historiaCollection = historiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHeroi != null ? idHeroi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heroi)) {
            return false;
        }
        Heroi other = (Heroi) object;
        if ((this.idHeroi == null && other.idHeroi != null) || (this.idHeroi != null && !this.idHeroi.equals(other.idHeroi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Heroi[ idHeroi=" + idHeroi + " ]";
    }
    
}
