/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.ejb;

import com.tdea.entities.Calzado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BIBLIOTECA
 */
@Local
public interface CalzadoFacadeLocal {

    void create(Calzado calzado);

    void edit(Calzado calzado);

    void remove(Calzado calzado);

    Calzado find(Object id);

    List<Calzado> findAll();

    List<Calzado> findRange(int[] range);

    int count();
    
    public Calzado findById(String Id);
    
    public List<Calzado> findByName(String name);
    
}
