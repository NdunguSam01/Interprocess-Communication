/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyservice;

/**
 *
 * @author Rees
 */
import java.net.MalformedURLException;
import java.rmi.*;

public class Server{

public static void main(String args[]){
  ToyComputeEngine stub;
  try{

stub = new ToyComputeEngine();
            Naming.rebind("rmi://localhost:1099/toyservice",stub);

}catch(MalformedURLException | RemoteException e){System.out.println(e);}
}

}