package chatlist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ControllerChatlist {
	@FXML
	private ListView listviewchatauflistung;

	@FXML
	ListView<String> list = new ListView<>();
	ObservableList<String> data = FXCollections.observableArrayList (
			"Rüdiger",
			"Hans",
			"Gerdrud",
			"Hildegard");
}
