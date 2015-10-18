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
 * @author Raquel Gallo (31458521)
 * @author William Cisang (31441564)
 */
public class VestimentaDAO extends UnicastRemoteObject implements GenericDAO<Vestimenta> {

    public VestimentaDAO() throws RemoteException {
    }

    @Override
    public void insert(Vestimenta e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Vestimenta> readList() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de uma nova vestimenta, somente no Java
        Query queryuser = em.createNamedQuery("Vestimenta.findAll");
        List<Vestimenta> listavestimenta = queryuser.getResultList();

        return listavestimenta;
    }

    @Override
    public Vestimenta read(Vestimenta e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de uma nova vestimenta, somente no Java
        Query queryuser = em.createNamedQuery("Vestimenta.findByIdVestimenta");
        queryuser.setParameter("idVestimenta", e.getIdVestimenta());
        List<Vestimenta> listavestimenta = queryuser.getResultList();

        return listavestimenta.get(0);
    }

    @Override
    public void update(Vestimenta e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //atualização de uma vestimenta, somente no Java
        Vestimenta a2 = em.find(Vestimenta.class, e.getIdVestimenta());
        em.refresh(a2);

        //envia vestimenta atualizada para o banco de dados
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
        Vestimenta v1 = em.find(Vestimenta.class, e);
        em.remove(v1);
        em.getTransaction().commit();
        em.close();
    }

}
