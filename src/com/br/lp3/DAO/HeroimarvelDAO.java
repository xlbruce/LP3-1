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
 * @author William Cisang (31441564)
 * @author Raquel Gallo (31458521)
 */
public class HeroimarvelDAO extends UnicastRemoteObject implements GenericDAO<Heroimarvel> {

    EntityManagerFactory emf;
    EntityManager em;
    
    public HeroimarvelDAO() throws RemoteException {
        emf = Persistence.createEntityManagerFactory("HANAServerPU");
        em = emf.createEntityManager();
    }

    @Override
    public void insert(Heroimarvel e) throws RemoteException {
        
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Heroimarvel> readList() throws RemoteException {
        em.getTransaction().begin();
        //criação de um novo heroi marvel, somente no Java
        Query queryuser = em.createNamedQuery("Heroimarvel.findAll");
        List<Heroimarvel> listaheroimarvel = queryuser.getResultList();

        return listaheroimarvel;
    }

    @Override
    public Heroimarvel read(Heroimarvel e) throws RemoteException {
        em.getTransaction().begin();
        //criação de um novo heroi marvel, somente no Java
        Query queryuser = em.createNamedQuery("Heroimarvel.findByIdHeroimar");
        queryuser.setParameter("id_heroimar", e.getIdHeroimar());
        List<Heroimarvel> listaheroimarvel = queryuser.getResultList();

        return listaheroimarvel.get(0);
    }

    @Override
    public void update(Heroimarvel e) throws RemoteException {
        em.getTransaction().begin();
        //atualização de um heroi marvel, somente no Java
        Heroimarvel hm = em.find(Heroimarvel.class, e.getIdHeroimar());
        em.refresh(hm);

        //envia heroi marvel atualizado para o banco de dados
        em.persist(hm);
        em.getTransaction().commit();

        //fechamento do EntityManager
        em.close();
    }

    @Override
    public void delete(int e) throws RemoteException {
        em.getTransaction().begin();
        Heroimarvel hm2 = em.find(Heroimarvel.class, e);
        em.remove(hm2);
        em.getTransaction().commit();
        em.close();
    }

}
