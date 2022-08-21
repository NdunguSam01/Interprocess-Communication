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
public interface ToyComputeInterface {
    public void addToyPrice(float price,String toyName);
    public void updateToyPrice(float price,int toyID);
    public void deleteToyPrice(int toyId);
    public double getToyCost(int toyID,int numberOfToys);
    public String returnTransaction(int amountPaid);
}
