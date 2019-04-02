package start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Start_gui.fxml"));	
			Scene scene = new Scene(root,400,530);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		}
	
	
	
	/**
	public void changeScreenButtonPushed(ActionEvent event) throws IOException{
		Parent Chats_guiParent = FXMLLoader.load(getClass().getResource("Chats_gui.fxml")); 
		Scene Chats_guiScene = new Scene(Chats_guiParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(Chats_guiScene);
		window.show();
	}
	
	public void changeScreenButton2Pushed(ActionEvent event) throws IOException{
		Parent Chats_guiParent = FXMLLoader.load(getClass().getResource("Chats_gui.fxml"));
		Scene Chats_guiScene = new Scene(Chats_guiParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(Chats_guiScene);
		window.show();
	}

	**/
	
	
}
