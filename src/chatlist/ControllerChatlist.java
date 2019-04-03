package chatlist;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerChatlist {

    @FXML
    private Button chatlistzurueckbtn;

	@FXML
	ListView<String> listviewchatauflistung = new ListView<>();
	ObservableList<String> data = FXCollections.observableArrayList (
			"Rüdiger",
			"Hans",
			"Gerdrud",
			"Hildegard");
	
	/**
	 * Wenn man in der Chatlist-Scene den Zurück-Button drückt und zum
	 * Hauptscreen weitergeleitet wird
	 **/
	public void EinstellungenZurueckkk(ActionEvent event) throws IOException {

		Parent SwipeParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene SwipeScene = new Scene(SwipeParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(SwipeScene);
		window.show();
	}
	
}
