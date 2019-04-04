package chatlist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import chat.ControllerChat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Model;

public class ControllerChatlist implements Initializable {
	private final Model model;
	@FXML
	private Button chatlistzurueckbtn;

	@FXML
	private ListView<Student> listView;

	private ObservableList<Student> studentObservableList;

	public ControllerChatlist(Model model) {
		this.model = model;
		studentObservableList = FXCollections.observableArrayList();
		studentObservableList.addAll(new Student("Max Mustermann"), new Student("Hans Jürgen"),
				new Student("Hildegard Müller"));

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listView.setItems(studentObservableList);
		listView.setCellFactory(studentListView -> new StudentListViewCell());
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println(listView.getSelectionModel().getSelectedItem().getName());
				
				try {
					zuEinemChat(listView.getSelectionModel().getSelectedItem().getName());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});

	}

	/**
	 * Wenn man in der Chatlist-Scene den Zurück-Button drückt und zum Hauptscreen
	 * weitergeleitet wird
	 **/
	public void einstellungenZurueckkk(ActionEvent event) throws IOException {

		Parent einstellungenZurueckkkParent = FXMLLoader.load(getClass().getResource("/swipeScreen/Swipe.fxml"));
		Scene einstellungenZurueckkkScene = new Scene(einstellungenZurueckkkParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(einstellungenZurueckkkScene);
		window.show();
	}
	
	

	/**
	 * Wenn man in der Chatlist-Scene auf einen Chat drückt und zum Chat
	 * weitergeleitet wird
	 **/
	public void zuEinemChat(String name) throws IOException {
		model.setName(name);
		
		Model m = new Model();
		FXMLLoader chatLoader = new FXMLLoader(getClass().getResource("/chat/ChatGUI.fxml"));
		chatLoader.setController(new ControllerChat(model));
		Parent chatUI = chatLoader.load();
		
		
		Scene ChatScene = new Scene(chatUI);

		Stage window = (Stage) ( listView.getScene()).getWindow();
		
		window.setScene(ChatScene);
		window.show();
	}

}
