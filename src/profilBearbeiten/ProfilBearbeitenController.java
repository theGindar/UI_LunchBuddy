package profilBearbeiten;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.beans.binding.Bindings;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
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
	private Button btnChangeImageB;
	@FXML
	private AnchorPane hintergrund;
	@FXML
	private ToggleGroup partner;
	@FXML
	private PasswordField Password;
	@FXML
	private Circle kreis;
	
	private FileChooser fileChooser;
	private File filepath;
	
		
	// Profil kann nur gepeichert werden, wenn alle Pflichtfelder aufgefüllt wurden
		@FXML
		public void initialize() {
			this.btnSpeichern.disableProperty().bind(Bindings.or(this.txtName.textProperty().isEmpty(),
					this.txtMail.textProperty().isEmpty()));
			this.btnSpeichern.disableProperty().bind(Bindings.or(this.Password.textProperty().isEmpty(),
					this.txtBeschreibung.textProperty().isEmpty()));

		}	
		
		//Profilbild Ändern
		
		public void ProfilBildAendern(ActionEvent event) {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			fileChooser = new FileChooser();
			fileChooser.setTitle("Bild auswählen");
			
			// Benutzerverzeichnis festlegen oder zum Laufwerk wechseln
			String userDirectoryString = System.getProperty("Bibiothek") + "\\Bilder";
			File userDirectory = new File(userDirectoryString);
			
			if(!userDirectory.canRead())
				userDirectory = new File("c:/");
				
				fileChooser.setInitialDirectory(userDirectory);
			
			
			this.filepath = fileChooser.showOpenDialog(stage);
			
			//das Profilbild ändern indem man ein neues Bild hochlädt
			try {
				BufferedImage bufferedImage = ImageIO.read(filepath);
				Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				Picture.setImage(image);
				
			}catch(IOException e) {
				
			}
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
	
	/**
	 * Wenn man in der Profil bearbeiten Scene den Zurück-Button drückt gelangt man
	 * wieder zum Profil
	 **/
	public void ProfilZurueckk(ActionEvent event) throws IOException {
		
		Parent ProfilBearbeitenParent = FXMLLoader.load(getClass().getResource("/profil/Profil.fxml"));
		Scene ProfilBearbeitenScene = new Scene(ProfilBearbeitenParent);
		
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(ProfilBearbeitenScene);
		window.show();
	}
	



}
	