package swipeScreen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SwipeController {

	@FXML
	private Button btnProfil;
	@FXML
	private Button btnEinstellungen;
	@FXML 
	private ImageView ZuEinstellungen;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Wenn man auf der SwipeScene den Settings-Button drückt und zum
	 * EinstellungsScreen weitergeleitet wird
	 **/
	public void ZumEinstellungen(ActionEvent event) throws IOException {

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
	public void ZumProfil(ActionEvent event) throws IOException {

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
	public void ZumChat(ActionEvent event) throws IOException {

		Parent ZumChatParent = FXMLLoader.load(getClass().getResource("/chatlist/Chats_gui.fxml"));
		Scene ZumChatScene = new Scene(ZumChatParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ZumChatScene);
		window.show();
	}
}
