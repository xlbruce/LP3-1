/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import com.br.lp3.entities.Usuario;
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
public class UsuarioDAO extends UnicastRemoteObject implements GenericDAO<Usuario> {

    public UsuarioDAO() throws RemoteException {
    }
    

    @Override
    public void insert(Usuario e)throws RemoteException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public List<Usuario> readList() throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Usuario.findAll");
        List<Usuario> listauser =  queryuser.getResultList();
        
        return listauser;
    }

    @Override
    public Usuario read(Usuario e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //criação de um novo autor, só no Java
        Query queryuser = em.createNamedQuery("Usuario.findByLogin");
        queryuser.setParameter("login", e.getLogin());
        queryuser.setParameter("senha", e.getSenha());
        List<Usuario> listauser =  queryuser.getResultList();
        
        return listauser.get(0);
    }

    @Override
    public void update(Usuario e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //atualização de um autor, só no Java
        Usuario a2 = em.find(Usuario.class,e.getIdUsuario());
        if (e.getLogin() != null) {
            
        }
        em.refresh(a2);
        
        //enviado autor atualizado para o banco de dados
        em.persist(a2);
        em.getTransaction().commit();

        //fechamento do EntityManager
        em.close();
    }

    @Override
    public void delete(int e) throws RemoteException{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HANAServerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Usuario a1 = em.find(Usuario.class, e);
        em.remove(a1);
        em.getTransaction().commit();
        em.close();
    }
    
    
    
}
