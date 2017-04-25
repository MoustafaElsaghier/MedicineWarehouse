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
public class bill_db {

    public String insert_bill(bill_attribute bill) throws SQLException {
        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();
        try {
            String sql = "insert into bill(name,date,type,total)values('" + bill.getName() + "','" + bill.getDate() + "','" + bill.getType() + "','" + bill.getTotal() + "')";

            st.execute(sql);
            JOptionPane.showMessageDialog(null, "insert done");
            return "true";
        } catch (Exception ex) {

            System.out.println(ex);
            return "false";

        }

    }

    //get data 
    public Object[][] getalldatabill(bill_attribute bill) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;

            String query = "select name,date,type,total from bill ";
            rs = st.executeQuery(query);

            int row = rs.getRow();
            arr = new Object[row][4];
            while (rs.next()) {
                arr[y][0] = rs.getString("name");
                arr[y][1] = rs.getString("date");
                arr[y][2] = rs.getString("type");
                arr[y][3] = rs.getString("total");

                y++;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return arr;
    }

    /////////////////////////////////update
    public String update_bill(bill_attribute bill) throws SQLException {

        Connection con = db_connection.getConnect();
        Statement st = con.createStatement();

        String Name = bill.getName();
        String date = bill.getDate();
        String type = bill.getType();
        int total = bill.getTotal();
        String Search = bill.getSearch();

        try {

            String query = "update  bill set name ='" + Name + "',date='" + date + "',"
                    + "type='" + type + "',total='" + total + "' where name ='" + Search + "'";

            st.execute(query);
            JOptionPane.showMessageDialog(null, "update done");
            return "true";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(null, "in catch update");
            return "false";
        }

    }

    public String deletebill(bill_attribute bill) {

        Connection con = db_connection.getConnect();
        Statement st;
        String name = bill.getSearch();

        try {

            String query = "delete from bill where name='" + name + "'";
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
    public Object[][] searchbill(bill_attribute bill) {
        Connection con = db_connection.getConnect();
        Statement st;
        Object arr[][] = null;

        try {
            st = con.createStatement();

            ResultSet rs;
            int y = 0;
            try {

                String query = "select name,date,type,total from bill where name like'%" + bill.getSearch() + "%'";
                rs = st.executeQuery(query);

                int row = rs.getRow();
                arr = new Object[row][4];
                while (rs.next()) {
                    arr[y][0] = rs.getString("name");
                    arr[y][1] = rs.getString("date");
                    arr[y][2] = rs.getString("type");
                    arr[y][3] = rs.getString("total");

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
