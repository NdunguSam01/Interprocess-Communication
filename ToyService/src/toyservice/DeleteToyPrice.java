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
public class DeleteToyPrice {
    public static void execute(int toyID) throws SQLException, ClassNotFoundException{
        String sql="delete from toys where toyID ='"+toyID+"'";
        DB.insert(sql);
    }
}
