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
public class report_dbTest {
    report_attribute rep=new report_attribute();
    report_db db =new report_db();
    
    
    public report_dbTest() {
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
    public void testInsert_rep() throws Exception {
        
        rep.setTitle("bill");
        rep.setType("import");
        rep.setDate("20/2/2015");
        rep.setDetails("mrcsk is excellent company");
        
        assertTrue(db.insert_rep(rep), true);
    }

    

    
    @Test
    public void testUpdaterep() throws Exception {
       
        rep.setSearch("company");
       rep.setTitle("offers");
        rep.setType("import");
        rep.setDate("20/3/2016");
        rep.setDetails("offers is more ");
        
        assertTrue(db.updaterep(rep), true);
        
    }

   
    @Test
    public void testDeleterep() {
       rep.setSearch("medecien");
        
        assertTrue(db.deleterep(rep), true);
    }

    
    
    
}
