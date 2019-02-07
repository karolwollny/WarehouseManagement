import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManagement {


public void theQuery(String query) {
    Connection con;
    Statement st;
    try {
        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "warehouse", "password");
        st = con.createStatement();
        st.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Wykonano");
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Akcja nie została wykonana");
    }

}
}
