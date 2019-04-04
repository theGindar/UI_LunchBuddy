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
	 * Wenn man in der Start-scene den Login-Button drückt wird man zum 
	 * Login Screen weitergeleitet
	 **/
    public void login(ActionEvent event) throws IOException {

    	Parent loginParent = FXMLLoader.load(getClass().getResource("/logInScene/LogInScreen.fxml"));
    	Scene loginScene = new Scene(loginParent);


    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    	window.setScene(loginScene);
    	window.show();
    }

    /**
	 * Wenn man in der Start-scene den Registrieren-Button drückt wird man zum 
	 * Registrieren Screen weitergeleitet
	 **/
    public void register(ActionEvent event) throws IOException {

    	Parent registerParent = FXMLLoader.load(getClass().getResource("/profilErstellen/ProfilErstellen.fxml"));
    	Scene registerScene = new Scene(registerParent);


    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    	window.setScene(registerScene);
    	window.show();
    }

}
