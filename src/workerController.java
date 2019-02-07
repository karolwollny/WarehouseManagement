import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class workerController implements Initializable {
    Worker w = new Worker();

    @FXML
    private Pane workerPane;
    @FXML
    private Button closeButton;

    @FXML
    private Button addOrderButton;

    @FXML
    private Button updateOrderButton;

    @FXML
    private TextField szukajProduktu;

    @FXML
    private TextField szukajZamowienia;

    @FXML
    private TextField szukajFaktury;

    @FXML
    private TextField order_id_add;

    @FXML
    private TextField customer_id_add;

    @FXML
    private TextField employee_id_add;

    @FXML
    private TextField status_add;

    @FXML
    private TextField order_date_add;

    @FXML
    private TextField comments_add;

    @FXML
    private TextField product_id_add;

    @FXML
    private TextField ammount_add;

    @FXML
    private TextField order_id_update;

    @FXML
    private TextField customer_id_update;

    @FXML
    private TextField employee_id_update;

    @FXML
    private TextField status_update;

    @FXML
    private TextField order_date_update;

    @FXML
    private TextField comments_update;

    @FXML
    private TextField product_id_update;

    @FXML
    private TextField ammount_update;

    @FXML
    private TableView<ProductModelTable> productTableView;

    @FXML
    private TableView<OrderModelTable> orderTableView;

    @FXML
    private TableView<FakturyModelView> fakturaTableView;

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
    private TableColumn<OrderModelTable, String> col_order_id;

    @FXML
    private TableColumn<OrderModelTable, String> col_customer_id;

    @FXML
    private TableColumn<OrderModelTable, String> col_employee_id;

    @FXML
    private TableColumn<OrderModelTable, String> col_status;

    @FXML
    private TableColumn<OrderModelTable, String> col_order_date;

    @FXML
    private TableColumn<OrderModelTable, String> col_comments;

    @FXML
    private TableColumn<FakturyModelView, String> col_numer;

    @FXML
    private TableColumn<FakturyModelView, String> col_imie;

    @FXML
    private TableColumn<FakturyModelView, String> col_firma;

    @FXML
    private TableColumn<FakturyModelView, String> col_adres_zam;

    @FXML
    private TableColumn<FakturyModelView, String> co_data;

    @FXML
    private TableColumn<FakturyModelView, String> col_zam_przyj;

    @FXML
    private TableColumn<FakturyModelView, String> col_nazwa;

    @FXML
    private TableColumn<FakturyModelView, String> col_ilosc;

    @FXML
    private TableColumn<FakturyModelView, String> col_cena_za_sztuke;

    @FXML
    private TableColumn<FakturyModelView, String> col_cena_netto;

    @FXML
    private TableColumn<FakturyModelView, String> col_cena_brutto;

    @FXML
    private TableColumn<FakturyModelView, String> col_vat;

    @FXML
    private TableColumn<FakturyModelView, String> col_komentarze;


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

    ObservableList<ProductModelTable> productlist = FXCollections.observableArrayList();
    ObservableList<OrderModelTable> orderlist = FXCollections.observableArrayList();
    ObservableList<FakturyModelView> fakturalist = FXCollections.observableArrayList();
    ObservableList<CustomersModelTable> customersList = FXCollections.observableArrayList();


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void previousPane()throws IOException {
        Pane loginPane = FXMLLoader.load(getClass().getResource("login.fxml"));
        workerPane.getChildren().setAll(loginPane);
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

        col_order_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        col_customer_id.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        col_employee_id.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        col_order_date.setCellValueFactory(new PropertyValueFactory<>("order_date"));
        col_comments.setCellValueFactory(new PropertyValueFactory<>("comments"));

        col_numer.setCellValueFactory(new PropertyValueFactory<>("numer"));
        col_imie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        col_firma.setCellValueFactory(new PropertyValueFactory<>("firma"));
        col_adres_zam.setCellValueFactory(new PropertyValueFactory<>("adres"));
        co_data.setCellValueFactory(new PropertyValueFactory<>("data"));
        col_zam_przyj.setCellValueFactory(new PropertyValueFactory<>("przyjecie"));
        col_nazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        col_ilosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        col_cena_za_sztuke.setCellValueFactory(new PropertyValueFactory<>("cena_za_sztuke"));
        col_cena_netto.setCellValueFactory(new PropertyValueFactory<>("cena_netto"));
        col_cena_brutto.setCellValueFactory(new PropertyValueFactory<>("cena_brutto"));
        col_vat.setCellValueFactory(new PropertyValueFactory<>("vat"));
        col_komentarze.setCellValueFactory(new PropertyValueFactory<>("komentarze"));

        col_customerID.setCellValueFactory( new PropertyValueFactory<>("customer_id"));
        col_firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_company.setCellValueFactory(new PropertyValueFactory<>("company"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_e_Mail.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
        col_customerAddressID.setCellValueFactory(new PropertyValueFactory<>("address_id"));
        col_discountID.setCellValueFactory(new PropertyValueFactory<>("discount_id"));

        productTableView.setItems(productlist);
        orderTableView.setItems(orderlist);
        fakturaTableView.setItems(fakturalist);
        customerTableView.setItems(customersList);
    }

    void SimpleListAdder (){
        productlist.clear();
        orderlist.clear();
        fakturalist.clear();
        customersList.clear();

        try {
            Connection con_1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","warehouse","password");
            ResultSet rs = con_1.createStatement().executeQuery("SELECT * FROM PRODUCTS");
            ResultSet rs2 = con_1.createStatement().executeQuery("SELECT * FROM ORDERS");
            ResultSet rs3 = con_1.createStatement().executeQuery("SELECT * FROM FAKTURA");
            ResultSet rs_4 = con_1.createStatement().executeQuery("SELECT * FROM CUSTOMERS");

            while (rs.next()){
                productlist.add(new ProductModelTable(rs.getString("PRODUCT_ID")
                        ,rs.getString("PRODUCT_NAME"),rs.getString("PRICE_NET")
                        ,rs.getString("TAX_ID"),rs.getString("AVAILABILITY"),rs.getString("BUILDING_ID")));
            }
            while (rs2.next()){
                orderlist.add(new OrderModelTable(rs2.getString("ORDER_ID")
                        ,rs2.getString("CUSTOMER_ID"),rs2.getString("EMPLOYEE_ID")
                        ,rs2.getString("STATUS"),rs2.getString("ORDER_DATE"),rs2.getString("COMMENTS")));
            }
            while (rs3.next()){
                fakturalist.add(new FakturyModelView(rs3.getString("NUMER ZAMOWIENIA")
                        ,rs3.getString("IMIE I NAZWISKO ZAMAWIAJACEGO"),rs3.getString("FIRMA")
                        ,rs3.getString("ADRES ZAMAWIAJACEGO"),rs3.getString("DATA ZAMOWIENIA")
                        ,rs3.getString("ZAMOWIENIE PRZYJAL/ELA"),rs3.getString("NAZWA PRODUKTU")
                        ,rs3.getString("ILOSC PRODUKTU"),rs3.getString("CENA ZA SZTUKE")
                        ,rs3.getString("CENA NETTO ZAMOWIENIA"),rs3.getString("CENA BRUTTO ZAMOWIENIA")
                        ,rs3.getString("PODATEK VAT"),rs3.getString("KOMENTARZE")));
            }
            while(rs_4.next()){
                customersList.add(new CustomersModelTable(rs_4.getString("CUSTOMER_ID")
                        ,rs_4.getString("FIRST_NAME"),rs_4.getString("LAST_NAME")
                        ,rs_4.getString("COMPANY_NAME"),rs_4.getString("PHONE_NUMBER")
                        ,rs_4.getString("E_MAIL"),rs_4.getString("ADDRESS_ID"),rs_4.getString("DISCOUNT_ID")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void productSearchFilters(){

        FilteredList filter = new FilteredList(productlist, e->true);
        szukajProduktu.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filter.setPredicate((Predicate<? super ProductModelTable>) productModelTable->{
                if(newValue.isEmpty() || newValue ==null){

                    return true;
                }

                else return productModelTable.getProduct_id().contains(newValue)
                        || productModelTable.getProduct_name().toLowerCase().contains(newValue.toLowerCase());

            });
        } );
        productTableView.setItems(filter);

    }

    public void orderSearchFilters(){

        FilteredList filter = new FilteredList(orderlist, e->true);
        szukajZamowienia.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filter.setPredicate((Predicate<? super OrderModelTable>) orderModelTable->{
                if(newValue.isEmpty() || newValue ==null){

                    return true;
                }

                else return orderModelTable.getOrder_id().contains(newValue)
                        || orderModelTable.getCustomer_id().contains(newValue);
            });
        } );
        orderTableView.setItems(filter);

    }

    public void fakturaSearchFilters(){

        FilteredList filter = new FilteredList(fakturalist, e->true);
        szukajFaktury.textProperty().addListener((observableValue, oldValue, newValue) ->{
            filter.setPredicate((Predicate<? super FakturyModelView>) fakturyModelView->{
                if(newValue.isEmpty() || newValue ==null){

                    return true;
                }

                else return fakturyModelView.getNumer().contains(newValue)
                        || fakturyModelView.getNazwa().toLowerCase().contains(newValue.toLowerCase());

            });
        } );
        fakturaTableView.setItems(filter);

    }


    public void addNewOrder()
    {

        ArrayList<String> parameters=orderParametersToSendAdd();
        w.addNewOrder(parameters);
        orderlist.clear();
        SimpleListAdder();
        orderTableView.setItems(orderlist);
    }

    public void updateOrder(){
        ArrayList<String> parameters =orderParametersToSendUpdate();
        w.updateOrder(parameters);
        orderlist.clear();
        orderTableView.getItems().clear();
        SimpleListAdder();
        orderTableView.setItems(orderlist);

    }

    public ArrayList orderParametersToSendUpdate(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(order_id_update.getText());
        parameters.add(customer_id_update.getText());
        parameters.add(employee_id_update.getText());
        parameters.add(status_update.getText());
        parameters.add(order_date_update.getText());
        parameters.add(comments_update.getText());
        parameters.add(product_id_update.getText());
        parameters.add(ammount_update.getText());
        return parameters;
    }

    public ArrayList orderParametersToSendAdd(){
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(order_id_add.getText());
        parameters.add(customer_id_add.getText());
        parameters.add(employee_id_add.getText());
        parameters.add(status_add.getText());
        parameters.add(order_date_add.getText());
        parameters.add(comments_add.getText());
        parameters.add(product_id_add.getText());
        parameters.add(ammount_add.getText());
        return parameters;
    }
}
