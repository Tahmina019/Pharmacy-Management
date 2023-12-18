/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pharmacy.management;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Windows 10
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane main_form;

@FXML
    private Button close;
    private PreparedStatement prepare;
    private Connection connect;
    private ResultSet result;
    
    private double x= 0;
    private double y= 0;
    public void loginAdmin(){
        
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";
        
        connect = database.connectDb();
        
        try{
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();
            
            Alert alert;
            
            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }
            else{
                if(result.next()){
                    
      
                    
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();
                    
                    // HIDE YOUR LOGIN FORM
                    loginBtn.getScene().getWindow().hide();
                    // LINK YOUR DASHBOARD FORM
                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                
                    
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){e.printStackTrace();}
        
    }

    public void close(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
