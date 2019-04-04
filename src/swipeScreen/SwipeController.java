package swipeScreen;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SwipeController extends Application implements Initializable  {

	@FXML
    private AnchorPane hintergrundSwipe;

    @FXML
    private Button btnEinstellungen;

    @FXML
    private Button btnProfil;

    @FXML
    private ImageView imgProfil;

    @FXML
    private Button ZumChatBtn;
    @FXML
    private Circle kreis;
  
    
	//Kreis erzeugen und Bild darin speichern
@Override
	public void initialize (URL url, ResourceBundle rb) {
		kreis.setStroke(Color.SEAGREEN);
		Image im= new Image("application\\SwipePicture.jpg",false);
		kreis.setFill(new ImagePattern(im));
		kreis.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
}
      
   
	
		
	
	/**
	 * Wenn man auf der SwipeScene den Settings-Button drückt und zum
	 * EinstellungsScreen weitergeleitet wird
	 **/
	public void zumEinstellungen(ActionEvent event) throws IOException {

		Parent BtnEinstellungenParent = FXMLLoader.load(getClass().getResource("/einstellungen/Einstellungen.fxml"));
		Scene BtnEinstellungenScene = new Scene(BtnEinstellungenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(BtnEinstellungenScene);
		window.show();
	}
	
	
	/**
	 * Wenn man in der EinloggSceene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void zumProfil(ActionEvent event) throws IOException {

		Parent ZumProfilParent = FXMLLoader.load(getClass().getResource("/profil/Profil.fxml"));
		Scene ZumProfilScene = new Scene(ZumProfilParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ZumProfilScene);
		window.show();
	}
	
	
	/**
	 * Wenn man in der SwipeScene den Chats-Button drückt und zum
	 * ChatScreen weitergeleitet wird
	 **/
	public void zumChat(ActionEvent event) throws IOException {

		Parent ZumChatParent = FXMLLoader.load(getClass().getResource("/chatlist/Chats_gui.fxml"));
		Scene ZumChatScene = new Scene(ZumChatParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ZumChatScene);
		window.show();
	}
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
