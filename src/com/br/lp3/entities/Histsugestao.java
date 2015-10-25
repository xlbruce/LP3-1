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
@Table(name = "HISTSUGESTAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Histsugestao.findAll", query = "SELECT h FROM Histsugestao h"),
    @NamedQuery(name = "Histsugestao.findByIdSugestao", query = "SELECT h FROM Histsugestao h WHERE h.idSugestao = :idSugestao"),
    @NamedQuery(name = "Histsugestao.findByHistoria", query = "SELECT h FROM Histsugestao h WHERE h.historia = :historia"),
    @NamedQuery(name = "Histsugestao.findByRoteiro", query = "SELECT h FROM Histsugestao h WHERE h.roteiro = :roteiro")})
public class Histsugestao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUGESTAO")
    private Integer idSugestao;
    @Basic(optional = false)
    @Column(name = "HISTORIA")
    private String historia;
    @Basic(optional = false)
    @Column(name = "ROTEIRO")
    private int roteiro;
    @JoinColumn(name = "IDHEROI", referencedColumnName = "ID_HEROI")
    @ManyToOne(optional = false)
    private Heroi idheroi;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Histsugestao() {
    }

    public Histsugestao(Integer idSugestao) {
        this.idSugestao = idSugestao;
    }

    public Histsugestao(Integer idSugestao, String historia, int roteiro) {
        this.idSugestao = idSugestao;
        this.historia = historia;
        this.roteiro = roteiro;
    }

    public Integer getIdSugestao() {
        return idSugestao;
    }

    public void setIdSugestao(Integer idSugestao) {
        this.idSugestao = idSugestao;
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

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSugestao != null ? idSugestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Histsugestao)) {
            return false;
        }
        Histsugestao other = (Histsugestao) object;
        if ((this.idSugestao == null && other.idSugestao != null) || (this.idSugestao != null && !this.idSugestao.equals(other.idSugestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Histsugestao[ idSugestao=" + idSugestao + " ]";
    }
    
}
