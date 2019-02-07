import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ManagerController implements Initializable {

    @FXML
    private Pane managerPane;

    @FXML
    private Button closeButton;

    @FXML
    private TextField product_IDTextField;

    @FXML
    private TextField productNameTextField;

    @FXML
    private TextField netPriceTextField;

    @FXML
    private TextField tax_IDTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField building_IDTextField;

    @FXML
    private Button addProductButton;

    @FXML
    private Button deleteProductButton;

    @FXML
    private Button updateProductButton;

    @FXML
    private RadioButton addProductRadioButton;

    @FXML
    private ToggleGroup produkty;

    @FXML
    private RadioButton deleteRadioProductButton;

    @FXML
    private RadioButton updateProductRadioButton;

    @FXML
    private TableView<ProductModelTable> productTableView;

    @FXML
    private TableColumn<ProductModelTable, String> col_productID;

    @FXML
    private TableColumn<ProductModelTable, String> col_productName;

    @FXML
    private TableColumn<ProductModelTable, String> col_netPrice;

    @FXML
    private TableColumn<ProductModelTable, String> col_taxID;

    @FXML
    private TableColumn<ProductModelTable, String> col_amount;

    @FXML
    private TableColumn<ProductModelTable, String> col_building;

    @FXML
    private TextField building_IDTextField1;

    @FXML
    private TextField buildingNameTextField;

    @FXML
    private TextField address_IDTextFieldBuilding;

    @FXML
    private TableView<BuildingsModelTable> buildingTableView;

    @FXML
    private TableColumn<BuildingsModelTable, String> col_buildingID;

    @FXML
    private TableColumn<BuildingsModelTable, String> col_buildingName;

    @FXML
    private TableColumn<BuildingsModelTable, String> col_buildingAddress;

    @FXML
    private Button addBuildingButton;

    @FXML
    private Button deleteBuildingButton;

    @FXML
    private Button updateBuildingButton;

    @FXML
    private TextField address_IDTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TableView<AddressesModelTable> addressTableView;

    @FXML
    private TableColumn<AddressesModelTable, String> col_addressID;

    @FXML
    private TableColumn<AddressesModelTable, String> col_address;

    @FXML
    private Button addAddressButton;

    @FXML
    private Button deleteAddressButton;

    @FXML
    private Button updateAddressButton;

    @FXML
    private RadioButton addBuildingRadioButton;

    @FXML
    private ToggleGroup budynki;

    @FXML
    private RadioButton updateBuildingRadioButton;

    @FXML
    private RadioButton addAddressRadioButton;

    @FXML
    private ToggleGroup adresy;

    @FXML
    private RadioButton updateAddressRadioButton;

    @FXML
    private RadioButton deleteAddressRadioButton;

    @FXML
    private RadioButton deleteBuildingRadioButton;
    @FXML
    private RadioButton updateTaxRadioButton;

    @FXML
    private ToggleGroup podatki;

    @FXML
    private RadioButton deleteTaxRadioButton;

    @FXML
    private RadioButton addTaxRadioButton;
    @FXML
    private Button addTaxButton;

    @FXML
    private Button deleteTaxButton;

    @FXML
    private Button updateTaxButton;

    @FXML
    private TextField taxIDTextField1;

    @FXML
    private TextField valueTaxTextField;

    @FXML
    private TextField descriptionTaxTextField;

    @FXML
    private TableView<TaxesModelTable> taxTableView;

    @FXML
    private TableColumn<TaxesModelTable, String> col_taxValue;

    @FXML
    private TableColumn<TaxesModelTable, String> col_taxDescription;

    @FXML
    private TextField discountClientTextField;

    @FXML
    private TableView<CustomersModelTable> customerTableView;

    @FXML
    private TableColumn<CustomersModelTable, String> col_customerID;

    @FXML
    private TableColumn<CustomersModelTable, String> col_firstName;

    @FXML
    private TableColumn<CustomersModelTable, String> col_lastName;

    @FXML
    private TableColumn<CustomersModelTable, String> col_company;

    @FXML
    private TableColumn<CustomersModelTable, String> col_phone;

    @FXML
    private TableColumn<CustomersModelTable, String> col_e_Mail;

    @FXML
    private TableColumn<CustomersModelTable, String> col_customerAddressID;

    @FXML
    private TableColumn<CustomersModelTable, String> col_discountID;
    @FXML
    private TableColumn<CustomersModelTable, String> col_customerPassword;

    @FXML
    private TextField customerIDTextField;

    @FXML
    private ToggleGroup klienci;

    @FXML
    private TextField clientIDTextField;

    @FXML
    private TextField customerNameTextField;

    @FXML
    private TextField customerLastNameTextField;

    @FXML
    private TextField customerCompanyTextField;

    @FXML
    private TextField customerPhoneTextField;

    @FXML
    private TextField customerEmailTextField;

    @FXML
    private TextField customerAddressTextField;

    @FXML
    private TextField customerDiscountTextField;

    @FXML
    private TextField customerPasswordTextField;

    @FXML
    private RadioButton addCustomerRadioButton;

    @FXML
    private RadioButton deleteCustomerRadioButton;

    @FXML
    private RadioButton updateCustomerRadioButton;
    @FXML
    private Button addCustomerButton;

    @FXML
    private Button deleteCustomerButton;

    @FXML
    private Button updateCustomerButton;
    @FXML
    private TextField employee_IDTextField;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextField dobTextField;

    @FXML
    private TextField hireDateTextField;

    @FXML
    private TextField employeeBuilding_IDTextField;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private Button deleteEmployeeButton;

    @FXML
    private Button updateEmployeeButton;

    @FXML
    private TableView<EmployeesModelTable> employeeTableView;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_employeeID;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_firstName1;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_lastName1;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_salary;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_dob;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_hireDate;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_buildingID1;

    @FXML
    private TableColumn<EmployeesModelTable, String> col_employeePassword;

    @FXML
    private TextField employeePasswordTextField;

    @FXML
    private RadioButton updateEmployeeRadioButton;

    @FXML
    private ToggleGroup pracownik;

    @FXML
    private RadioButton deleteEmployeeRadioButton;

    @FXML
    private RadioButton addEmployeeRadioButton;
    @FXML
    private TextField searchEmployeeTextField;
    @FXML
    private TextField searchCustomerTextField;
    @FXML
    private TextField  searchProductTextField;

    ObservableList<ProductModelTable> productlist = FXCollections.observableArrayList();
    ObservableList<BuildingsModelTable> buildingsList = FXCollections.observableArrayList();
    ObservableList<AddressesModelTable> addressesList = FXCollections.observableArrayList();
    ObservableList<TaxesModelTable> taxesList = FXCollections.observableArrayList();
    ObservableList<CustomersModelTable> customersList = FXCollections.observableArrayList();
    ObservableList<EmployeesModelTable> employeesList = FXCollections.observableArrayList();
    Manager manager = new Manager();

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void previousPane()throws IOException {
        Pane loginPane = FXMLLoader.load(getClass().getResource("login.fxml"));
        managerPane.getChildren().setAll(loginPane);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SimpleListAdder();
        col_productID.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        col_productName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        col_netPrice.setCellValueFactory(new PropertyValueFactory<>("net_price"));
        col_taxID.setCellValueFactory(new PropertyValueFactory<>("tax_id"));
        col_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        col_building.setCellValueFactory(new PropertyValueFactory<>("building"));
        col_buildingID.setCellValueFactory(new PropertyValueFactory<>("building_id"));
        col_buildingName.setCellValueFactory(new PropertyValueFactory<>("buildingName"));
        col_buildingAddress.setCellValueFactory(new PropertyValueFactory<>("buildingAddress"));
        col_addressID.setCellValueFactory(new PropertyValueFactory<>("address_id"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_taxID.setCellValueFactory(new PropertyValueFactory<>("taxID"));
        col_taxValue.setCellValueFactory(new PropertyValueFactory<>("taxValue"));
        col_taxDescription.setCellValueFactory(new PropertyValueFactory<>("taxDescription"));
        col_customerID.setCellValueFactory( new PropertyValueFactory<>("customer_id"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_company.setCellValueFactory(new PropertyValueFactory<>("company"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_e_Mail.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
        col_customerAddressID.setCellValueFactory(new PropertyValueFactory<>("address_id"));
        col_discountID.setCellValueFactory(new PropertyValueFactory<>("discount_id"));
        col_customerPassword.setCellValueFactory(new PropertyValueFactory<>("customer_password"));
        col_employeeID.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        col_firstName1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_lastName1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        col_hireDate.setCellValueFactory(new PropertyValueFactory<>("hireDate"));
        col_buildingID1.setCellValueFactory(new PropertyValueFactory<>("building_id"));
        col_employeePassword.setCellValueFactory(new PropertyValueFactory<>("employee_password"));
        employeeTableView.setItems(employeesList);
        customerTableView.setItems(customersList);
        productTableView.setItems(productlist);
        buildingTableView.setItems(buildingsList);
        addressTableView.setItems(addressesList);
        taxTableView.setItems(taxesList);

    }
    void SimpleListAdder (){
        productlist.clear();
        buildingsList.clear();
        addressesList.clear();
        taxesList.clear();
        customersList.clear();
        employeesList.clear();
        try {
            Connection con_1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","warehouse","password");
            ResultSet rs = con_1.createStatement().executeQuery("SELECT * FROM PRODUCTS");
            ResultSet rs_1 = con_1.createStatement().executeQuery("SELECT * FROM BUILDINGS");
            ResultSet rs_2 = con_1.createStatement().executeQuery("SELECT * FROM ADDRESSES");
            ResultSet rs_3 = con_1.createStatement().executeQuery("SELECT * FROM TAX");
            ResultSet rs_4 = con_1.createStatement().executeQuery("SELECT * FROM CUSTOMERS");
            ResultSet rs_5 = con_1.createStatement().executeQuery("SELECT EMPLOYEE_ID, FIRST_NAME,LAST_NAME,SALARY, TO_CHAR(DATE_OF_BIRTH, 'YYYY.MM.DD')AS DATE_OF_BIRTH,TO_CHAR(HIRE_DATE, 'YYYY.MM.DD') AS HIRE_DATE,BUILDING_ID,EMPLOYEE_PASSWORD FROM EMPLOYEES");
            while (rs.next()){
                productlist.add(new ProductModelTable(rs.getString("PRODUCT_ID")
                        ,rs.getString("PRODUCT_NAME"),rs.getString("PRICE_NET")
                        ,rs.getString("TAX_ID"),rs.getString("AVAILABILITY"),rs.getString("BUILDING_ID")));
            }
            while(rs_1.next()){
                buildingsList.add(new BuildingsModelTable(rs_1.getString("BUILDING_ID"),rs_1.getString("BUILDING_NAME"),rs_1.getString("ADDRESS_ID")));
            }
            while(rs_2.next()){
                addressesList.add(new AddressesModelTable(rs_2.getString("ADDRESS_ID"),rs_2.getString("ADDRESS")));
            }
            while(rs_3.next()){
                taxesList.add(new TaxesModelTable(rs_3.getString("TAX_ID"),rs_3.getString("TAX_VALUE"),rs_3.getString("TAX_DESCRIPTION")));
            }
            while(rs_4.next()){
                customersList.add(new CustomersModelTable(rs_4.getString("CUSTOMER_ID")
                        ,rs_4.getString("FIRST_NAME"),rs_4.getString("LAST_NAME")
                        ,rs_4.getString("COMPANY_NAME"),rs_4.getString("PHONE_NUMBER")
                        ,rs_4.getString("E_MAIL"),rs_4.getString("ADDRESS_ID"),rs_4.getString("DISCOUNT_ID"),rs_4.getString("CUSTOMER_PASSWORD")));
            }
            while (rs_5.next()){
                employeesList.add(new EmployeesModelTable(rs_5.getString("EMPLOYEE_ID")
                        ,rs_5.getString("FIRST_NAME"),rs_5.getString("LAST_NAME")
                        ,rs_5.getString("SALARY"),rs_5.getString("DATE_OF_BIRTH")
                        ,rs_5.getString("HIRE_DATE"),rs_5.getString("BUILDING_ID"),rs_5.getString("EMPLOYEE_PASSWORD")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //##########################PRODUCTS############################

    public void addNewProduct()
    {

        ArrayList<String> parameters=productsParametersToSend();
        manager.addNewProduct(parameters);
        productlist.clear();
        SimpleListAdder();
        productTableView.setItems(productlist);
    }
    public void deleteProduct(){

        manager.deleteProduct(productNameTextField.getText());
        productlist.clear();
        productTableView.getItems().clear();
        SimpleListAdder();
        productTableView.setItems(productlist);
    }
    public void updateProduct(){
        ArrayList<String> parameters =productsParametersToSend();
        manager.updateProduct(parameters);
        productlist.clear();
        productTableView.getItems().clear();
        SimpleListAdder();
        productTableView.setItems(productlist);

    }
    public ArrayList productsParametersToSend(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(product_IDTextField.getText());
        parameters.add(productNameTextField.getText());
        parameters.add(netPriceTextField.getText());
        parameters.add(tax_IDTextField.getText());
        parameters.add(amountTextField.getText());
        parameters.add(building_IDTextField.getText());
        return parameters;
    }
    public void productRadioButtonsActions()
    {
        if(addProductRadioButton.isSelected())
        {
            product_IDTextField.setEditable(true);
            productNameTextField.setEditable(true);
            netPriceTextField.setEditable(true);
            tax_IDTextField.setEditable(true);
            amountTextField.setEditable(true);
            building_IDTextField.setEditable(true);
            product_IDTextField.setText("");
            productNameTextField.setText("");
            netPriceTextField.setText("");
            tax_IDTextField.setText("");
            amountTextField.setText("");
            building_IDTextField.setText("");
            deleteProductButton.setDisable(true);
            updateProductButton.setDisable(true);
            addProductButton.setDisable(false);

        }
        if(updateProductRadioButton.isSelected())
        {
            product_IDTextField.setEditable(false);
            productNameTextField.setEditable(true);
            netPriceTextField.setEditable(true);
            tax_IDTextField.setEditable(true);
            amountTextField.setEditable(true);
            building_IDTextField.setEditable(true);
            product_IDTextField.setText("Blokada!");
            productNameTextField.setText("");
            netPriceTextField.setText("");
            tax_IDTextField.setText("");
            amountTextField.setText("");
            building_IDTextField.setText("");
            deleteProductButton.setDisable(true);
            updateProductButton.setDisable(false);
            addProductButton.setDisable(true);

        }
        if(deleteRadioProductButton.isSelected())
        {
            product_IDTextField.setEditable(false);
            netPriceTextField.setEditable(false);
            tax_IDTextField.setEditable(false);
            amountTextField.setEditable(false);
            building_IDTextField.setEditable(false);
            product_IDTextField.setText("Blokada!");
            netPriceTextField.setText("Blokada!");
            tax_IDTextField.setText("Blokada!");
            amountTextField.setText("Blokada!");
            building_IDTextField.setText("Blokada!");
            deleteProductButton.setDisable(false);
            updateProductButton.setDisable(true);
            addProductButton.setDisable(true);

        }
    }



    public void fillInTextFieldsProducts(){
        try {
            ProductModelTable productModelTable = productTableView.getSelectionModel().getSelectedItem();
            product_IDTextField.setText(productModelTable.getProduct_id());
            productNameTextField.setText(productModelTable.getProduct_name());
            netPriceTextField.setText(productModelTable.getNet_price());
            tax_IDTextField.setText(productModelTable.getTax_id());
            amountTextField.setText(productModelTable.getAmount());
            building_IDTextField.setText(productModelTable.getBuilding());
        }catch (Exception e){}
    }
    public void productSearchFilters(){

        FilteredList filter = new FilteredList(productlist, e->true);
        searchProductTextField.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filter.setPredicate((Predicate <? super ProductModelTable>) productModelTable->{
                if(newValue.isEmpty() || newValue ==null){

                    return true;
                }

                else return productModelTable.getProduct_id().contains(newValue)
                        || productModelTable.getProduct_name().toLowerCase().contains(newValue.toLowerCase());

            });
        } );
        productTableView.setItems(filter);

    }
    //##########################PRODUKTY############################
    //##########################BUDYNKI############################
    public void addBuilding(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters = buildingParametersToSend();
        manager.addBuilding(parameters);
        buildingsList.clear();
        SimpleListAdder();
        buildingTableView.setItems(buildingsList);
    }
    public void deleteBuilding(){
        manager.deleteBuilding(buildingNameTextField.getText());
        buildingsList.clear();
        SimpleListAdder();
        buildingTableView.setItems(buildingsList);
    }
    public void updateBuilding(){
        ArrayList<String> parameters = buildingParametersToSend();
        manager.updateBuilding(parameters);
        buildingsList.clear();
        SimpleListAdder();
        buildingTableView.setItems(buildingsList);
    }
    public void filinTextFieldsBuildings(){
        try {
            BuildingsModelTable buildingsModelTable = buildingTableView.getSelectionModel().getSelectedItem();
            building_IDTextField1.setText(buildingsModelTable.getBuilding_id());
            buildingNameTextField.setText(buildingsModelTable.getBuildingName());
            address_IDTextFieldBuilding.setText(buildingsModelTable.getBuildingAddress());

        }catch(Exception e){}

    }
    public ArrayList buildingParametersToSend(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(building_IDTextField1.getText());
        parameters.add(buildingNameTextField.getText());
        parameters.add(address_IDTextFieldBuilding.getText());
        return parameters;
    }
    public void buildingRadioButtonsActions()
    {
        if(addBuildingRadioButton.isSelected())
        {
            building_IDTextField1.setEditable(true);
            buildingNameTextField.setEditable(true);
            address_IDTextFieldBuilding.setEditable(true);
            building_IDTextField1.setText("");
            buildingNameTextField.setText("");
            address_IDTextFieldBuilding.setText("");
            deleteBuildingButton.setDisable(true);
            updateBuildingButton.setDisable(true);
            addBuildingButton.setDisable(false);
        }
        if(deleteBuildingRadioButton.isSelected())
        {
            building_IDTextField1.setEditable(false);
            buildingNameTextField.setEditable(true);
            address_IDTextFieldBuilding.setEditable(false);
            building_IDTextField1.setText("Blokada!");
            buildingNameTextField.setText("");
            address_IDTextFieldBuilding.setText("Blokada!");
            deleteBuildingButton.setDisable(false);
            updateBuildingButton.setDisable(true);
            addBuildingButton.setDisable(true);
        }
        if(updateBuildingRadioButton.isSelected())
        {
            building_IDTextField1.setEditable(false);
            buildingNameTextField.setEditable(true);
            address_IDTextFieldBuilding.setEditable(true);
            building_IDTextField1.setText("Blokada!");
            buildingNameTextField.setText("");
            address_IDTextFieldBuilding.setText("");
            deleteBuildingButton.setDisable(true);
            updateBuildingButton.setDisable(false);
            addBuildingButton.setDisable(true);
        }
    }
    //##########################BUDYNKI############################
    //##########################ADRESY############################
    public void addAddress(){
        ArrayList<String> parameters = addressParametersToSend();
        manager.addAddress(parameters);
        addressesList.clear();
        SimpleListAdder();
        addressTableView.setItems(addressesList);
    }
    public void deleteAddress(){

        manager.deleteAddress(addressTextField.getText());
        addressesList.clear();
        SimpleListAdder();
        addressTableView.setItems(addressesList);
    }
    public void updateAddress(){
        ArrayList<String> parameters = addressParametersToSend();
        manager.updateAddress(parameters);
        addressesList.clear();
        SimpleListAdder();
        addressTableView.setItems(addressesList);

    }
    public void filInTextFieldsAddresses(){
        try {
            AddressesModelTable addressesModelTable = addressTableView.getSelectionModel().getSelectedItem();
            address_IDTextField.setText(addressesModelTable.getAddress_id());
            addressTextField.setText(addressesModelTable.getAddress());
        }catch(Exception e){}

    }
    public ArrayList addressParametersToSend()
    {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(address_IDTextField.getText());
        parameters.add(addressTextField.getText());
        return parameters;
    }
    public void addressRadioButtonsActions()
    {
        if(addAddressRadioButton.isSelected())
        {
            address_IDTextField.setEditable(true);
            addressTextField.setEditable(true);
            address_IDTextField.setText("");
            addressTextField.setText("");
            deleteAddressButton.setDisable(true);
            updateAddressButton.setDisable(true);
            addAddressButton.setDisable(false);
        }
        if(deleteAddressRadioButton.isSelected())
        {
            address_IDTextField.setEditable(false);
            addressTextField.setEditable(true);
            address_IDTextField.setText("Blokada!");
            addressTextField.setText("");
            deleteAddressButton.setDisable(false);
            updateAddressButton.setDisable(true);
            addAddressButton.setDisable(true);
        }
        if(updateAddressRadioButton.isSelected())
        {
            address_IDTextField.setEditable(false);
            addressTextField.setEditable(true);
            address_IDTextField.setText("Blokada!");
            addressTextField.setText("");
            deleteAddressButton.setDisable(true);
            updateAddressButton.setDisable(false);
            addAddressButton.setDisable(true);
        }

    }
    //##########################ADRESY############################
    //##########################PODATKI############################
    public void taxRadioButtonsActions()
    {
        if(addTaxRadioButton.isSelected())
        {
            taxIDTextField1.setEditable(true);
            valueTaxTextField.setEditable(true);
            descriptionTaxTextField.setEditable(true);
            taxIDTextField1.setText("");
            valueTaxTextField.setText("");
            descriptionTaxTextField.setText("");
            addTaxButton.setDisable(false);
            updateTaxButton.setDisable(true);
            deleteTaxButton.setDisable(true);
        }
        if(deleteTaxRadioButton.isSelected())
        {
            taxIDTextField1.setEditable(false);
            valueTaxTextField.setEditable(true);
            descriptionTaxTextField.setEditable(false);
            taxIDTextField1.setText("Blokada!");
            valueTaxTextField.setText("");
            descriptionTaxTextField.setText("Blokada!");
            addTaxButton.setDisable(true);
            updateTaxButton.setDisable(true);
            deleteTaxButton.setDisable(false);
        }
        if(updateTaxRadioButton.isSelected())
        {
            taxIDTextField1.setEditable(false);
            valueTaxTextField.setEditable(true);
            descriptionTaxTextField.setEditable(true);
            taxIDTextField1.setText("Blokada!");
            valueTaxTextField.setText("");
            descriptionTaxTextField.setText("");
            addTaxButton.setDisable(true);
            updateTaxButton.setDisable(false);
            deleteTaxButton.setDisable(true);
        }

    }
    public void addTax(){
        ArrayList<String> parameters = taxParametersToSend();
        manager.addTax(parameters);
        taxesList.clear();
        SimpleListAdder();
        taxTableView.setItems(taxesList);
    }
    public void deleteTax(){

        manager.deleteTax(valueTaxTextField.getText());
        taxesList.clear();
        SimpleListAdder();
        taxTableView.setItems(taxesList);
    }
    public void updateTax(){
        ArrayList<String> parameters = taxParametersToSend();
        manager.updateTax(parameters);
        taxesList.clear();
        SimpleListAdder();
        taxTableView.setItems(taxesList);
    }
    public void filinTextFieldsTaxes(){
        TaxesModelTable taxesModelTable = taxTableView.getSelectionModel().getSelectedItem();
        taxIDTextField1.setText(taxesModelTable.getTaxID());
        valueTaxTextField.setText(taxesModelTable.getTaxValue());
        descriptionTaxTextField.setText(taxesModelTable.getTaxDescription());
    }
    public ArrayList taxParametersToSend()
    {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(taxIDTextField1.getText());
        parameters.add(valueTaxTextField.getText());
        parameters.add(descriptionTaxTextField.getText());
        return parameters;
    }
    //##########################PODATKI############################
    //##########################KLIENCI############################
    public void fillInTextFieldsCustomers(){
        try {
            CustomersModelTable customersModelTable = customerTableView.getSelectionModel().getSelectedItem();
            clientIDTextField.setText(customersModelTable.getCustomer_id());
            customerNameTextField.setText(customersModelTable.getFirstName());
            customerLastNameTextField.setText(customersModelTable.getLastName());
            customerCompanyTextField.setText(customersModelTable.getCompany());
            customerPhoneTextField.setText(customersModelTable.getPhone());
            customerEmailTextField.setText(customersModelTable.getE_mail());
            customerAddressTextField.setText(customersModelTable.getAddress_id());
            customerDiscountTextField.setText(customersModelTable.getDiscount_id());
            customerPasswordTextField.setText(customersModelTable.getCustomer_password());

        }catch(Exception e){}

    }

    public void addCustomer(){
        ArrayList<String> parameters;
        parameters = customerParametersToSend();
        manager.addCustomer(parameters);
        customersList.clear();
        SimpleListAdder();
        customerTableView.setItems(customersList);
    }
    public void deleteCustomer()
    {
        manager.deleteCustomer(customerNameTextField.getText(),customerLastNameTextField.getText());
        customersList.clear();
        SimpleListAdder();
        customerTableView.setItems(customersList);
    }
    public void updateCustomer()
    {
        ArrayList<String> parameters = customerParametersToSend();
        manager.updateCustomer(parameters);
        customersList.clear();
        SimpleListAdder();
        customerTableView.setItems(customersList);
    }
    public ArrayList customerParametersToSend(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(clientIDTextField.getText());
        parameters.add(customerNameTextField.getText());
        parameters.add(customerLastNameTextField.getText());
        parameters.add(customerCompanyTextField.getText());
        parameters.add(customerPhoneTextField.getText());
        parameters.add(customerEmailTextField.getText());
        parameters.add(customerAddressTextField.getText());
        parameters.add(customerDiscountTextField.getText());
        parameters.add(customerPasswordTextField.getText());
        return parameters;
    }
    public void customerRadioButtonsActions()
    {
        if(addCustomerRadioButton.isSelected())
        {
            clientIDTextField.setEditable(true);
            customerNameTextField.setEditable(true);
            customerLastNameTextField.setEditable(true);
            customerCompanyTextField.setEditable(true);
            customerPhoneTextField.setEditable(true);
            customerEmailTextField.setEditable(true);
            customerAddressTextField.setEditable(true);
            customerDiscountTextField.setEditable(true);
            customerPasswordTextField.setEditable(true);
            clientIDTextField.setText("");
            customerNameTextField.setText("");
            customerLastNameTextField.setText("");
            customerCompanyTextField.setText("");
            customerPhoneTextField.setText("");
            customerEmailTextField.setText("");
            customerAddressTextField.setText("");
            customerDiscountTextField.setText("");
            customerPasswordTextField.setText("");
            addCustomerButton.setDisable(false);
            updateCustomerButton.setDisable(true);
            deleteCustomerButton.setDisable(true);
        }
        if(deleteCustomerRadioButton.isSelected())
        {
            clientIDTextField.setEditable(false);
            customerNameTextField.setEditable(true);
            customerLastNameTextField.setEditable(true);
            customerCompanyTextField.setEditable(false);
            customerPhoneTextField.setEditable(false);
            customerEmailTextField.setEditable(false);
            customerAddressTextField.setEditable(false);
            customerDiscountTextField.setEditable(false);
            customerPasswordTextField.setEditable(false);
            clientIDTextField.setText("Blokada!");
            customerNameTextField.setText("");
            customerLastNameTextField.setText("");
            customerCompanyTextField.setText("Blokada!");
            customerPhoneTextField.setText("Blokada!");
            customerEmailTextField.setText("Blokada!");
            customerAddressTextField.setText("Blokada!");
            customerDiscountTextField.setText("Blokada!");
            customerPasswordTextField.setText("Blokada!");
            addCustomerButton.setDisable(true);
            updateCustomerButton.setDisable(true);
            deleteCustomerButton.setDisable(false);
        }
        if(updateCustomerRadioButton.isSelected())
        {
            clientIDTextField.setEditable(false);
            customerNameTextField.setEditable(true);
            customerLastNameTextField.setEditable(true);
            customerCompanyTextField.setEditable(true);
            customerPhoneTextField.setEditable(true);
            customerEmailTextField.setEditable(true);
            customerAddressTextField.setEditable(true);
            customerDiscountTextField.setEditable(true);
            customerPasswordTextField.setEditable(true);
            clientIDTextField.setText("Blokada!");
            customerNameTextField.setText("");
            customerLastNameTextField.setText("");
            customerCompanyTextField.setText("");
            customerPhoneTextField.setText("");
            customerEmailTextField.setText("");
            customerAddressTextField.setText("");
            customerDiscountTextField.setText("");
            customerPasswordTextField.setText("");
            addCustomerButton.setDisable(true);
            updateCustomerButton.setDisable(false);
            deleteCustomerButton.setDisable(true);
        }

    }
    public void customerSearchFilters() throws NullPointerException{
        FilteredList filter = new FilteredList(customersList, e->true);
        searchCustomerTextField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filter.setPredicate((Predicate<? super CustomersModelTable>) customersModelTable -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                } else return customersModelTable.getCustomer_id().contains(newValue)
                        || customersModelTable.getFirstName().toLowerCase().contains(newValue.toLowerCase())
                        || customersModelTable.getLastName().toLowerCase().contains(newValue.toLowerCase());

            });
        });

        customerTableView.setItems(filter);
    }

    //##########################KLIENCI############################
    //##########################PRACOWNICY############################
    public void employeesRadioButtonsActions()
    {
        if(addEmployeeRadioButton.isSelected())
        {
            employee_IDTextField.setEditable(true);
            firstNameTextField.setEditable(true);
            lastNameTextField.setEditable(true);
            salaryTextField.setEditable(true);
            dobTextField.setEditable(true);
            hireDateTextField.setEditable(true);
            employeeBuilding_IDTextField.setEditable(true);
            employeePasswordTextField.setEditable(true);
            employee_IDTextField.setText("");
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            salaryTextField.setText("");
            dobTextField.setText("");
            hireDateTextField.setText("");
            employeeBuilding_IDTextField.setText("");
            employeePasswordTextField.setText("");
            addEmployeeButton.setDisable(false);
            updateEmployeeButton.setDisable(true);
            deleteEmployeeButton.setDisable(true);
        }
        if(deleteEmployeeRadioButton.isSelected())
        {
            employee_IDTextField.setEditable(false);
            firstNameTextField.setEditable(true);
            lastNameTextField.setEditable(true);
            salaryTextField.setEditable(false);
            dobTextField.setEditable(false);
            hireDateTextField.setEditable(false);
            employeeBuilding_IDTextField.setEditable(false);
            employeePasswordTextField.setEditable(false);
            employee_IDTextField.setText("Blokada!");
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            salaryTextField.setText("Blokada!");
            dobTextField.setText("Blokada!");
            hireDateTextField.setText("Blokada!");
            employeeBuilding_IDTextField.setText("Blokada!");
            employeePasswordTextField.setText("Blokada!");
            addEmployeeButton.setDisable(true);
            updateEmployeeButton.setDisable(true);
            deleteEmployeeButton.setDisable(false);
        }
        if(updateEmployeeRadioButton.isSelected())
        {
            employee_IDTextField.setEditable(false);
            firstNameTextField.setEditable(true);
            lastNameTextField.setEditable(true);
            salaryTextField.setEditable(true);
            dobTextField.setEditable(true);
            hireDateTextField.setEditable(true);
            employeeBuilding_IDTextField.setEditable(true);
            employeePasswordTextField.setEditable(true);
            employee_IDTextField.setText("Blokada!");
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            salaryTextField.setText("");
            dobTextField.setText("");
            hireDateTextField.setText("");
            employeeBuilding_IDTextField.setText("");
            employeePasswordTextField.setText("");
            addEmployeeButton.setDisable(true);
            updateEmployeeButton.setDisable(false);
            deleteEmployeeButton.setDisable(true);
        }

    }
    public void fillInTextFieldsEmployees(){
        try {
            EmployeesModelTable employeesModelTable = employeeTableView.getSelectionModel().getSelectedItem();
            employee_IDTextField.setText(employeesModelTable.getEmployee_id());
            firstNameTextField.setText(employeesModelTable.getFirstName());
            lastNameTextField.setText(employeesModelTable.getLastName());
            salaryTextField.setText(employeesModelTable.getSalary());
            dobTextField.setText(employeesModelTable.getDob());
            hireDateTextField.setText(employeesModelTable.getHireDate());
            employeeBuilding_IDTextField.setText(employeesModelTable.getBuilding_id());
            employeePasswordTextField.setText(employeesModelTable.getEmployee_password());
        }catch(Exception e){}

    }
    public void addEmployee()
    {
        ArrayList<String> parameters =employeesParametersToSend();
        manager.addEmployee(parameters);
        employeesList.clear();
        SimpleListAdder();
        employeeTableView.setItems(employeesList);
    }
    public void deleteEmployee()
    {
        manager.deleteEmployee(firstNameTextField.getText(),lastNameTextField.getText());
        employeesList.clear();
        SimpleListAdder();
        employeeTableView.setItems(employeesList);
    }
    public void updateEmployee()
    {
        ArrayList<String> parameters = employeesParametersToSend();
        manager.updateEmployee(parameters);
        employeesList.clear();
        SimpleListAdder();
        employeeTableView.setItems(employeesList);
    }
    public ArrayList employeesParametersToSend(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(employee_IDTextField.getText());
        parameters.add(firstNameTextField.getText());
        parameters.add(lastNameTextField.getText());
        parameters.add(salaryTextField.getText());
        parameters.add(dobTextField.getText());
        parameters.add(hireDateTextField.getText());
        parameters.add(employeeBuilding_IDTextField.getText());
        parameters.add(employeePasswordTextField.getText());
        return parameters;
    }
    public void employeesSearchFilters(){
        FilteredList filter = new FilteredList(employeesList, e->true);
        searchEmployeeTextField.textProperty().addListener((observableValue, oldValue, newValue)-> {
            filter.setPredicate((Predicate<? super EmployeesModelTable>) employeesModelTable->{
                if (newValue.isEmpty()|| newValue==null){
                    return true;
                }
                else return employeesModelTable.getEmployee_id().contains(newValue)
                        || employeesModelTable.getFirstName().toLowerCase().contains(newValue.toLowerCase())
                        || employeesModelTable.getLastName().toLowerCase().contains(newValue.toLowerCase());
            });
        });
        employeeTableView.setItems(filter);
    }
    //##########################PRACOWNICY############################
}
