package chat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import chatlist.ControllerChatlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Model;

public class ControllerChat implements Initializable {
	
	
	private final Model model;
	@FXML
	private ListView<ChatMessage> chatListView;

	@FXML
	private Button btnzurueckzuchatlist;

	@FXML
	private Button btnSend;
	
    @FXML
    private Label ueberschriftChat;

	@FXML
	private TextField textFeldChat;

	private ObservableList<ChatMessage> messageObservableList;

	public ControllerChat(Model model) {
		this.model = model;
		messageObservableList = FXCollections.observableArrayList();
		messageObservableList.addAll(
				new ChatMessage("Guten Tag", true), 
				new ChatMessage(model.getName(), false));
		
		//ueberschriftChat.setText("Hallo");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chatListView.setItems(messageObservableList);
		chatListView.setCellFactory(lv -> new ChatListViewCell());
		
		
		ueberschriftChat.setText(model.getName());
		

	}

	/**
	 * Wenn man in dem Chat den Senden-Button drückt um die Nachricht abzuschicken
	 **/
	public void btnSendonclick(ActionEvent event) throws IOException {
		messageObservableList.add(new ChatMessage(textFeldChat.getText(), true));
		System.out.println(textFeldChat.getText());
		textFeldChat.setText("");


	}

	/**
	 * Wenn man in dem Chat den Zurück-Button drückt und zur Chatauflistung
	 * weitergeleitet wird
	 **/
	public void zurueckZuChatliste(ActionEvent event) throws IOException {
		Model model = new Model();
		
		FXMLLoader chatlistLoader = new FXMLLoader(getClass().getResource("/chatlist/Chats_gui.fxml"));
		chatlistLoader.setController(new ControllerChatlist(model));
		Parent chatlistUI = chatlistLoader.load();
		
		
		Scene zumChatScene = new Scene(chatlistUI);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(zumChatScene);
		window.show();
	}
}
