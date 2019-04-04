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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

// ProfilBearbeiten.fmxl 
public class ProfilController extends Application implements Initializable {

	// Profil.fxml
	@FXML
	private TextField txtProfilName;
	@FXML
	private TextField txtProfilMail;
	@FXML
	private TextField txtProfilStudiengang;
	@FXML
	private TextArea txtProfilBeschreibung;
	@FXML
	private TextField txtProfilAlter;
	@FXML
	private RadioButton ButtonProfilPartnersuche;
	@FXML
	private Button btnBearbeiten;
	@FXML
	private Button btnZurueck;
	@FXML
	private PasswordField ProfilPassword;
	@FXML
	private Circle kreis;

	// Kreis erzeugen und Bild darin speichern
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		kreis.setStroke(Color.SEAGREEN);
		Image im = new Image("/application/profile_icon.png", false);
		kreis.setFill(new ImagePattern(im));
		kreis.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

	}

	/**
	 * Wenn man in der ProfilScene den Bearbeiten Button dr�ckt und zur
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
	 * Wenn man in der ProfilSceene den Zur�ck-Button dr�ckt und zum SwipeScreen
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
