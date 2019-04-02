package profilErstellen;

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
import javafx.stage.FileChooser;
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
	private Button btnChangeImage;
	@FXML
	private AnchorPane hintergrundErstellen;
	@FXML
	private ToggleGroup partnerErstellen;
	@FXML
	private PasswordField PasswordErstellen;
	
	private FileChooser fileChooser;
	private File filepath;

	// Profil kann nur erstellt werden, wenn alle Pflichtfelder aufgefüllt wurden
	@FXML
	public void initialize() {
		this.btnErstellenSpeichern.disableProperty().bind(Bindings.or(this.txtErstellenName.textProperty().isEmpty(),
				this.txtErstellenMail.textProperty().isEmpty()));
		this.btnErstellenSpeichern.disableProperty().bind(Bindings.or(this.PasswordErstellen.textProperty().isEmpty(),
				this.txtErstellenBeschreibung.textProperty().isEmpty()));
		
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
			PictureErstellen.setImage(image);
			
		}catch(IOException e) {
			
		}
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
