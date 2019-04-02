package profilErstellen;

import java.io.IOException;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProfilErstellenController {

	@FXML
	private TextField txtErstellenName;
	@FXML
	private TextField txtErstellenMail;
	@FXML
	private TextField txtErstellenStudiengang;
	@FXML
	private TextArea txtErstellenBeschreibung;
	@FXML
	private DatePicker txtErstellenAlter;
	@FXML
	private ImageView PictureErstellen;
	@FXML
	private RadioButton ButtonErstellenPartnersuche;
	@FXML
	private Button btnErstellenSpeichern;
	@FXML
	private Button btnErstellenZurueck;
	@FXML
	private AnchorPane hintergrundErstellen;
	@FXML
	private ToggleGroup partnerErstellen;
	@FXML
	private PasswordField PasswordErstellen;

	// Profil kann nur erstellt werden, wenn alle Pflichtfelder aufgefüllt wurden
	@FXML
	public void initialize() {
		this.btnErstellenSpeichern.disableProperty().bind(Bindings.or(this.txtErstellenName.textProperty().isEmpty(),
				this.txtErstellenMail.textProperty().isEmpty()));
		this.btnErstellenSpeichern.disableProperty().bind(Bindings.or(this.PasswordErstellen.textProperty().isEmpty(),
				this.txtErstellenBeschreibung.textProperty().isEmpty()));

	}

	/// **Wenn man in der ProfilErstellenScreen den Erstellen-Button drückt
	// und zum SwipeScreen weitergeleitet wird **/
	public void ProfilErstellenSpeichern(ActionEvent event) throws IOException {

		Parent ProfilErstellenParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene ProfilErstellenScene = new Scene(ProfilErstellenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ProfilErstellenScene);
		window.show();
	}

	/**
	 * Wenn man in der ProfilErstellenScene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void ProfilErstellenZurueck(ActionEvent event) throws IOException {

		Parent ProfilErstellenParent = FXMLLoader.load(getClass().getResource("/start/Start_gui.fxml"));
		Scene ProfilErstellenScene = new Scene(ProfilErstellenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ProfilErstellenScene);
		window.show();
	}

}
