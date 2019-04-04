package start;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControllerStart {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;



    /**
	 * Wenn man in der Start-scene den Login-Button dr�ckt wird man zum 
	 * Login Screen weitergeleitet
	 **/
    public void Login(ActionEvent event) throws IOException {

    	Parent LoginParent = FXMLLoader.load(getClass().getResource("/logInScene/LogInScreen.fxml"));
    	Scene LoginScene = new Scene(LoginParent);


    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    	window.setScene(LoginScene);
    	window.show();
    }

    /**
	 * Wenn man in der Start-scene den Registrieren-Button dr�ckt wird man zum 
	 * Registrieren Screen weitergeleitet
	 **/
    public void Register(ActionEvent event) throws IOException {

    	Parent RegisterParent = FXMLLoader.load(getClass().getResource("/profilErstellen/ProfilErstellen.fxml"));
    	Scene RegisterScene = new Scene(RegisterParent);


    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    	window.setScene(RegisterScene);
    	window.show();
    }

}
