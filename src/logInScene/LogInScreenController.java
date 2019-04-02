package logInScene;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogInScreenController {

	@FXML												
	private TextField txtLogINMail;
	@FXML
	private ImageView imgLogInLogo;
	@FXML
	private Button btnLogInAnmelden;
	@FXML
	private Button btnLogInZurueck;
	@FXML
	private AnchorPane hintergrundLogIn;
	@FXML
	private PasswordField PasswordLogIn;
	


/**Wenn man in der EinloggSceene den Anmelden-Button drückt 
und zum Haupt-,SwipeScreen weitergeleitet wird **/
public void ProfilAnmelden(ActionEvent event) throws IOException {
	
	Parent ProfilAnmeldenParent = FXMLLoader.load(getClass().getResource(".fxml")); //!!!!Swipe fxml anfügen!!!!
	Scene ProfilAnmeldenScene = new Scene(ProfilAnmeldenParent);
	
	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(ProfilAnmeldenScene);
	window.show();
}


/**Wenn man in der EinloggSceene den Zurück-Button drückt 
und zum AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird **/
public void AnmeldenZurueck(ActionEvent event) throws IOException {
	
	Parent AnmeldenZurueckParent = FXMLLoader.load(getClass().getResource("Start_gui.fxml")); 
	Scene AnmeldenZurueckScene = new Scene(AnmeldenZurueckParent);
	
	
	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
	window.setScene(AnmeldenZurueckScene);
	window.show();
}

}


