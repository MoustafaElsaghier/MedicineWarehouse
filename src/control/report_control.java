/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import model.report_attribute;
import model.report_db;

/**
 *
 * @author القدس
 */
public class report_control {
     report_db db =new report_db();
    
    public void insert_rep(report_attribute rep) throws SQLException {

  db.insert_rep(rep);

    }
     public Object[][] getalldatarep(report_attribute rep) throws SQLException {

 return db.getalldatarep(rep);

    }
      public void update_rep(report_attribute rep) throws SQLException {

  db.updaterep(rep);

    }
     public void deleterep(report_attribute rep) throws SQLException {

       db.deleterep(rep);

    }
       public Object[][] searchrep(report_attribute rep) throws SQLException {

    return db.searchrep(rep);

    
}
   
}
