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
public class report_db {

    public String insert_rep(report_attribute rep) throws SQLException {
        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();
        try {
            String sql = "insert into report(title,date,type,details)values('" + rep.getTitle() + "','" + rep.getDate() + "','" + rep.getType() + "','" + rep.getDetails() + "')";

            st.execute(sql);
            JOptionPane.showMessageDialog(null, "insert done");
            return "true";
        } catch (Exception ex) {

            System.out.println(ex);
            return "false";

        }

    }

    //get data 
    public Object[][] getalldatarep(report_attribute rep) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select title,date,type,details from report ";
                rs = st.executeQuery(query);

                int row = rs.getRow();
                arr = new Object[55][4];
                while (rs.next()) {
                    arr[y][0] = rs.getString("title");
                    arr[y][1] = rs.getString("date");
                    arr[y][2] = rs.getString("type");
                    arr[y][3] = rs.getString("details");

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
    public String updaterep(report_attribute rep) throws SQLException {

        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();

        String title = rep.getTitle();
        String date = rep.getDate();
        String type = rep.getType();
        String details = rep.getDetails();
        String Search = rep.getSearch();

        try {

            String query = "update report set title ='" + title + "',date='" + date + "',"
                    + "type='" + type + "',details='" + details + "' where title ='" + Search + "'";

            st.execute(query);
            JOptionPane.showMessageDialog(null, "update done");
            return "true";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "in catch update");
            return "false";
        }

    }

    public String deleterep(report_attribute rep) {

        Connection con = db_connection.getConnect();
        Statement st;
        String name = rep.getSearch();

        try {

            String query = "delete from report where title='" + name + "'";
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
    public Object[][] searchrep(report_attribute rep) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            try {

                String query = "select title,date,type,details from report where title like'%" + rep.getSearch() + "%'";
                rs = st.executeQuery(query);

                int row = rs.getRow();
                arr = new Object[55][4];
                while (rs.next()) {
                    arr[y][0] = rs.getString("title");
                    arr[y][1] = rs.getString("date");
                    arr[y][2] = rs.getString("type");
                    arr[y][3] = rs.getString("details");

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
