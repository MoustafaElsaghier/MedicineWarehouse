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
public class company_dbTest {
company_attribute comp = new company_attribute();
company_db db= new company_db();
    public company_dbTest() {
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

    /**
     * Test of insert_comp method, of class company_db.
     */
    @Test
    public void testInsert_comp() throws Exception {
        
        comp.setName("alpha");
        comp.setAddress("us");
        comp.setEmail("alpha@.com");
        comp.setPhone(24585);
        assertTrue(company_db.insert_comp(comp), true);

    }

   
    @Test
    public void testUpdate_comp() throws Exception {
        
       comp.setSearch("apex pharma");
       comp.setName("pharma");
       comp.setAddress("alex");
       comp.setEmail("apex pharma@.com");
       comp.setPhone(24589);
 assertTrue(db.update_comp(comp), true);
    }

   
    @Test
    public void testDeletecomp() {
        comp.setSearch("alpha");
         assertTrue(company_db.deletecomp(comp), true);

    }

    

}
