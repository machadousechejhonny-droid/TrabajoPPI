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
@Table(name = "ROPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ropa.findAll", query = "SELECT r FROM Ropa r")
    , @NamedQuery(name = "Ropa.findById", query = "SELECT r FROM Ropa r WHERE r.id = :id")
    , @NamedQuery(name = "Ropa.findByTipo", query = "SELECT r FROM Ropa r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "Ropa.findByColor", query = "SELECT r FROM Ropa r WHERE r.color = :color")
    , @NamedQuery(name = "Ropa.findByTalla", query = "SELECT r FROM Ropa r WHERE r.talla = :talla")
    , @NamedQuery(name = "Ropa.findByCantidad", query = "SELECT r FROM Ropa r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Ropa.findByPrecio", query = "SELECT r FROM Ropa r WHERE r.precio = :precio")})
public class Ropa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TALLA")
    private String talla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO")
    private double precio;

    public Ropa() {
    }

    public Ropa(Integer id) {
        this.id = id;
    }

    public Ropa(Integer id, String tipo, String color, String talla, int cantidad, double precio) {
        this.id = id;
        this.tipo = tipo;
        this.color = color;
        this.talla = talla;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
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
        if (!(object instanceof Ropa)) {
            return false;
        }
        Ropa other = (Ropa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tdea.entities.Ropa[ id=" + id + " ]";
    }
    
}
