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
 * @author Raquel Gallo (31458521)
 * @author William Cisang (31441564)
 */
public class HistsugestaoDAO extends UnicastRemoteObject implements GenericDAO<com.br.lp3.entities.Histsugestao> {

    public HistsugestaoDAO() throws RemoteException {
    }

    @Override
    public void insert(com.br.lp3.entities.Histsugestao e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<com.br.lp3.entities.Histsugestao> readList() throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de uma nova histoória sugestão, somente no Java
        Query queryuser = em.createNamedQuery("Histsugestao.findAll");
        List<com.br.lp3.entities.Histsugestao> listahistsugestao = queryuser.getResultList();

        return listahistsugestao;
    }

    @Override
    public com.br.lp3.entities.Histsugestao read(Histsugestao e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de uma nova histoória sugestão, somente no Java
        Query queryuser = em.createNamedQuery("Histsugestao.findByIdheroi");
        queryuser.setParameter("idheroi", e.getIdheroi());
        List<com.br.lp3.entities.Histsugestao> listahistsugestao = queryuser.getResultList();

        return listahistsugestao.get(0);
    }

    @Override
    public void update(Histsugestao e) throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //atualização de uma história sugestão, somente no Java
        Histsugestao a2 = em.find(Histsugestao.class, e.getIdSugestao());
        em.refresh(a2);

        //envia história sugestão atualizada para o banco de dados
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
        com.br.lp3.entities.Histsugestao hs1 = em.find(com.br.lp3.entities.Histsugestao.class, e);
        em.remove(hs1);
        em.getTransaction().commit();
        em.close();
    }

}
