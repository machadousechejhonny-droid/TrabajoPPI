/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdea.ejb;

import com.tdea.entities.Ropa;
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
public class RopaFacade extends AbstractFacade<Ropa> implements RopaFacadeLocal {

    @PersistenceContext(unitName = "TrabajoPPIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RopaFacade() {
        super(Ropa.class);
    }

    @Override
    public Ropa findById(String id) {
        try {
            Query q = em.createNamedQuery("Customer.findById");
            q.setParameter("id", id);
            return (Ropa) q.getSingleResult();
        } catch (Exception e) {
            System.out.print("Exepcion : " + e);
            return null;
        }
    }

    public List<Ropa> findByName(String name) {
        String $name = "%" + name.replaceAll(" ", "%") + "%";
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Ropa> criteriaQuery
                = criteriaBuilder.createQuery(Ropa.class);
        Root<Ropa> ropa = criteriaQuery.from(Ropa.class);
        criteriaQuery.select(ropa);

        criteriaQuery.where(criteriaBuilder.like(ropa.get("tipo").as(String.class),
                 $name));
        List<Ropa> list = em.createQuery(criteriaQuery).getResultList();
        return list;
    }

}
