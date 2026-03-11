/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BIBLIOTECA
 */
@Entity
@Table(name = "CALZADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calzado.findAll", query = "SELECT c FROM Calzado c")
    , @NamedQuery(name = "Calzado.findById", query = "SELECT c FROM Calzado c WHERE c.id = :id")
    , @NamedQuery(name = "Calzado.findByMarca", query = "SELECT c FROM Calzado c WHERE c.marca = :marca")
    , @NamedQuery(name = "Calzado.findByTalla", query = "SELECT c FROM Calzado c WHERE c.talla = :talla")
    , @NamedQuery(name = "Calzado.findByColor", query = "SELECT c FROM Calzado c WHERE c.color = :color")
    , @NamedQuery(name = "Calzado.findByCantidad", query = "SELECT c FROM Calzado c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "Calzado.findByPrecio", query = "SELECT c FROM Calzado c WHERE c.precio = :precio")})
public class Calzado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MARCA")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TALLA")
    private int talla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private double precio;

    public Calzado() {
    }

    public Calzado(Integer id) {
        this.id = id;
    }

    public Calzado(Integer id, String marca, int talla, String color, int cantidad, double precio) {
        this.id = id;
        this.marca = marca;
        this.talla = talla;
        this.color = color;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        if (!(object instanceof Calzado)) {
            return false;
        }
        Calzado other = (Calzado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdea.entities.Calzado[ id=" + id + " ]";
    }
    
}
