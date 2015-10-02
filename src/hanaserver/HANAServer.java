/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanaserver;

import com.br.lp3.DAO.HeroiDAO;
import com.br.lp3.DAO.UsuarioDAO;
import com.br.lp3.DAO.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.remote.rmi.RMIServer;

/**
 *
 * @author Raquel
 */
public class HANAServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try {
            // TODO code application logic here
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("Usuario", new UsuarioDAO());
            registro.rebind("Heroi", new HeroiDAO());
            registro.rebind("Historia", new HistoriaDAO());
            registro.rebind("HistSugestao", new HistsugestaoDAO());
            registro.rebind("Vestimenta", new VestimentaDAO());
            
            System.out.println("Serviços Registrados.");
        } catch (RemoteException ex) {
            Logger.getLogger(RMIServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
