package profilBearbeiten;

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

// ProfilBearbeiten.fmxl 
public class ProfilBearbeitenController {
	
	@FXML												
	private TextField txtName;
	@FXML
	private TextField txtMail;
	@FXML
	private TextField txtStudiengang;
	@FXML
	private TextArea txtBeschreibung;
	@FXML
	private DatePicker txtAlter;
	@FXML
	private ImageView Picture;
	@FXML
	private RadioButton ButtonPartnersuche;
	@FXML
	private Button btnSpeichern;
	@FXML
	private AnchorPane hintergrund;
	@FXML
	private ToggleGroup partner;
	@FXML
	private PasswordField Password;
	
		
	// Profil kann nur gepeichert werden, wenn alle Pflichtfelder aufgefüllt wurden
		@FXML
		public void initialize() {
			this.btnSpeichern.disableProperty().bind(Bindings.or(this.txtName.textProperty().isEmpty(),
					this.txtMail.textProperty().isEmpty()));
			this.btnSpeichern.disableProperty().bind(Bindings.or(this.Password.textProperty().isEmpty(),
					this.txtBeschreibung.textProperty().isEmpty()));

		}	
	
	
	/**Wenn man in der ProfilbearbeitenScene den Speicher Button drückt 
	und zur normalen ProfilScene weitergeleitet wird **/
	public void ProfilBearbeitungSpeichern(ActionEvent event) throws IOException {
		
		Parent ProfilBearbeitenParent = FXMLLoader.load(getClass().getResource("/profil/Profil.fxml"));
		Scene ProfilBearbeitenScene = new Scene(ProfilBearbeitenParent);
		
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(ProfilBearbeitenScene);
		window.show();
	}



}
	