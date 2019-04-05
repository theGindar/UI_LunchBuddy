package passwortVergessen;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chatlist.ControllerChatlist;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Model;

public class PasswortVergessenController {

	@FXML
	private AnchorPane hintergrundLogIn;

	@FXML
	private Button btnZurueckZuLogin;

	@FXML
	private Label PwFalsch;

	@FXML
	private PasswordField pw1;

	@FXML
	private PasswordField pw2;

	@FXML
	private PasswordField pw3;

	@FXML
	private Button btnNeuesPwSpeichern;
	
	
	//Mache ich ganz am Schluss. //Kevin
	@FXML
	public void onEnter(ActionEvent ae) throws IOException {
		System.out.println("Enter gedrückt");

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// Man kann sich nur Anmelden, wenn man seine E-Mail und sein Password angegeben
	// hat
	@FXML
	public void initialize() {
		this.btnNeuesPwSpeichern.disableProperty().bind(
				Bindings.or(this.pw2.textProperty().isEmpty(), this.pw3.textProperty().isEmpty()));

	}
	
	
	/**
	 * Wenn man in der EinloggSceene den Anmelden-Button drückt und zum
	 * Haupt-,SwipeScreen weitergeleitet wird
	 **/
	public void pwSpeichernBtn(ActionEvent event) throws IOException {


	}
	

	/**
	 * Wenn man in der EinloggSceene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void zurueckZuLogin(ActionEvent event) throws IOException {

		Model model = new Model();
		
		FXMLLoader chatlistLoader = new FXMLLoader(getClass().getResource("/einstellungen/Einstellungen.fxml"));
		chatlistLoader.setController(new ControllerChatlist(model));
		Parent chatlistUI = chatlistLoader.load();
		
		
		Scene zumChatScene = new Scene(chatlistUI);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(zumChatScene);
		window.show();
	}

}
