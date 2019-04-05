package logInScene;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	@FXML
	private Label PwFalsch;
	
	@FXML
	public void onEnter(ActionEvent ae)throws IOException{
	   System.out.println("Enter gedrückt");

	   if (PasswordLogIn.getText().trim().isEmpty()){
		   PwFalsch.setText("Bitte Passwort eingeben");
			PwFalsch.setTextFill(Color.web("#FF0000"));
	   } else {
		   profilAnmelden(ae);
	   }
	   
	   	
	   
	   
	}

	// Man kann sich nur Anmelden, wenn man seine E-Mail und sein Password angegeben hat 
	@FXML
	public void initialize() {
		this.btnLogInAnmelden.disableProperty().bind(
			Bindings.or(this.txtLogINMail.textProperty().isEmpty(),
				         this.PasswordLogIn.textProperty().isEmpty()));
		
	}

	/**
	 * Wenn man in der EinloggSceene den Anmelden-Button drückt und zum
	 * Haupt-,SwipeScreen weitergeleitet wird
	 **/
	public void profilAnmelden(ActionEvent event) throws IOException {
		String pattern = "[\\w\\.äöü-]+@[\\w\\.äöü-]+\\.(de|com|net|org)";
		Pattern pt = Pattern.compile(pattern);
		Matcher m = pt.matcher(txtLogINMail.getText());
		if(m.find()) {
			
		
		Parent profilAnmeldenParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml")); // 
		Scene profilAnmeldenScene = new Scene(profilAnmeldenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(profilAnmeldenScene);
		window.show();
		}else {
			PwFalsch.setText("Bitte eine korrekte E-Mail eingeben");
			PwFalsch.setTextFill(Color.web("#FF0000"));
			
		}
	}

	/**
	 * Wenn man in der EinloggSceene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void anmeldenZurueck(ActionEvent event) throws IOException {

		Parent anmeldenZurueckParent = FXMLLoader.load(getClass().getResource("/start/Start_gui.fxml"));
		Scene anmeldenZurueckScene = new Scene(anmeldenZurueckParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(anmeldenZurueckScene);
		window.show();
	}

}
