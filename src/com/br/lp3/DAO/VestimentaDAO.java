/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Vestimenta;
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
public class VestimentaDAO extends UnicastRemoteObject implements GenericDAO<Vestimenta>{

    public VestimentaDAO() throws RemoteException {
    }
    

    @Override
    public void insert(Vestimenta e)throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Vestimenta> readList()throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Vestimenta.findAll");
        List<Vestimenta> listavestimenta =  queryuser.getResultList();
        
        return listavestimenta;
    }

    @Override
    public Vestimenta read(Vestimenta e)throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Vestimenta.findByIdVestimenta");
        queryuser.setParameter("idVestimenta", e.getIdVestimenta());
        List<Vestimenta> listavestimenta =  queryuser.getResultList();
        
        return listavestimenta.get(0);
    }

    @Override
    public void update(Vestimenta e, int id)throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Vestimenta e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Vestimenta v1 = em.find(Vestimenta.class, e.getIdVestimenta());
        em.remove(v1);
        em.getTransaction().commit();
        em.close();
    }
    
}