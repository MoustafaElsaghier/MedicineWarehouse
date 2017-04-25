/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.Attributes.Name;
import javax.swing.JOptionPane;

/**
 *
 * @author القدس
 */
public class medecine_db {

  // insert
    public String insert_med(medecine_attribute med) throws SQLException {
        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();
        try {
            String sql = "insert into medecine(name,produuct_company,price,par_cod,type,quantity)values('" + med.getName() + "','" + med.getCompany() + "','" + med.getPrice() + "','" + med.getPar_code() + "','" + med.getType() + "','" + med.getQuantity() + "')";

            st.execute(sql);
            JOptionPane.showMessageDialog(null, "insert done");
            return "true";
        } catch (Exception ex) {

            System.out.println(ex);
            return "false";
        }

    }
    /////////////////////////////////update

    public String update_med(medecine_attribute med) throws SQLException {

        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();

        String Name = med.getName();
        String Company = med.getCompany();
        int Quantity = med.getQuantity();
        int Price = med.getPrice();
        String ParCode = med.getPar_code();
        String Type = med.getType();
        String Search = med.getSearch();

        try {
            //            String query = "insert into medcine (name,company,quantity,unit_price,parcode,type) "

            String query = "update  medecine set name ='" + Name + "',produuct_company='" + Company + "',"
                    + "quantity='" + Quantity + "',price='" + Price + "' ,par_cod='" + ParCode + "',type='" + Type + "' where name ='" + Search + "'";
            System.out.println(query);

            st.execute(query);
            JOptionPane.showMessageDialog(null, "update done");
            return "true";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "in catch update");
            return "false";
        }

    }
//get data 

    public Object[][] getalldata(medecine_attribute med) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select name,produuct_company,quantity,price,par_cod,type from medecine ";
                rs = st.executeQuery(query);

                System.out.println(query);
                int row = rs.getRow();
                arr = new Object[55][6];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("produuct_company");
                    arr[y][2] = rs.getString("quantity");
                    arr[y][3] = rs.getString("price");
                    arr[y][4] = rs.getString("par_cod");
                    arr[y][5] = rs.getString("type");

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

//delete
    public String deletemed(medecine_attribute med) {

        Connection con = db_connection.getConnect();
        Statement st;
        String name = med.getSearch();

        try {

            String query = "delete from medecine where name='" + name + "'";
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

    public Object[][] searchmed(medecine_attribute med) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select name,produuct_company,quantity,price,par_cod,type from medecine where name like'%" + med.getSearch() + "%'";
                rs = st.executeQuery(query);

                System.out.println(query);
                int row = rs.getRow();
                arr = new Object[55][6];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("produuct_company");
                    arr[y][2] = rs.getString("quantity");
                    arr[y][3] = rs.getString("price");
                    arr[y][4] = rs.getString("par_cod");
                    arr[y][5] = rs.getString("type");

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
