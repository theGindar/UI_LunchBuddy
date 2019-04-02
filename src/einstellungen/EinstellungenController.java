package einstellungen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EinstellungenController {

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

	
	
}
