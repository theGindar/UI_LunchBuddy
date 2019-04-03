package einstellungen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class EinstellungenController {
	boolean sound = false;
	boolean vibration = false;

	@FXML
	private Button logoutbtn;
	@FXML
	private ToggleButton soundbtn;
	@FXML
	private ToggleButton vibrationbtn;

	/**
	 * Wenn man in der EinloggSceene den Zurück-Button drückt und zum
	 * AnfangsScreen(Profil erstellen//anmelden) weitergeleitet wird
	 **/
	public void EinstellungenZurueck(ActionEvent event) throws IOException {

		Parent SwipeParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene SwipeScene = new Scene(SwipeParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(SwipeScene);
		window.show();
	}
	@FXML
	public void SoundAn() {
		
		if(!sound) {
			soundbtn.setText("Deaktivieren");
			sound = true;
		}else {
			soundbtn.setText("Aktivieren");
			sound = false;
		}
				
				
	}
public void VibrationAn() {
		
		if(!vibration) {
			vibrationbtn.setText("Deaktivieren");
			vibration = true;
		}else {
			vibrationbtn.setText("Aktivieren");
			vibration = false;
		}
}

	/**
	 * Weiterleitung zur Startseite
	 **/
	public void Logout(ActionEvent event) throws IOException {

		Parent LogoutParent = FXMLLoader.load(getClass().getResource("/start/start_gui.fxml"));
		Scene LogoutScene = new Scene(LogoutParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(LogoutScene);
		window.show();
	}

}
