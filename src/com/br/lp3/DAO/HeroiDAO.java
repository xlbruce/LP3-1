/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Heroi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Raquel
 */
public class HeroiDAO extends UnicastRemoteObject implements GenericDAO<Heroi> {

    public HeroiDAO() throws RemoteException {
        
    }

    
    @Override
    public void insert(Heroi e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Heroi> readList() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Heroi.findAll");
        List<Heroi> listaheroi =  queryuser.getResultList();
        
        return listaheroi;
    }

    @Override
    public Heroi read(Heroi e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Heroi.findByIduser");
        queryuser.setParameter("iduser", e.getIdUser());
        List<Heroi> listaheroi =  queryuser.getResultList();
        
        return listaheroi.get(0);
    }

    @Override
    public void update(Heroi e)throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Heroi a1 = em.find(Heroi.class, e);
        em.remove(a1);
        em.getTransaction().commit();
        em.close();
    }
    
}

