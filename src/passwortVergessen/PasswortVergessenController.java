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
	@FXML
	private Button btnBestaetigen;
	@FXML
	private Label labelpw1;
	@FXML
	private Label labelpw2;
	@FXML
	private Label labelMail;
	@FXML
	private TextField txtMail;
	
	
	//Mache ich ganz am Schluss. //Kevin Alles Klar CHEF
	@FXML
	public void onEnter(ActionEvent ae) throws IOException {
		System.out.println("Enter gedrückt");
	}
		
	//Hier wird die eMail bestätigt
		public void eMailBestaetigen(ActionEvent event) throws IOException {
			String pattern = "[\\w\\.äöü-]+@[\\w\\.äöü-]+\\.(de|com|net|org)";
			Pattern pt = Pattern.compile(pattern);
			Matcher m = pt.matcher(txtMail.getText());
			if (m.find()) {
				
				labelpw1.setVisible(true);
				labelpw2.setVisible(true);
				pw1.setVisible(true);
				pw2.setVisible(true);
				pw3.setVisible(true);
				btnNeuesPwSpeichern.setVisible(true);
				btnBestaetigen.setVisible(false);
							
				btnNeuesPwSpeichern.setText("Speichern");
				labelMail.setText("Altes Password eingeben:");
				
			} else {
				PwFalsch.setText("Bitte eine korrekte E-Mail eingeben");
				PwFalsch.setTextFill(Color.web("#FF0000"));

			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// Man kann sich nur Anmelden, wenn man seine E-Mail und sein Password angegeben
	// hat
//	@FXML
//	public void initialize() {
//		this.btnNeuesPwSpeichern.disableProperty().bind(
//				Bindings.or(this.pw2.textProperty().isEmpty(), this.pw3.textProperty().isEmpty()));
//
//	}
//	
	
	/**
	 * Wenn man in der EinloggSceene den Anmelden-Button drückt und zum
	 * Haupt-,SwipeScreen weitergeleitet wird
	 **/
	public void pwSpeichernBtn(ActionEvent event) throws IOException {
		
		

	}
	

	/**
	 * Wenn man in der PasswordVergessenSceene den Zurück-Button drückt und zum
	 * LogInScene weitergeleitet wird
	 **/
	public void zurueckZuLogin(ActionEvent event) throws IOException {

		Parent zurueckZuLoginParent = FXMLLoader.load(getClass().getResource("/logInScene/LogInScreen.fxml"));
		Scene zurueckZuLoginScene = new Scene(zurueckZuLoginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(zurueckZuLoginScene);
		window.show();
	

}
}
