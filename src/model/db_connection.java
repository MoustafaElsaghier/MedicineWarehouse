/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author القدس
 */
public class db_connection {

    private static Connection con;

    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/medical store", "root", "");
            
            
           
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
          
        }
        
        System.out.println(con);
        
        return con;
    }

    public static void connect() {
        if (con == null) {

            getConnect();
            System.out.println("connection success");
        }

    }

    public static void disconnect() {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public static void main(String[] args) {
        Connection con = getConnect();
    }
}
