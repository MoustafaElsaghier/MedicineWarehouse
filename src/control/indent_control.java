/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import model.indent_attribute;

import model.indent_db;

/**
 *
 * @author القدس
 */
public class indent_control {
    
    indent_db db =new indent_db();
    
    public void insert_ind(indent_attribute ind) throws SQLException {

  db.insert_ind(ind);

    }
     public Object[][] getalldataind(indent_attribute ind) throws SQLException {

 return db.getalldataind(ind);

    }
     
      public void update_ind(indent_attribute ind) throws SQLException {

  db.update_ind(ind);

    }
     public void deleteind(indent_attribute ind) throws SQLException {

       db.deleteind(ind);

    }
       public Object[][] searchind(indent_attribute ind) throws SQLException {

    return db.searchind(ind);

    }
}

    
    
    
    
    
    
    
    
    
    
