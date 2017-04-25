/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;


import model.user_attribute;
import model.user_db;

/**
 *
 * @author القدس
 */
public class user_control {
    
 user_db  db=new user_db();
    
     
   

    public void adduser(user_attribute usname) throws SQLException {

  db.add_user(usname);

    }   
    
    
    
    
    
    
    
    
    
    
    
}
