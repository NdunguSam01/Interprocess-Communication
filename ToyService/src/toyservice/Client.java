/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyservice;

import java.net.MalformedURLException;
import java.rmi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import toyservice.db.DB;

/**
 *
 * @author Rees
 */
public class Client {

    /**
     * @return 
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static String getToys() throws SQLException, ClassNotFoundException{
        String sql="select * from toys";
        ResultSet result = DB.select(sql);
        float price = 0;
        String name,output= "";
        while (result.next()){
            output+="\n"+result.getInt("toyID")+". "+result.getString("toyName");
        }
        return output;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
        try {
            //create stub object
            ToyComputeEngine stub=(ToyComputeEngine)Naming.lookup("rmi://localhost:1099/toyservice");
           
            
            //AddToyPrice.execute(25,"Car");
            //UpdateToyPrice.execute(25,2);
            //DeleteToyPrice.execute(1);
            //CalculateCost.execute(2, 127);

            // initialize user input
            Scanner sc=new Scanner(System.in);
            int x =9;
            int opt =0;
            
            //print agent name
            System.out.println("Enter your agent name to proceed:\t");
            String agent= sc.nextLine();
            
            //display menu
            System.out.println("\nWelcome "+agent+" to Wholesale Toy Servce"
                    + "\nSelect an item on the menu to continue:"
                    + getToys()
                    + "\nPress 0 to exit\t:");
            x= sc.nextInt();
            
            //loop user menu
            do{
                if(x==1){
                    String tname="";
                    System.out.println("\nAdd Toy price\nEnter Toy Name:\t");
                    tname= sc.nextLine();
                    if ("99".equals(tname)){
                        System.out.println("\nWelcome "+agent+" to Wholesale Toy Servce"
                                + "\nSelect an item on the menu to continue:"
                                + "\n1. Sell Toys"
                                + "\n2. Update Toy Price"
                                + "\n3. Delete Toys"
                                + "\nPress 0 to exit\t:");
                        x= sc.nextInt();
                    } else{
                        System.out.println("\nEnter price:\n");
                        float amount = sc.nextInt();
                        stub.addToyPrice(amount, tname);
                    }
                }
                else if(x==2){
                    System.out.println("\nSell Toys\nSelect toy to proceed:\n"
                            + getToys()
                            + "\n 99. Main Menu\t:");
                    opt= sc.nextInt();
                    if (opt==99){
                        System.out.println("\nWelcome "+agent+" to Wholesale Toy Servce"
                                + "\nSelect an item on the menu to continue:"
                                + "\n1. Sell Toys"
                                + "\n2. Update Toy Price"
                                + "\n3. Delete Toys"
                                + "\nPress 0 to exit\t:");
                        x= sc.nextInt();
                    } else{
                        int amount =0;
                        System.out.println("\nEnter number of toys bought:\n");
                        amount = sc.nextInt();
                        stub.getToyCost(opt, amount);
                        System.out.println("\nPress 0 to exit:\n");
                    }

                } else if(x==3){
                    System.out.println("\n\nUpdate Toy Price\nSelect toy to proceed:\n"
                            + getToys()
                            + "\n 99. Main Menu\t:");
                    opt= sc.nextInt();
                    if (opt==99){
                        System.out.println("\nWelcome "+agent+" to Wholesale Toy Servce"
                                + "\nSelect an item on the menu to continue:"
                                + "\n1. Sell Toys"
                                + "\n2. Update Toy Price"
                                + "\n3. Delete Toys"
                                + "\nPress 0 to exit\t:");
                        x= sc.nextInt();
                    } else{
                        float amount =0;
                        System.out.println("\nEnter new toy price:\n");
                        amount = sc.nextFloat();
                        stub.updateToyPrice(amount, opt);
                        
                    }

                } else if (x==4){
                    System.out.println("\nSelect toy to delete:\n"
                            + getToys()
                            + "\n 99. Main Menu\t:");
                    opt= sc.nextInt();
                    if (opt==99){
                        System.out.println("\nWelcome "+agent+" to Wholesale Toy Servce"
                                + "\nSelect an item on the menu to continue:"
                                + "\n1. Sell Toys"
                                + "\n2. Update Toy Price"
                                + "\n3. Delete Toys"
                                + "\nPress 0 to exit\t:");
                        x= sc.nextInt();
                    } else{
                        stub.deleteToyPrice(opt);
                    }
                } else if (opt==99){
                    System.out.println("\nWelcome "+agent+" to Wholesale Toy Servce"
                            + "\nSelect an item on the menu to continue:"
                            + "\n1. Sell Toys"
                            + "\n2. Update Toy Price"
                            + "\n3. Delete Toys"
                            + "\nPress 0 to exit\t:");
                    x= sc.nextInt();
                }
            } while(x!=0);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
