package chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Chat extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("ChatGUI.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Chat");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
		    primaryStage.show();
	    
		    //Legt die minimale Größe des Fensters fest.
		    primaryStage.setMinWidth(primaryStage.getWidth());
		    primaryStage.setMinHeight(primaryStage.getHeight());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}