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
public class pharmacy_db {

    // insert
    public String insert_pharm(pharmacy_attribute pharm) throws SQLException {
        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();
        try {
            String sql = "insert into pharmacy(name,address,email,phone,representative)values('" + pharm.getName() + "','" + pharm.getAddress() + "','" + pharm.getEmail() + "','" + pharm.getPhone() + "','" + pharm.getRepresentative() + "')";

            st.execute(sql);
            JOptionPane.showMessageDialog(null, "insert done");
            return "true";
        } catch (Exception ex) {

            System.out.println(ex);
            return "false";
        }

    }

    public Object[][] getalldatapharm(pharmacy_attribute pharm) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select name,address,email,phone,representative from pharmacy ";
                rs = st.executeQuery(query);

                System.out.println(query);
                int row = rs.getRow();
                arr = new Object[55][5];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("address");
                    arr[y][2] = rs.getString("email");
                    arr[y][3] = rs.getString("phone");
                    arr[y][4] = rs.getString("representative");

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

    public String update_pharm(pharmacy_attribute pharm) throws SQLException {

        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();

        String Name = pharm.getName();
        String address = pharm.getAddress();
        String email = pharm.getEmail();
        int phone = pharm.getPhone();
        String representative = pharm.getRepresentative();
        String Search = pharm.getSearch();

        try {

            String query = "update  pharmacy set name ='" + Name + "',address='" + address + "',"
                    + "email='" + email + "',representative='" + representative + "',phone='" + phone + "' where name ='" + Search + "'";
            System.out.println(query);

            st.execute(query);
            JOptionPane.showMessageDialog(null, "update done");
            return "true";
        } catch (Exception ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "in catch update");
            return "false";
        }

    }

    public String deletepharm(pharmacy_attribute pharm) {

        Connection con = db_connection.getConnect();
        Statement st;
        String name = pharm.getSearch();

        try {

            String query = "delete from pharmacy where name='" + name + "'";
            st = con.createStatement();

            st.execute(query);
            JOptionPane.showMessageDialog(null, "delete done");
            return "true";
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex);
            return "false";
        }

    }

    //search 
    public Object[][] searchpharm(pharmacy_attribute pharm) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select name,address,email,phone,representative from pharmacy where name like'%" + pharm.getSearch() + "%'";
                rs = st.executeQuery(query);

                int row = rs.getRow();
                arr = new Object[55][5];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("address");
                    arr[y][2] = rs.getString("email");
                    arr[y][3] = rs.getString("phone");
                    arr[y][4] = rs.getString("representative");
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
