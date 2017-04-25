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
public class indent_db {

    // insert
    public String insert_ind(indent_attribute ind) throws SQLException {
        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();
        try {
            String sql = "insert into indent(seller,buyer,type,price,deadline)values('" + ind.getSeller() + "','" + ind.getBuyer() + "','" + ind.getType() + "','" + ind.getPrice() + "','" + ind.getDeadline() + "')";

            st.execute(sql);
            JOptionPane.showMessageDialog(null, "insert done");
            return "true";
        } catch (Exception ex) {

            System.out.println(ex);
            return "false";

        }

    }

    //get data 
    public Object[][] getalldataind(indent_attribute ind) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select seller,buyer,type,price,deadline from indent ";
                rs = st.executeQuery(query);

                int row = rs.getRow();
                arr = new Object[55][5];
                while (rs.next()) {
                    arr[y][0] = rs.getString("seller");
                    arr[y][1] = rs.getString("buyer");
                    arr[y][2] = rs.getString("type");
                    arr[y][3] = rs.getString("price");
                    arr[y][4] = rs.getString("deadline");

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
    public String update_ind(indent_attribute ind) throws SQLException {

        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();

        String seller = ind.getSeller();

        String buyer = ind.getBuyer();
        String type = ind.getType();
        int price = ind.getPrice();
        String deadline = ind.getDeadline();
        String Search = ind.getSearch();

        try {

            String query = "update  indent set seller ='" + seller + "',buyer='" + buyer + "',"
                    + "price='" + price + "',deadline='" + deadline + "',type='" + type + "' where type ='" + Search + "'";

            st.execute(query);
            JOptionPane.showMessageDialog(null, "update done");
            return "true";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "in catch update");
            return "false";
        }

    }
    ///////////////////// delete

    public String deleteind(indent_attribute ind) {

        Connection con = db_connection.getConnect();
        Statement st;
        String type = ind.getSearch();

        try {

            String query = "delete from indent where type='" + type + "'";
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
    public Object[][] searchind(indent_attribute ind) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select seller,buyer,type,price,deadline from indent where type"
                        + " like'%" + ind.getSearch() + "%'";
                rs = st.executeQuery(query);

                System.out.println(query);
                int row = rs.getRow();
                arr = new Object[55][5];
                while (rs.next()) {
                    arr[y][0] = rs.getString("seller");
                    arr[y][1] = rs.getString("buyer");
                    arr[y][2] = rs.getString("type");
                    arr[y][3] = rs.getString("price");
                    arr[y][4] = rs.getString("deadline");
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
