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
public class indent_dbTest {
    
    indent_attribute ind = new indent_attribute();
    indent_db db =new indent_db();
          
    
    public indent_dbTest() {
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
    public void testInsert_ind() throws Exception {
       ind.setSeller("store");
       ind.setBuyer("seif");
       ind.setDeadline("20/3/2015");
       ind.setPrice(25648);
       ind.setType("export");
        assertTrue(db.insert_ind(ind), true);
        
    }

   
   
    @Test
    public void testUpdate_ind() throws Exception {
    ind.setSearch("export");
        ind.setSeller("store");
       ind.setBuyer("elezaby");
       ind.setDeadline("20/3/2015");
       ind.setPrice(25648);
       ind.setType("export");
        assertTrue(db.update_ind(ind), true);
        
        
        
    }

   
    @Test
    public void testDeleteind() {
       ind.setSearch("import");
        assertTrue(db.deleteind(ind), true);
    }

   
    
    
}
