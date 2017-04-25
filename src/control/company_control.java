/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import model.company_attribute;
import model.company_db;


/**
 *
 * @author القدس
 */
public class company_control {
    
    company_db db =new company_db();
    
    public void insert_comp(company_attribute comp) throws SQLException {

  db.insert_comp(comp);

    }
     public Object[][] getalldatacomp(company_attribute comp) throws SQLException {

 return db.getalldatacomp(comp);

    }
     
      public void update_comp(company_attribute comp) throws SQLException {

  db.update_comp(comp);

    }
     public void deletecomp(company_attribute comp) throws SQLException {

       db.deletecomp(comp);

    }
       public Object[][] searchcomp(company_attribute comp) throws SQLException {

    return db.searchcomp(comp);

    }
}
