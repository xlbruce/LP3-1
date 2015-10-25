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
@Table(name = "HEROIMARVEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heroimarvel.findAll", query = "SELECT h FROM Heroimarvel h"),
    @NamedQuery(name = "Heroimarvel.findByIdHeroimar", query = "SELECT h FROM Heroimarvel h WHERE h.idHeroimar = :idHeroimar"),
    @NamedQuery(name = "Heroimarvel.findByNomeHeroimar", query = "SELECT h FROM Heroimarvel h WHERE h.nomeHeroimar = :nomeHeroimar"),
    @NamedQuery(name = "Heroimarvel.findByHistoria", query = "SELECT h FROM Heroimarvel h WHERE h.historia = :historia"),
    @NamedQuery(name = "Heroimarvel.findByCurtida", query = "SELECT h FROM Heroimarvel h WHERE h.curtida = :curtida"),
    @NamedQuery(name = "Heroimarvel.findByImage", query = "SELECT h FROM Heroimarvel h WHERE h.image = :image")})
public class Heroimarvel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_HEROIMAR")
    private Integer idHeroimar;
    @Basic(optional = false)
    @Column(name = "NOME_HEROIMAR")
    private String nomeHeroimar;
    @Column(name = "HISTORIA")
    private String historia;
    @Basic(optional = false)
    @Column(name = "CURTIDA")
    private int curtida;
    @Column(name = "IMAGE")
    private String image;
    @JoinColumn(name = "ID_USERMARVEL", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsermarvel;

    public Heroimarvel() {
    }

    public Heroimarvel(Integer idHeroimar) {
        this.idHeroimar = idHeroimar;
    }

    public Heroimarvel(Integer idHeroimar, String nomeHeroimar, int curtida) {
        this.idHeroimar = idHeroimar;
        this.nomeHeroimar = nomeHeroimar;
        this.curtida = curtida;
    }

    public Integer getIdHeroimar() {
        return idHeroimar;
    }

    public void setIdHeroimar(Integer idHeroimar) {
        this.idHeroimar = idHeroimar;
    }

    public String getNomeHeroimar() {
        return nomeHeroimar;
    }

    public void setNomeHeroimar(String nomeHeroimar) {
        this.nomeHeroimar = nomeHeroimar;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getCurtida() {
        return curtida;
    }

    public void setCurtida(int curtida) {
        this.curtida = curtida;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Usuario getIdUsermarvel() {
        return idUsermarvel;
    }

    public void setIdUsermarvel(Usuario idUsermarvel) {
        this.idUsermarvel = idUsermarvel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHeroimar != null ? idHeroimar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heroimarvel)) {
            return false;
        }
        Heroimarvel other = (Heroimarvel) object;
        if ((this.idHeroimar == null && other.idHeroimar != null) || (this.idHeroimar != null && !this.idHeroimar.equals(other.idHeroimar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Heroimarvel[ idHeroimar=" + idHeroimar + " ]";
    }
    
}
