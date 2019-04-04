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
	public void ProfilAnmelden(ActionEvent event) throws IOException {
		String pattern = "[\\w\\.äöü-]+@[\\w\\.äöü-]+\\.(de|com|net|org)";
		Pattern pt = Pattern.compile(pattern);
		Matcher m = pt.matcher(txtLogINMail.getText());
		if(m.find()) {
			
		
		Parent ProfilAnmeldenParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml")); // 
		Scene ProfilAnmeldenScene = new Scene(ProfilAnmeldenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ProfilAnmeldenScene);
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
	public void AnmeldenZurueck(ActionEvent event) throws IOException {

		Parent AnmeldenZurueckParent = FXMLLoader.load(getClass().getResource("/start/Start_gui.fxml"));
		Scene AnmeldenZurueckScene = new Scene(AnmeldenZurueckParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(AnmeldenZurueckScene);
		window.show();
	}

}
