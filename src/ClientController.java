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
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class ClientController implements Initializable {

    Client c = new Client();

    @FXML
    private Pane clientPane;

    @FXML
    private Button closeButton;

    @FXML
    private TextField szukajProduktu;

    @FXML
    private TextField szukajFaktury;

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
    private TableView<FakturyModelView> fakturaTableView;

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




    ObservableList<ProductModelTable> productlist = FXCollections.observableArrayList();
    ObservableList<FakturyModelView> fakturalist = FXCollections.observableArrayList();


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void previousPane()throws IOException {
        Pane loginPane = FXMLLoader.load(getClass().getResource("login.fxml"));
        clientPane.getChildren().setAll(loginPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){


        SimpleListAdder();
        col_productID.setCellValueFactory(new PropertyValueFactory<>("product_id"));
        col_productName.setCellValueFactory(new PropertyValueFactory<>("product_name"));
        col_netPrice.setCellValueFactory(new PropertyValueFactory<>("net_price"));
        col_taxID.setCellValueFactory(new PropertyValueFactory<>("tax_id"));
        col_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        col_building.setCellValueFactory(new PropertyValueFactory<>("building"));

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

        productTableView.setItems(productlist);
        fakturaTableView.setItems(fakturalist);
    }

    void SimpleListAdder (){
        productlist.clear();
        try {
            Connection con_1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","warehouse","password");
            ResultSet rs = con_1.createStatement().executeQuery("SELECT * FROM PRODUCTS");
            ResultSet rs2 = con_1.createStatement().executeQuery("SELECT * FROM FAKTURA WHERE \"IMIE I NAZWISKO ZAMAWIAJACEGO\" LIKE '%" + c.getName() + "'");
            while (rs.next()){
                productlist.add(new ProductModelTable(rs.getString("PRODUCT_ID")
                        ,rs.getString("PRODUCT_NAME"),rs.getString("PRICE_NET")
                        ,rs.getString("TAX_ID"),rs.getString("AVAILABILITY"),rs.getString("BUILDING_ID")));
            }
            while (rs2.next()){
                fakturalist.add(new FakturyModelView(rs2.getString("NUMER ZAMOWIENIA")
                        ,rs2.getString("IMIE I NAZWISKO ZAMAWIAJACEGO"),rs2.getString("FIRMA")
                        ,rs2.getString("ADRES ZAMAWIAJACEGO"),rs2.getString("DATA ZAMOWIENIA")
                        ,rs2.getString("ZAMOWIENIE PRZYJAL/ELA"),rs2.getString("NAZWA PRODUKTU")
                        ,rs2.getString("ILOSC PRODUKTU"),rs2.getString("CENA ZA SZTUKE")
                        ,rs2.getString("CENA NETTO ZAMOWIENIA"),rs2.getString("CENA BRUTTO ZAMOWIENIA")
                        ,rs2.getString("PODATEK VAT"),rs2.getString("KOMENTARZE")));
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
}
