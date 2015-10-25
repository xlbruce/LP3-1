/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author willi
 */
@Entity
@Table(name = "HISTORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historia.findAll", query = "SELECT h FROM Historia h"),
    @NamedQuery(name = "Historia.findByIdHistoria", query = "SELECT h FROM Historia h WHERE h.idHistoria = :idHistoria"),
    @NamedQuery(name = "Historia.findByHistoria", query = "SELECT h FROM Historia h WHERE h.historia = :historia"),
    @NamedQuery(name = "Historia.findByRoteiro", query = "SELECT h FROM Historia h WHERE h.roteiro = :roteiro")})
public class Historia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HISTORIA")
    private Integer idHistoria;
    @Basic(optional = false)
    @Column(name = "HISTORIA")
    private String historia;
    @Basic(optional = false)
    @Column(name = "ROTEIRO")
    private int roteiro;
    @JoinColumn(name = "IDHEROI", referencedColumnName = "ID_HEROI")
    @ManyToOne(optional = false)
    private Heroi idheroi;

    public Historia() {
    }

    public Historia(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Historia(Integer idHistoria, String historia, int roteiro) {
        this.idHistoria = idHistoria;
        this.historia = historia;
        this.roteiro = roteiro;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getRoteiro() {
        return roteiro;
    }

    public void setRoteiro(int roteiro) {
        this.roteiro = roteiro;
    }

    public Heroi getIdheroi() {
        return idheroi;
    }

    public void setIdheroi(Heroi idheroi) {
        this.idheroi = idheroi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistoria != null ? idHistoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historia)) {
            return false;
        }
        Historia other = (Historia) object;
        if ((this.idHistoria == null && other.idHistoria != null) || (this.idHistoria != null && !this.idHistoria.equals(other.idHistoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Historia[ idHistoria=" + idHistoria + " ]";
    }
    
}
