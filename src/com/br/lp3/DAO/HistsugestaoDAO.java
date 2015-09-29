/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Raquel
 */
public class HistsugestaoDAO implements GenericDAO<com.br.lp3.entities.Histsugestao>{

    @Override
    public void insert(com.br.lp3.entities.Histsugestao e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<com.br.lp3.entities.Histsugestao> readList() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Histsugestao.findAll");
        List<com.br.lp3.entities.Histsugestao> listahistsugestao =  queryuser.getResultList();
        
        return listahistsugestao;
    }

    @Override
    public com.br.lp3.entities.Histsugestao read(com.br.lp3.entities.Histsugestao e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Histsugestao.findByIdheroi");
        queryuser.setParameter("idheroi", e.getIdheroi());
        List<com.br.lp3.entities.Histsugestao> listahistsugestao =  queryuser.getResultList();
        
        return listahistsugestao.get(0);
    }

    @Override
    public void update(com.br.lp3.entities.Histsugestao e, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(com.br.lp3.entities.Histsugestao e) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        com.br.lp3.entities.Histsugestao hs1 = em.find(com.br.lp3.entities.Histsugestao.class, e.getIdheroi());
        em.remove(hs1);
        em.getTransaction().commit();
        em.close();
    }
    
}
