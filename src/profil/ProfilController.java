package profil;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

// ProfilBearbeiten.fmxl 
public class ProfilController {
	
	//Profil.fxml
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
	private ImageView Profilpicture;
	@FXML
	private RadioButton ButtonProfilPartnersuche;
	@FXML
	private Button btnBearbeiten;
	@FXML
	private Button btnZurueck;
	@FXML
	private PasswordField ProfilPassword;
	
	
	
	/**Wenn man in der ProfilScene den Bearbeiten Button drückt 
	und zur ProfilBearbeitenScene weitergeleitet wird **/
	public void ProfilBearbeiten(ActionEvent event) throws IOException {
		
		Parent ProfilParent = FXMLLoader.load(getClass().getResource("/profilBearbeiten/ProfilBearbeiten.fxml"));
		Scene ProfilScene = new Scene(ProfilParent);
		
		//This line gets to Stage Information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(ProfilScene);
		window.show();
	}	
	
	/**
	 * Wenn man in der ProfilSceene den Zurück-Button drückt und zum
	 * SwipeScreen weitergeleitet wird
	 **/
	public void ProfilZurueck(ActionEvent event) throws IOException {

		Parent ProfilZurueckParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene ProfilZurueckScene = new Scene(ProfilZurueckParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ProfilZurueckScene);
		window.show();
	}
	

	
	}

