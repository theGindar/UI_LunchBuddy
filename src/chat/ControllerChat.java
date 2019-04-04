package chat;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import model.Model;

public class ControllerChat implements Initializable {
	private final Model model;
	@FXML
	private ListView<ChatMessage> chatListView;
	
	private ObservableList<ChatMessage> messageObservableList; 
	
	public ControllerChat(Model model) {
		this.model = model;
		//chatListView.getItems().add("asdfasfda");
		messageObservableList = FXCollections.observableArrayList();
		messageObservableList.addAll(
				new ChatMessage("blablabla", true),
				new ChatMessage(model.getName(), false));
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chatListView.setItems(messageObservableList);
		chatListView.setCellFactory(lv -> new ChatListViewCell());
		
	}
}
