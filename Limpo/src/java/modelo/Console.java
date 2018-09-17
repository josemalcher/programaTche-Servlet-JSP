/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
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

/**
 *
 * @author josemalcher
 */
@Entity
@Table(name = "console")
@NamedQueries({
    @NamedQuery(name = "Console.findAll", query = "SELECT c FROM Console c")})
public class Console implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_serie")
    private Integer numSerie;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numSerie")
    private List<Joystick> joystickList;

    public Console() {
    }

    public Console(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public Console(Integer numSerie, String nome, String marca, BigDecimal valor) {
        this.numSerie = numSerie;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Joystick> getJoystickList() {
        return joystickList;
    }

    public void setJoystickList(List<Joystick> joystickList) {
        this.joystickList = joystickList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSerie != null ? numSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Console)) {
            return false;
        }
        Console other = (Console) object;
        if ((this.numSerie == null && other.numSerie != null) || (this.numSerie != null && !this.numSerie.equals(other.numSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Console[ numSerie=" + numSerie + " ]";
    }
    
}
