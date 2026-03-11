/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.controller;

import com.tdea.ejb.CalzadoFacadeLocal;
import com.tdea.entities.Calzado;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author BIBLIOTECA
 */
@Named(value = "calzadoManagedBean")
@SessionScoped
public class CalzadoManagedBean implements Serializable {

    @EJB
    private CalzadoFacadeLocal calzadoFacade;

    /**
     * Creates a new instance of calzadoManagedBean
     */
    public CalzadoManagedBean() {
    }

    private String nombre = "";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private List<Calzado> calzadoList; //la lista a mostrar

    public List<Calzado> getCalzadoList() {
        if (nombre == null || nombre.isEmpty()) {
            calzadoList = calzadoFacade.findAll();
        } else {
            calzadoList = calzadoFacade.findByName(nombre);
        }
        return calzadoList;
    }

    public void setCalzadoList(List<Calzado> calzadoList) {
        this.calzadoList = calzadoList;
    }

    public List<Calzado> getListByName() {
        if (calzadoList == null) {
            calzadoList = calzadoFacade.findByName(nombre);
        }
        return calzadoList;
    }

    public void nombreChangeListener(AjaxBehaviorEvent event) {
        //cada vez que haya un cambio en el texto, vuelve a generar la lista
        calzadoList = calzadoFacade.findByName(nombre);
    }
}
