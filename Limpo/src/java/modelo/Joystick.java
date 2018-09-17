/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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

/**
 *
 * @author josemalcher
 */
@Entity
@Table(name = "joystick")
@NamedQueries({
    @NamedQuery(name = "Joystick.findAll", query = "SELECT j FROM Joystick j")})
public class Joystick implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "quantidade_botoes")
    private int quantidadeBotoes;
    @JoinColumn(name = "num_serie", referencedColumnName = "num_serie")
    @ManyToOne(optional = false)
    private Console numSerie;

    public Joystick() {
    }

    public Joystick(Integer id) {
        this.id = id;
    }

    public Joystick(Integer id, String modelo, int quantidadeBotoes) {
        this.id = id;
        this.modelo = modelo;
        this.quantidadeBotoes = quantidadeBotoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidadeBotoes() {
        return quantidadeBotoes;
    }

    public void setQuantidadeBotoes(int quantidadeBotoes) {
        this.quantidadeBotoes = quantidadeBotoes;
    }

    public Console getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Console numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joystick)) {
            return false;
        }
        Joystick other = (Joystick) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Joystick[ id=" + id + " ]";
    }
    
}
