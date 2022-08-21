/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyservice;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import toyservice.db.DB;
/**
 *
 * @author Rees
 */
public class CalculateCost {
    public static double execute(int toyID,int numberOfToys) throws SQLException, ClassNotFoundException{
       
        //get toy price
        String sql="select * from toys where toyID = '"+toyID+"'";
        ResultSet result = DB.select(sql);
        float price = 0;
        String name= "";
        while (result.next()){
            price = result.getFloat("toyPrice");
            name = result.getString("toyName");
        }
        
        //initialize variables
        double cost = 0;
        double originalPrice = price * numberOfToys;
        
        //reduce price by 5 percent
        if(numberOfToys>=20){
            //get number of times to multiply the percentage discount.
            int times = numberOfToys/20;
            int remainder = numberOfToys%20;
            
            //calculate percentage in multiples of 20
            double sum = 0;
            int counter = 1;
            for(int i=0;i<times;i++){
                //check if discount has reached 25%
                if(counter>=25){
                   sum+=price*20;
                } else{
                   sum += (price*20)*0.95; 
                }
                //log 5%
                counter+=5;
            }
            //add totals for any remaining toys not reaching the count of 20
            sum+=remainder*price;
            cost = sum;
        } else{
            cost = numberOfToys * price;
        }
        
        
        //calculate discount
        double discount = originalPrice-cost;
        String s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        String output = "\n Wholesale Toy Service Store"
                
                + "\n P.O BOX 20-00200"
                + "\n +2547934678343"
                + "\n\n Date: "+s
                + "\n\n Sales receipt"
                + "\n -------------"
                + "\n Item \tQty"
                + "\n ----\t----"
                + "\n "+name+"\t"+numberOfToys
                + "\n\n ---------------------------"
                + "\n Cost Price: Kes "+originalPrice
                + "\n Selling Price: Kes "+cost
                + "\n Discount: Kes "+discount
                + "\n ---------------------------"
                + "\n Payment: Kes "+cost
                + "\n ---------------------------"
                + "\n\nThank you for shopping with us!\n";
        
        System.out.println(output);
        return cost;
    }
}
