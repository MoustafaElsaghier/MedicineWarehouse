/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author القدس
 */
public class pharmacy_dbTest {
    pharmacy_attribute pharm=new pharmacy_attribute();
    pharmacy_db db= new pharmacy_db();
    
    public pharmacy_dbTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testInsert_pharm() throws Exception {
      
        pharm.setName("seif");
        pharm.setAddress("Cairo");
        pharm.setEmail("seif@.com");
        pharm.setPhone(102458565);
        pharm.setRepresentative("Eslam Mohammed");
        assertTrue(db.insert_pharm(pharm), true);
        
        
    }

   
   

   
    @Test
    public void testUpdate_pharm() throws Exception {
        pharm.setSearch("elezaby");
        pharm.setName("elezaby");
        pharm.setAddress("tanta");
        pharm.setEmail("seif@.com");
        pharm.setPhone(102458565);
        pharm.setRepresentative("Eslam Mohammed");
        assertTrue(db.update_pharm(pharm), true);
        
        
        
    }

    
    @Test
    public void testDeletepharm() {
       pharm.setSearch("elImage");
         assertTrue(db.deletepharm(pharm), true);
        
        
    }

    
   
    
}
