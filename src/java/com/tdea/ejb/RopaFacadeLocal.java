/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.ejb;

import com.tdea.entities.Ropa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author BIBLIOTECA
 */
@Local
public interface RopaFacadeLocal {

    void create(Ropa ropa);

    void edit(Ropa ropa);

    void remove(Ropa ropa);

    Ropa find(Object id);

    List<Ropa> findAll();

    List<Ropa> findRange(int[] range);

    int count();
    
    public Ropa findById(String Id);
    
    public List<Ropa> findByName(String name);
    
}
