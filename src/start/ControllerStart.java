package start;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerStart {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;



    /**      **/
    public void Login(ActionEvent event) throws IOException {

    	Parent LoginParent = FXMLLoader.load(getClass().getResource("/logInScene/LogInScreen.fxml"));
    	Scene LoginScene = new Scene(LoginParent);


    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    	window.setScene(LoginScene);
    	window.show();
    }

    /**      **/
    public void Register(ActionEvent event) throws IOException {

    	Parent LoginParent = FXMLLoader.load(getClass().getResource("/profilErstellen/ProfilErstellen.fxml"));
    	Scene LoginScene = new Scene(LoginParent);


    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    	window.setScene(LoginScene);
    	window.show();
    }

}
