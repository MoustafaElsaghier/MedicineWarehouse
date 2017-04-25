/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import model.medecine_attribute;
import model.medecine_db;

/**
 *
 * @author القدس
 */
public class medecine_control {

    medecine_db db = new medecine_db();

    public void insert_medn(medecine_attribute med) throws SQLException {

        db.insert_med(med);

    }

    public void update_medn(medecine_attribute med) throws SQLException {

        db.update_med(med);

    }

    public Object[][] getalldatamed(medecine_attribute med) throws SQLException {

        return db.getalldata(med);

    }

    public void deletemed(medecine_attribute med) throws SQLException {

        db.deletemed(med);

    }

    public Object[][] searchmed(medecine_attribute med) throws SQLException {

        return db.searchmed(med);

    }

}
