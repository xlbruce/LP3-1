/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.servicos;

import com.br.lp3.entities.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author william
 */
public interface UsuarioInter extends Remote{
    
    public boolean verificaLogin(Usuario u)throws RemoteException;;
    
}
