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
 * @author Raquel Gallo (31458521)
 * @author William Cisang (31441564)
 */
public class HeroiDAO extends UnicastRemoteObject implements GenericDAO<Heroi> {
    
    EntityManagerFactory emf;
    EntityManager em;

    public HeroiDAO() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("HANAServerPU");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Heroi e) throws RemoteException {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Heroi> readList() throws RemoteException {
        em.getTransaction().begin();
        //criação de um novo heroi, somente no Java
        Query queryuser = em.createNamedQuery("Heroi.findAll");
        List<Heroi> listaheroi = queryuser.getResultList();

        return listaheroi;
    }

    @Override
    public Heroi read(Heroi e) throws RemoteException {
        em.getTransaction().begin();
        //criação de um novo heroi, somente no Java
        Query queryuser = em.createNamedQuery("Heroi.findByIduser");
        queryuser.setParameter("iduser", e.getIdUser());
        List<Heroi> listaheroi = queryuser.getResultList();

        return listaheroi.get(0);
    }

    @Override
    public void update(Heroi e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //atualização de um heroi, somente no Java
        Heroi a2 = em.find(Heroi.class, e.getIdHeroi());
        em.refresh(a2);

        //envia heroi atualizado para o banco de dados
        em.persist(a2);
        em.getTransaction().commit();

        //fechamento do EntityManager
        em.close();
    }

    @Override
    public void delete(int e) throws RemoteException {
        em.getTransaction().begin();
        Heroi a1 = em.find(Heroi.class, e);
        em.remove(a1);
        em.getTransaction().commit();
        em.close();
    }

}
