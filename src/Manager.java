import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXML;

import javax.swing.*;
import java.util.ArrayList;


public class Manager  extends DatabaseManagement {


    @FXML
    public void addNewProduct(ArrayList parameters)  {
        System.out.println(parameters.get(0));
        System.out.println(parameters.get(1));
        System.out.println(parameters.get(2));
        System.out.println(parameters.get(3));
        System.out.println(parameters.get(4));
        System.out.println(parameters.get(5));
        try {
           theQuery("INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME,PRICE_NET,TAX_ID, AVAILABILITY, BUILDING_ID) VALUES("+parameters.get(0)
                    +",'"+parameters.get(1)+"',"+parameters.get(2)+","
                    +parameters.get(3)+","+parameters.get(4)+","+parameters.get(5)+")");

        }catch(Exception ex){
        }
    }
    public void deleteProduct(String name) {
        try {
                theQuery("DELETE FROM PRODUCTS WHERE PRODUCT_NAME='"+name+"'");

        }catch(Exception ex){}

    }
    public void updateProduct(ArrayList parameters) {
        try {
            theQuery("UPDATE PRODUCTS SET PRODUCT_NAME='"+parameters.get(1)+"', PRICE_NET ="+parameters.get(2)
                    +",TAX_ID ="+parameters.get(3)+",AVAILABILITY ="+parameters.get(4)+",BUILDING_ID = "+parameters.get(5)
                    +" WHERE PRODUCT_ID="+parameters.get(0));



        }catch(Exception ex){}
    }

    public void addBuilding(ArrayList parameters){
        try {
            theQuery("INSERT INTO BUILDINGS (BUILDING_ID, BUILDING_NAME, ADDRESS_ID) VALUES("+ parameters.get(0)
                    +",'"+parameters.get(1)+"',"+parameters.get(2)+")");


        }catch(Exception ex){
        }
    }
    public void deleteBuilding(String name)
    {
        try {
            theQuery("DELETE FROM BUILDINGS WHERE BUILDING_NAME='"+name+"'");

        }catch(Exception ex){}
    }
    public void updateBuilding(ArrayList parameters){
        try {
            theQuery("UPDATE BUILDINGS SET BUILDING_NAME='"+parameters.get(1)+"', ADDRESS_ID ="+parameters.get(2)
                    +" WHERE BUILDING_ID="+parameters.get(0));

        }catch(Exception ex){}
    }
    public void addAddress(ArrayList parameters){
        try {
            theQuery("INSERT INTO ADDRESSES (ADDRESS_ID, ADDRESS) VALUES("+ parameters.get(0)
                    +",'"+ parameters.get(1)+"')");


        }catch(Exception ex){
        }

    }
    public void deleteAddress(String address)
    {
        try {
            theQuery("DELETE FROM ADDRESSES WHERE ADDRESS='"+address+"'");

        }catch(Exception ex){}
    }

    public void updateAddress(ArrayList parameters){
        try {
            theQuery("UPDATE ADDRESSES SET ADDRESS='"+parameters.get(1)
                    +"' WHERE ADDRESS_ID="+parameters.get(0));
        }catch(Exception ex){}
    }

    public void addTax(ArrayList parameters){
        try {

            theQuery("INSERT INTO TAX (TAX_ID,TAX_VALUE,TAX_DESCRIPTION) VALUES ("+ parameters.get(0)
                    +",'"+ parameters.get(1)+"','"+ parameters.get(2)+"')");

        }catch(Exception ex){
        }

    }
    public void updateTax(ArrayList parameters){
        String s = (String)parameters.get(1);
        String x = s.replace(".","0,");

        System.out.println(parameters.get(0));
        System.out.println(x);
        System.out.println(parameters.get(2));
        try {
            theQuery("UPDATE TAX SET TAX_VALUE='"+x+"', TAX_DESCRIPTION ='"+parameters.get(2)
                    +"' WHERE TAX_ID="+parameters.get(0));
        }catch(Exception ex){}
    }

