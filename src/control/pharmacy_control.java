/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;


import model.pharmacy_attribute;
import model.pharmacy_db;

/**
 *
 * @author القدس
 */
public class pharmacy_control {
     pharmacy_db db =new pharmacy_db();
    
    public void insert_pharm(pharmacy_attribute pharm) throws SQLException {

  db.insert_pharm(pharm);

    }
      public Object[][] getalldatapharm(pharmacy_attribute pharm) throws SQLException {

 return db.getalldatapharm(pharm);

    }
      
       public void update_pharm(pharmacy_attribute pharm) throws SQLException {

  db.update_pharm(pharm);

    }
       
       
        public void deletepharm(pharmacy_attribute pharm) throws SQLException {

       db.deletepharm(pharm);

    }
          public Object[][] searchpharm(pharmacy_attribute pharm) throws SQLException {

    return db.searchpharm(pharm);

    }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
      
      
      
}

