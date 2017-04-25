/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author القدس
 */
public class user_db {
    
    
    
     public void add_user(user_attribute usname) throws SQLException {
    Connection con = db_connection.getConnect();
    Statement st = con.createStatement();
        try {
            String sql = "insert into users(username,password)values('"+usname.getUsername()+"','"+usname.getPassword()+"')";

            st.execute(sql);
            JOptionPane.showMessageDialog(null, "insert done");
           
        } catch (Exception ex) {

            System.out.println(ex);

        }
    
    
    
    
     }
    
  public Object[][] getalldatauser(user_attribute user) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select username,password from users ";
                rs = st.executeQuery(query);

                int row = rs.getRow();
                arr = new Object[55][2];
                while (rs.next()) {
                    arr[y][0] = rs.getString("username");
                    arr[y][1] = rs.getString("password");
                 
                    y++;
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arr;
    }  
    
}   
    
    

