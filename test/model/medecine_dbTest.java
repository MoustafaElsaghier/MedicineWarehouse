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
public class medecine_dbTest {
    medecine_attribute med=new medecine_attribute();
    medecine_db db=new medecine_db();
    
    public medecine_dbTest() {
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
    public void testInsert_med() throws Exception {
       
        med.setName("flagl");
        med.setCompany("mrcsk");
        med.setQuantity(5986);
        med.setPrice(16356);
       med.setPar_code("Wd_56G");
        med.setType("syrup");
        assertTrue(db.insert_med(med), true);
    }

    /**
     * Test of update_med method, of class medecine_db.
     */
    @Test
    public void testUpdate_med() throws Exception {
       med.setSearch("profen");
        med.setName("apamol");
        med.setCompany("mrcsk");
        med.setQuantity(5986);
        med.setPrice(16356);
       med.setPar_code("WK_89G");
        med.setType("capsul");
        assertTrue(db.update_med(med), true);
    }

    

    
    @Test
    public void testDeletemed() {
       med.setSearch("spotless");
        assertTrue(db.deletemed(med), true);
    }
    

   
     
    
    
}
