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
public class bill_dbTest {
    bill_attribute b=new bill_attribute();
    bill_db db= new bill_db();
    
    public bill_dbTest() {
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
    public void testInsert_bill() throws Exception {
     
        b.setName("profen");
        b.setDate("2545");
        b.setType("import");
        b.setTotal(54545);
        assertTrue(db.insert_bill(b), true);
    }

   


   
    @Test
    public void testUpdate_bill() throws Exception {
        b.setSearch("petaderm");
        b.setName("retaderm");
        b.setDate("18/4/2016");
        b.setType("import");
        b.setTotal(6745);
        assertTrue(db.update_bill(b), true);
    }

  
    @Test
    public void testDeletebill() {
       b.setSearch("flagl&spotless");
        assertTrue(db.deletebill(b), true);
    }

  
  
    
}