    public void deleteTax(String value)
    {
        String x= value.replace(".","0,");
        try {
            theQuery("DELETE FROM TAX WHERE TAX_VALUE='"+x+"'");

        }catch(Exception ex){}
    }
    public void addCustomer(ArrayList parameters) {

        try {
            theQuery("INSERT INTO CUSTOMERS (CUSTOMER_ID,FIRST_NAME,LAST_NAME,COMPANY_NAME,PHONE_NUMBER,E_MAIL,ADDRESS_ID,DISCOUNT_ID,CUSTOMER_PASSWORD) VALUES (" + parameters.get(0)
                    + ",'" + parameters.get(1) + "','" + parameters.get(2) + "','"
                    + parameters.get(3) + "'," +parameters.get(4)+ ",'" + parameters.get(5) + "',"
                    + parameters.get(6) + "," +parameters.get(7) + ",'" +parameters.get(8)+ "')");



        } catch (Exception ex) {
        }
    }
    public void deleteCustomer(String name, String lastName )
    {
        try {
            theQuery("DELETE FROM CUSTOMERS WHERE FIRST_NAME='"+name+"' AND LAST_NAME='"+lastName+"'");

        }catch(Exception ex){}
    }
    public void updateCustomer(ArrayList parameters) {

        try {
            theQuery("UPDATE CUSTOMERS SET FIRST_NAME='" + parameters.get(1) + "', LAST_NAME ='" +  parameters.get(2)
                    + "',COMPANY_NAME ='" +  parameters.get(3) + "',PHONE_NUMBER =" +  parameters.get(4)
                    + ",E_MAIL = '" +  parameters.get(5) + "',ADDRESS_ID=" +  parameters.get(6) + ",DISCOUNT_ID=" +  parameters.get(7) +",CUSTOMER_PASSWORD='"+parameters.get(8)+"'"
                    + " WHERE CUSTOMER_ID=" +  parameters.get(0));

        } catch (Exception ex) {}}
    public void addEmployee(ArrayList parameters){
        System.out.println(parameters.get(0));
        System.out.println(parameters.get(1));
        System.out.println(parameters.get(2));
        System.out.println(parameters.get(3));
        System.out.println(parameters.get(4));
        System.out.println(parameters.get(5));
        System.out.println(parameters.get(6));
        System.out.println(parameters.get(7));
        try {
            theQuery("INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME,LAST_NAME,SALARY,DATE_OF_BIRTH,HIRE_DATE,BUILDING_ID,EMPLOYEE_PASSWORD) VALUES("+ parameters.get(0)
                    +",'"+parameters.get(1)+"','"+parameters.get(2)+"',"
                    +parameters.get(3)+",'"+parameters.get(4)+"','"+parameters.get(5)+"',"
                    +parameters.get(6)+",'"+parameters.get(7)+"')");

        }catch(Exception ex){
        }

    }
    public void deleteEmployee(String name, String lastName )
    {
        try {
            theQuery("DELETE FROM EMPLOYEES WHERE FIRST_NAME='"+name+"' AND LAST_NAME='"+lastName+"'");

        }catch(Exception ex){}
    }
    public void updateEmployee(ArrayList parameters){

        try {
            theQuery("UPDATE EMPLOYEES SET FIRST_NAME='"+parameters.get(1)+"', LAST_NAME ='"+parameters.get(2)
                    +"',SALARY ="+parameters.get(3)+",DATE_OF_BIRTH ='"+parameters.get(4)+"',HIRE_DATE = '"
                    +parameters.get(5)+"',BUILDING_ID="+parameters.get(6)+",EMPLOYEE_PASSWORD='"+parameters.get(7)
                    +"' WHERE EMPLOYEE_ID="+parameters.get(0));

        }catch(Exception ex){}
    }
}
