import javafx.fxml.FXML;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Worker extends DatabaseManagement {

    static String name;

    public Worker() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Worker.name = name;
    }

    @FXML
    public void addNewOrder(ArrayList parameters)  {
        int dostepnosc = 0;
        Boolean odejmij = true;

        try{
            Connection con_1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","warehouse","password");
            ResultSet rs = con_1.createStatement().executeQuery("SELECT AVAILABILITY FROM PRODUCTS WHERE PRODUCT_ID LIKE " + parameters.get(6).toString());

            rs.next();
           // System.out.println(rs.getString("AVAILABILITY"));
            dostepnosc = Integer.parseInt(rs.getString("AVAILABILITY"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(dostepnosc < Integer.parseInt(parameters.get(7).toString())){
            JOptionPane.showMessageDialog(null, "Za mało produktów by dokonać transakcji!");
        }
        else {
            try {

                theQuery("INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID,EMPLOYEE_ID, STATUS, ORDER_DATE, COMMENTS) VALUES(" + parameters.get(0)
                        + "," + parameters.get(1) + "," + parameters.get(2) + ",'"
                        + parameters.get(3) + "','" + parameters.get(4) + "','" + parameters.get(5) + "')");

                theQuery("INSERT INTO ORDER_DETAILS (ORDER_ID, PRODUCT_ID,PRODUCT_AMMOUNT) VALUES(" + parameters.get(0)
                        + "," + parameters.get(6) + "," + parameters.get(7) + ")");



                theQuery("UPDATE PRODUCTS SET AVAILABILITY = " + (dostepnosc - Integer.parseInt(parameters.get(7).toString()))
                            + "WHERE PRODUCT_ID= " + parameters.get(6));

                } catch (Exception ex) {
                      }
        }
    }

    public void updateOrder(ArrayList parameters) {
        try {
            theQuery("UPDATE ORDERS SET CUSTOMER_ID="+parameters.get(1)+", EMPLOYEE_ID ="+parameters.get(2)
                    +",STATUS ='"+parameters.get(3)+"',ORDER_DATE ='"+parameters.get(4)+"',COMMENTS = '"+parameters.get(5)
                    +"' WHERE ORDER_ID="+parameters.get(0));

            theQuery("UPDATE ORDER_DETAILS SET ORDER_ID="+parameters.get(6)+", PRODUCT_ID ="+parameters.get(7)
                    +" WHERE ORDER_ID="+parameters.get(0));
        }catch(Exception ex){}
    }
}
