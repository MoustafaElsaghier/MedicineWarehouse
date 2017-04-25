
package control;

import java.sql.SQLException;
import model.bill_attribute;
import model.bill_db;


/**
 *
 * @author القدس
 */
public class bill_control {
    
    
    bill_db db =new bill_db();
    
    public void insert_bill(bill_attribute bill) throws SQLException {

  db.insert_bill(bill);

    }
     public Object[][] getalldatabill(bill_attribute bill) throws SQLException {

 return db.getalldatabill(bill);

    }
      public void update_bill(bill_attribute bill) throws SQLException {

  db.update_bill(bill);

    }
     public void deletebill(bill_attribute bill) throws SQLException {

       db.deletebill(bill);

    }
       public Object[][] searchbill(bill_attribute bill) throws SQLException {

    return db.searchbill(bill);

    
}
    
    
}
