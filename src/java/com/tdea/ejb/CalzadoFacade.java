/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.ejb;

import com.tdea.entities.Calzado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author BIBLIOTECA
 */
@Stateless
public class CalzadoFacade extends AbstractFacade<Calzado> implements CalzadoFacadeLocal {

    @PersistenceContext(unitName = "TrabajoPPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalzadoFacade() {
        super(Calzado.class);
    }

    @Override
    public Calzado findById(String id) {
        try {
            Query q = em.createNamedQuery("Customer.findById");
            q.setParameter("id", id);
            return (Calzado) q.getSingleResult();
        } catch (Exception e) {
            System.out.print("Exepcion : " + e);
            return null;
        }
    }

    public List<Calzado> findByName(String name) {
        String $name = "%" + name.replaceAll(" ", "%") + "%";
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Calzado> criteriaQuery
                = criteriaBuilder.createQuery(Calzado.class);
        Root<Calzado> calzado = criteriaQuery.from(Calzado.class);
        criteriaQuery.select(calzado);

        criteriaQuery.where(criteriaBuilder.like(calzado.get("marca").as(String.class),
                $name));
        List<Calzado> list = em.createQuery(criteriaQuery).getResultList();
        return list;
    }

}
