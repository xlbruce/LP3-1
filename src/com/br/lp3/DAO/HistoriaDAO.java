/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Historia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Raquel
 */
public class HistoriaDAO implements GenericDAO<Historia> {

    @Override
    public void insert(Historia e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Historia> readList() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Historia.findAll");
        List<Historia> listaheroi =  queryuser.getResultList();
        
        return listaheroi;
    }

    @Override
    public Historia read(Historia e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Historia.findByIdheroi");
        queryuser.setParameter("idheroi", e.getIdheroi());
        List<Historia> listahistoria =  queryuser.getResultList();
        
        return listahistoria.get(0);
         }

    @Override
    public void update(Historia e, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Historia e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Historia h1 = em.find(Historia.class, e.getIdheroi());
        em.remove(h1);
        em.getTransaction().commit();
        em.close();
    }
    
}

