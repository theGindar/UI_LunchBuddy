package chatlist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import chat.ChatListViewCell;
import chat.ChatMessage;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerChatlist implements Initializable{
	


	    @FXML
	    private ListView<Student> listView;

	    private ObservableList<Student> studentObservableList;

	    public ControllerChatlist()  {

	        studentObservableList = FXCollections.observableArrayList();
	        System.out.println("wallah");
	        //add some Students
	        studentObservableList.addAll(
	                new Student("John Doe"),
	                new Student("Jane Doe"),
	                new Student("Donte Dunigan")
	        );


	    }

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	System.out.println("ammmkkkkkkk");
	        listView.setItems(studentObservableList);
	        listView.setCellFactory(studentListView -> new StudentListViewCell());


	    }
	
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
	
	
	public void ZuEinemChat(ActionEvent event) throws IOException {

		Parent ChatParent = FXMLLoader.load(getClass().getResource("/chat/ChatGUI.fxml"));
		Scene ChatScene = new Scene(ChatParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(ChatScene);
		window.show();
	}
	
	
	
}
