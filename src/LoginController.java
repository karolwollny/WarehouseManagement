import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private Pane loginPane;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField hasloPasswordField;

    @FXML
    private Button closeButton;

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void check() throws IOException, SQLException {
        if(loginTextField.getText().equals("admin") && hasloPasswordField.getText().equals("admin")) initializeManagerPane();
        Connection con_1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","warehouse","password");
        ResultSet rs = con_1.createStatement().executeQuery("SELECT LAST_NAME,EMPLOYEE_PASSWORD FROM EMPLOYEES");
        ResultSet rs2 = con_1.createStatement().executeQuery("SELECT LAST_NAME,CUSTOMER_PASSWORD FROM CUSTOMERS");
        while(rs.next())
        {
           if(rs.getString("LAST_NAME").equals(loginTextField.getText()) && rs.getString("EMPLOYEE_PASSWORD").equals(hasloPasswordField.getText()))
           {
               Worker w = new Worker();
               w.setName(loginTextField.getText());

               initializeWorkerPane();
               break;
           }
        }
        while(rs2.next())
        {
                if(rs2.getString("LAST_NAME").equals(loginTextField.getText()) && rs2.getString("CUSTOMER_PASSWORD").equals(hasloPasswordField.getText()))
            {
                Client c = new Client();
                c.setName(loginTextField.getText());

                initializeClientPane();
                break;
            }
        }
    }

    public void initializeManagerPane() throws IOException {
        Pane managerPane = FXMLLoader.load(getClass().getResource("managerPane.fxml"));
        loginPane.getChildren().setAll(managerPane);
    }
    public void initializeWorkerPane() throws IOException {
        Pane workerPane = FXMLLoader.load(getClass().getResource("workerPane.fxml"));
        loginPane.getChildren().setAll(workerPane);
    }
    public void initializeClientPane() throws IOException {
        Pane clientPane = FXMLLoader.load(getClass().getResource("clientPane.fxml"));
        loginPane.getChildren().setAll(clientPane);
    }

}
