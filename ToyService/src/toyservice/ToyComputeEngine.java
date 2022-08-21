/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyservice;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rees
 */
public class ToyComputeEngine extends UnicastRemoteObject implements ToyComputeInterface{

    ToyComputeEngine()throws RemoteException{
    super();
    }
    
 
    @Override
    public String returnTransaction(int amountPaid){
        return "";
    }
    
    //add toy price
    @Override
    public void addToyPrice(float price, String toyName){
       
        try {
            AddToyPrice.execute(price, toyName);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ToyComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //update toy price
    @Override
    public void updateToyPrice(float price, int toyID) {
        try {
            UpdateToyPrice.execute(price, toyID);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ToyComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //delete toy price
    @Override
    public void deleteToyPrice(int toyId) {
        try {
            DeleteToyPrice.execute(toyId);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ToyComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //get toy price
    @Override
    public double getToyCost(int toyID, int numberOfToys) {
        double execute=0;
        try {
            execute = CalculateCost.execute(toyID, numberOfToys);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ToyComputeEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return execute;
    }

    

}
