/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.controller;

import com.tdea.ejb.RopaFacadeLocal;
import com.tdea.entities.Ropa;
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
@Named(value = "ropaManagedBean")
@SessionScoped
public class RopaManagedBean implements Serializable {

    @EJB
    private RopaFacadeLocal ropaFacade;

    /**
     * Creates a new instance of calzadoManagedBean
     */
    public RopaManagedBean() {
    }

    private String nombre = "";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private List<Ropa> ropaList; //la lista a mostrar

    public List<Ropa> getRopaList() {
        if (nombre == null || nombre.isEmpty()) {
            ropaList = ropaFacade.findAll();
        } else {
            ropaList = ropaFacade.findByName(nombre);
        }
        return ropaList;
    }

    public void setRopaList(List<Ropa> ropaList) {
        this.ropaList = ropaList;
    }

    public List<Ropa> getListByName() {
        if (ropaList == null) {
            ropaList = ropaFacade.findByName(nombre);
        }
        return ropaList;
    }

    public void nombreChangeListener(AjaxBehaviorEvent event) {
        //cada vez que haya un cambio en el texto, vuelve a generar la lista
        ropaList = ropaFacade.findByName(nombre);
    }

}
