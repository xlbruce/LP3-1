package com.br.lp3.DAO;

import com.br.lp3.entities.Historia;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Raquel Gallo (31458521)
 * @author William Cisang (31441564)
 */
public class HistoriaDAO extends UnicastRemoteObject implements GenericDAO<Historia> {

    public HistoriaDAO() throws RemoteException {
    }

    @Override
    public void insert(Historia e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Historia> readList() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de uma nova história, somente no Java
        Query queryuser = em.createNamedQuery("Historia.findAll");
        List<Historia> listaheroi = queryuser.getResultList();

        return listaheroi;
    }

    @Override
    public Historia read(Historia e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de uma nova história, somente no Java
        Query queryuser = em.createNamedQuery("Historia.findByIdheroi");
        queryuser.setParameter("idheroi", e.getIdheroi());
        List<Historia> listahistoria = queryuser.getResultList();

        return listahistoria.get(0);
    }

    @Override
    public void update(Historia e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //atualização de uma história, somente no Java
        Historia a2 = em.find(Historia.class, e.getIdHistoria());
        a2.setHistoria(e.getHistoria());
        a2.setRoteiro(e.getRoteiro());
        //envia historia atualizada para o banco de dados
        em.persist(a2);
        em.getTransaction().commit();

        //fechamento do EntityManager
        em.close();
    }

    @Override
    public void delete(int e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Historia h1 = em.find(Historia.class, e);
        em.remove(h1);
        em.getTransaction().commit();
        em.close();
    }

}
