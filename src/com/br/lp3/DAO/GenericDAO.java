package com.br.lp3.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Raquel Gallo (31458521)
 * @author William Cisang (31441564)
 */
public interface GenericDAO<T> extends Remote {

    public void insert(T e) throws RemoteException;

    public List<T> readList() throws RemoteException;

    public T read(T e) throws RemoteException;

    public void update(T e) throws RemoteException;

    public void delete(int e) throws RemoteException;
}
