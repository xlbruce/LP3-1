/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.servicos;

import com.br.lp3.DAO.UsuarioDAO;
import com.br.lp3.entities.Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author william
 */
public class UsuarioImpl extends UnicastRemoteObject implements UsuarioInter{
    
        UsuarioDAO dao;
    public UsuarioImpl() throws RemoteException {
        dao = new UsuarioDAO();
    }
    
    @Override
    public boolean verificaLogin(Usuario u) {
        
        if (dao.read(u)!= null) {
            return true;
        }
        return false;
    }
    
}
