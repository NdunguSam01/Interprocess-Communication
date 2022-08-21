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
public class AddToyPrice {
    public static void execute(float price,String toyName) throws SQLException, ClassNotFoundException{
        String sql="insert into toys(toyName,toyPrice) values('"+toyName+"','"+price+"')";
        DB.insert(sql);
    }
}
