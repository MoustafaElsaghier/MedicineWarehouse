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
public class company_db {
    
     // insert

    public static String insert_comp(company_attribute comp) throws SQLException {
    Connection con = db_connection.getConnect();
    Statement st = con.createStatement();
        try {
            String sql = "insert into company(name,address,email,phone)values('" + comp.getName() + "','" + comp.getAddress() + "','" + comp.getEmail() + "','" + comp.getPhone() + "')";

            st.execute(sql);
             JOptionPane.showMessageDialog(null, "insert done");
             return sql;
        } catch (Exception ex) {

            System.out.println(ex);
   return "false";
        }

    }
    
   //get data 

public Object[][] getalldatacomp(company_attribute comp) {
   Connection con = db_connection.getConnect();
    Statement st;
        Object arr[][] = null;

        try {
            st =con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select name,address,email,phone from company ";
                rs = st.executeQuery(query);

                System.out.println(query);
                int row = rs.getRow();
                arr = new Object[55][4];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("address");
                    arr[y][2] = rs.getString("email");
                    arr[y][3] = rs.getString("phone");
                  

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
    
    
    /////////////////////////////////update

    public static String update_comp(company_attribute comp) throws SQLException {

          Connection con = db_connection.getConnect();
          Statement st = con.createStatement();

        String Name = comp.getName();
        String address = comp.getAddress();
        String email = comp.getEmail();
        int phone = comp.getPhone();
       String Search = comp.getSearch();

        try {
           

            String query = "update  company set name ='" + Name + "',address='" + address + "',"
                    + "email='" + email + "',phone='" + phone + "' where name ='" + Search + "'";
            System.out.println(query);
          
            st.execute(query);
           
            JOptionPane.showMessageDialog(null, "update done");
            return "true";
        } catch (Exception ex) {
 JOptionPane.showMessageDialog(null,ex);
           JOptionPane.showMessageDialog(null, "in catch update");
           return "false" ;
        }
      
    }
    
    
     public static String deletecomp(company_attribute comp){
        
        Connection con = db_connection.getConnect();
        Statement st;
        String name =comp.getSearch();

        try {

            String query = "delete from company where name='" +name + "'";
            st = con.createStatement();
          
            JOptionPane.showMessageDialog(null, "delete done");
            st.execute(query);
return  "true";
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,ex);
            return  "false";
        }


    }
    //search 
     
 public Object [][] searchcomp(company_attribute comp) {
 Connection con = db_connection.getConnect();
     Statement st;
        Object arr[][] = null;

        try {
            st=con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select name,address,email,phone from company where name like'%"+comp.getSearch()+"%'";
                rs = st.executeQuery(query);

                System.out.println(query);
                int row = rs.getRow();
                arr = new Object[55][4];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("address");
                    arr[y][2] = rs.getString("email");
                    arr[y][3] = rs.getString("phone");
                   
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
