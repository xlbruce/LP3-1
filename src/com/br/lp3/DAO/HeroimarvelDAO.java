/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Heroimarvel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author william
 */
public class HeroimarvelDAO extends UnicastRemoteObject implements GenericDAO<Heroimarvel>{

    public HeroimarvelDAO() throws RemoteException {
    }

    
    @Override
    public void insert(Heroimarvel e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Heroimarvel> readList() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Heroimarvel.findAll");
        List<Heroimarvel> listaheroimarvel =  queryuser.getResultList();
        
        return listaheroimarvel;
    }

    @Override
    public Heroimarvel read(Heroimarvel e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Heroimarvel.findByIdHeroimar");
        queryuser.setParameter("id_heroimar", e.getIdHeroimar());
        List<Heroimarvel> listaheroimarvel =  queryuser.getResultList();
        
        return listaheroimarvel.get(0);
    }

    @Override
    public void update(Heroimarvel e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //atualização de um autor, só no Java
        Heroimarvel hm = em.find(Heroimarvel.class, e.getIdHeroimar());
        em.refresh(hm);
        
        //enviado autor atualizado para o banco de dados
        em.persist(hm);
        em.getTransaction().commit();

        //fechamento do EntityManager
        em.close();
    }

    @Override
    public void delete(int e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Heroimarvel hm2 = em.find(Heroimarvel.class, e);
        em.remove(hm2);
        em.getTransaction().commit();
        em.close();
    }
    
}
