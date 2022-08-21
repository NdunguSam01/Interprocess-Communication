/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toyservice;

import java.sql.SQLException;
import toyservice.db.DB;

/**
 *
 * @author Rees
 */
public class UpdateToyPrice {
    public static void execute(float price,int toyID) throws SQLException, ClassNotFoundException{
        String sql="update toys set toyPrice = '"+price+"' where toyID ='"+toyID+"'";
        DB.insert(sql);
    }
}
