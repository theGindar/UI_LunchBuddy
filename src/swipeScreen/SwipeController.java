package swipeScreen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import chatlist.ControllerChatlist;
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
import model.Model;

public class SwipeController extends Application implements Initializable {
	int i = 0;
	
	@FXML
	private AnchorPane hintergrundSwipe;

	@FXML
	private Button ZumChatBtn;

	@FXML
	private Button btnSwipeLinks;

	@FXML
	private Button btnSwipeRechts;

	@FXML
	private Circle kreis;

	@FXML
	private Button btnProfil;
	@FXML
	private ImageView imgRechts;
	@FXML
	private ImageView imgProfil;

	@FXML
	private Button btnEinstellungen;
	
	
	public void nextUser() {
		boolean b = true; 
		String[] profile = new String[10] ;
		profile[0] =	"application\\SwipePicture1.jpg";
		profile[1] =	"application\\SwipePicture2.jpg";
		profile[2] =	"application\\SwipePicture3.jpg";
		profile[3] =	"application\\SwipePicture4.jpg";
		profile[4] =	"application\\SwipePicture5.jpg";
		profile[5] =	"application\\SwipePicture6.jpg";
		profile[6] =	"application\\SwipePicture7.jpg";
		profile[7] =	"application\\SwipePicture8.jpg";
		profile[8] =	"application\\SwipePicture9.jpg";
		profile[9] =	"application\\SwipePicture10.jpg";
		
		if(b!=false) {
			Image img = new Image(profile[(int) (Math.random()*profile.length)], false);
			kreis.setFill(new ImagePattern(img));
		}
	
	}
	
	
						

	// Kreis erzeugen und Bild darin speichern
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		kreis.setStroke(Color.SEAGREEN);
		Image im = new Image("application\\SwipePicture1.jpg", false);
		kreis.setFill(new ImagePattern(im));
		kreis.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
	}

	/**
	 * Wenn man auf der SwipeScene den Settings-Button drückt und zum
	 * EinstellungsScreen weitergeleitet wird
	 **/
	public void zumEinstellungen(ActionEvent event) throws IOException {

		Parent btnEinstellungenParent = FXMLLoader.load(getClass().getResource("/einstellungen/Einstellungen.fxml"));
		Scene btnEinstellungenScene = new Scene(btnEinstellungenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(btnEinstellungenScene);
		window.show();
	}

	/**
	 * Wenn man in der EinloggSceene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void zumProfil(ActionEvent event) throws IOException {

		Parent zumProfilParent = FXMLLoader.load(getClass().getResource("/profil/Profil.fxml"));
		Scene zumProfilScene = new Scene(zumProfilParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(zumProfilScene);
		window.show();
	}

	/**
	 * Wenn man in der SwipeScene den Chats-Button drückt und zum ChatScreen
	 * weitergeleitet wird
	 **/
	public void zumChat(ActionEvent event) throws IOException {

		//Parent ZumChatParent = FXMLLoader.load(getClass().getResource("/chatlist/Chats_gui.fxml"));
		
		Model model = new Model();
		
		FXMLLoader chatlistLoader = new FXMLLoader(getClass().getResource("/chatlist/Chats_gui.fxml"));
		chatlistLoader.setController(new ControllerChatlist(model));
		Parent chatlistUI = chatlistLoader.load();
		
		
		Scene ZumChatScene = new Scene(chatlistUI);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ZumChatScene);
		window.show();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
