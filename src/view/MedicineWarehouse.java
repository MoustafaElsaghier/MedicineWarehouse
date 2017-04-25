package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MedicineWarehouse extends JFrame {
    
    JPanel p1;
    Login x;
    MedicineWarehouse(){
        x=new Login();
        p1=new JPanel();
        p1.add(x);
        setSize(700,500);
        setTitle("Medicine Warehouse");
       setLocationRelativeTo(null);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
       
        add(p1);
    }
    
    public static void main(String[] args) {

     new MedicineWarehouse();
    }
    
}
