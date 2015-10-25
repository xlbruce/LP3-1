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
@Table(name = "VESTIMENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vestimenta.findAll", query = "SELECT v FROM Vestimenta v"),
    @NamedQuery(name = "Vestimenta.findByIdVestimenta", query = "SELECT v FROM Vestimenta v WHERE v.idVestimenta = :idVestimenta"),
    @NamedQuery(name = "Vestimenta.findByImagem", query = "SELECT v FROM Vestimenta v WHERE v.imagem = :imagem"),
    @NamedQuery(name = "Vestimenta.findByTipo", query = "SELECT v FROM Vestimenta v WHERE v.tipo = :tipo")})
public class Vestimenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VESTIMENTA")
    private Integer idVestimenta;
    @Basic(optional = false)
    @Column(name = "IMAGEM")
    private String imagem;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private int tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCorpo")
    private Collection<Heroi> heroiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCapacete")
    private Collection<Heroi> heroiCollection1;

    public Vestimenta() {
    }

    public Vestimenta(Integer idVestimenta) {
        this.idVestimenta = idVestimenta;
    }

    public Vestimenta(Integer idVestimenta, String imagem, int tipo) {
        this.idVestimenta = idVestimenta;
        this.imagem = imagem;
        this.tipo = tipo;
    }

    public Integer getIdVestimenta() {
        return idVestimenta;
    }

    public void setIdVestimenta(Integer idVestimenta) {
        this.idVestimenta = idVestimenta;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Heroi> getHeroiCollection() {
        return heroiCollection;
    }

    public void setHeroiCollection(Collection<Heroi> heroiCollection) {
        this.heroiCollection = heroiCollection;
    }

    @XmlTransient
    public Collection<Heroi> getHeroiCollection1() {
        return heroiCollection1;
    }

    public void setHeroiCollection1(Collection<Heroi> heroiCollection1) {
        this.heroiCollection1 = heroiCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVestimenta != null ? idVestimenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vestimenta)) {
            return false;
        }
        Vestimenta other = (Vestimenta) object;
        if ((this.idVestimenta == null && other.idVestimenta != null) || (this.idVestimenta != null && !this.idVestimenta.equals(other.idVestimenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Vestimenta[ idVestimenta=" + idVestimenta + " ]";
    }
    
}
