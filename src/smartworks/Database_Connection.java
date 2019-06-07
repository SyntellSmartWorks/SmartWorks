/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartworks;

import java.sql.*;
import oracle.jdbc.OracleDriver;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reece
 */
public class Database_Connection{
        public static void main(String args[]) throws ClassNotFoundException{  
{
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.31.6.10:1521:ORASYNTEST","STELLB","sqlsql");
            
            Statement stmt = con.createStatement();
            String query1 = "update csa_hwm " 
                            + "set last_token_purchase_ts = '22/APR/19' " 
                            + "where csa_id = '1916972000'";
            stmt.executeUpdate(query1);
            //ResultSet rs = stmt.executeQuery("update csa_hwm set last_token_purchase_ts = '22/APR/19' where csa_id = '1916972000'");
            /*while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); */
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
       
}

