/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Histsugestao;
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
public class HistsugestaoDAO extends UnicastRemoteObject implements GenericDAO<com.br.lp3.entities.Histsugestao>{

    public HistsugestaoDAO() throws RemoteException {
    }
    

    @Override
    public void insert(com.br.lp3.entities.Histsugestao e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<com.br.lp3.entities.Histsugestao> readList()throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Histsugestao.findAll");
        List<com.br.lp3.entities.Histsugestao> listahistsugestao =  queryuser.getResultList();
        
        return listahistsugestao;
    }

    @Override
    public com.br.lp3.entities.Histsugestao read(Histsugestao e) throws RemoteException{
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
    public void update(Histsugestao e) throws RemoteException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int e)throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        com.br.lp3.entities.Histsugestao hs1 = em.find(com.br.lp3.entities.Histsugestao.class, e);
        em.remove(hs1);
        em.getTransaction().commit();
        em.close();
    }
    
}
