package profil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// ProfilBearbeiten.fmxl 
public class ProfilController extends Application implements Initializable {

	// Profil.fxml
	@FXML
	private AnchorPane hintergrund;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtMail;

	@FXML
	private TextField txtStudiengang;

	@FXML
	private DatePicker txtAlter;

	@FXML
	private TextArea txtBeschreibung;

	@FXML
	private Button btnSpeichern;

	@FXML
	private RadioButton ButtonPartnersuche;

	@FXML
	private ToggleGroup partnerJa;

	@FXML
	private Button btnChangeImageB;

	@FXML
	private Button btnZurueck;

	@FXML
	private Circle kreis;

	@FXML
	private Label buttonpwfalschh;

	// Kreis erzeugen und Bild darin speichern
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		kreis.setStroke(Color.SEAGREEN);
		Image im = new Image("/application/profile_icon.png", false);
		kreis.setFill(new ImagePattern(im));
		kreis.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

	}

	/**
	 * Wenn man in der ProfilScene den Bearbeiten Button drückt und zur
	 * ProfilBearbeitenScene weitergeleitet wird
	 **/
	public void profilBearbeiten(ActionEvent event) throws IOException {

		Parent profilParent = FXMLLoader.load(getClass().getResource("/profilBearbeiten/ProfilBearbeiten.fxml"));
		Scene profilScene = new Scene(profilParent);

		// This line gets to Stage Information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(profilScene);
		window.show();
	}

	/**
	 * Wenn man in der ProfilSceene den Zurück-Button drückt und zum SwipeScreen
	 * weitergeleitet wird
	 **/
	public void profilZurueck(ActionEvent event) throws IOException {

		Parent profilZurueckParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene profilZurueckScene = new Scene(profilZurueckParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(profilZurueckScene);
		window.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}

}
