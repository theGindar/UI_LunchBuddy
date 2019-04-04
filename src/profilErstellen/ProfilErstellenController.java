package profilErstellen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ProfilErstellenController extends Application implements Initializable {

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
	@FXML
	private Circle kreis;
    @FXML
	private Label LabelPwFalsch;
	
	private FileChooser fileChooser;
	private File filepath;

	
	//Kreis erzeugen und Bild darin speichern
@Override
	public void initialize (URL url, ResourceBundle rb) {
		kreis.setStroke(Color.SEAGREEN);
		Image im= new Image("/application/profile_icon.png",false);
		kreis.setFill(new ImagePattern(im));
		kreis.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		
	}

	// Profil kann nur erstellt werden, wenn alle Pflichtfelder aufgefüllt wurden
	@FXML
	public void initialize() {
		this.btnErstellenSpeichern.disableProperty().bind(Bindings.or(this.txtErstellenName.textProperty().isEmpty(),
				this.txtErstellenMail.textProperty().isEmpty()));
		this.btnErstellenSpeichern.disableProperty().bind(Bindings.or(this.PasswordErstellen.textProperty().isEmpty(),
				this.txtErstellenBeschreibung.textProperty().isEmpty()));
		
	}
	

	//Profilbild Ändern
	
	public void profilBildAendern(ActionEvent event) {
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
			kreis.setFill(new ImagePattern(image));
			
		}catch(IOException e) {
			
		}
	}
	
	
	
	
	
	/// **Wenn man in der ProfilErstellenScreen den Erstellen-Button drückt
	// und zum SwipeScreen weitergeleitet wird **/
	public void profilErstellenSpeichern(ActionEvent event) throws IOException {
		
		String pattern = "[\\w\\.äöü-]+@[\\w\\.äöü-]+\\.(de|com|net|org)";
		Pattern pt = Pattern.compile(pattern);
		Matcher m = pt.matcher(txtErstellenMail.getText());
		if(m.find()) {

		Parent profilErstellenParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene profilErstellenScene = new Scene(profilErstellenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(profilErstellenScene);
		window.show();} 
		else {
			LabelPwFalsch.setText("Bitte eine korrekte E-Mail eingeben");
			LabelPwFalsch.setTextFill(Color.web("#FF0000"));
			
		}
	}

	/**
	 * Wenn man in der ProfilErstellenScene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void profilErstellenZurueck(ActionEvent event) throws IOException {

		Parent profilErstellenParent = FXMLLoader.load(getClass().getResource("/start/Start_gui.fxml"));
		Scene profilErstellenScene = new Scene(profilErstellenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(profilErstellenScene);
		window.show();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
