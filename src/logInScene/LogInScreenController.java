package logInScene;

import java.io.IOException;

import org.omg.CORBA.INITIALIZE;

import javafx.beans.binding.Bindings;
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

	@FXML
	public void initialize() {
		this.btnLogInAnmelden.disableProperty().bind(
			Bindings.or(this.txtLogINMail.textProperty().isEmpty(),
				         this.PasswordLogIn.textProperty().isEmpty()));
	}

	/**
	 * Wenn man in der EinloggSceene den Anmelden-Button dr�ckt und zum
	 * Haupt-,SwipeScreen weitergeleitet wird
	 **/
	public void ProfilAnmelden(ActionEvent event) throws IOException {

		Parent ProfilAnmeldenParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml")); // 
		Scene ProfilAnmeldenScene = new Scene(ProfilAnmeldenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ProfilAnmeldenScene);
		window.show();
	}

	/**
	 * Wenn man in der EinloggSceene den Zur�ck-Button dr�ckt und zum
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
