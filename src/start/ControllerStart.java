package start;

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

public class ControllerStart {
	
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    void changeScreenButtonPushed(ActionEvent event) throws IOException {
    	System.out.println("Login Button");
    	
    	Parent Chats_guiParent = FXMLLoader.load(getClass().getResource("Chats_gui.fxml")); 
		Scene Chats_guiScene = new Scene(Chats_guiParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(Chats_guiScene);
		window.show();
    	
    }
    
}
