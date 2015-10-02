/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.DAO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Raquel
 */
public interface GenericDAO<T> extends Remote {
    public void insert(T e)throws RemoteException ;
    public List<T> readList()throws RemoteException;
    public T read(T e)throws RemoteException;
    public void update(T e, int id)throws RemoteException;
    public void delete (T e)throws RemoteException;
}
