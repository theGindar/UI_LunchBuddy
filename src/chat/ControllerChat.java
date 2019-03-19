package chat;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ControllerChat implements Initializable {
	@FXML
	private ListView<String> chatListView;
	
	
	public ControllerChat() {
		chatListView.getItems().add("asdfasfda");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
