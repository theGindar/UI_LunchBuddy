package application;

import chat.ControllerChat;
import chatlist.ControllerChatlist;
import einstellungen.EinstellungenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Model;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// EinstellungenController.class.getClassLoader().getResource("Einstellungen.fxml");
			Model model = new Model();
			Parent root = FXMLLoader.load(getClass().getResource("/start/Start_gui.fxml"));
			

			FXMLLoader chatlistLoader = new FXMLLoader(getClass().getResource("/chatlist/Chats_gui.fxml"));
			chatlistLoader.setController(new ControllerChatlist(model));
			Parent chatlistUI = chatlistLoader.load();
			
			FXMLLoader chatLoader = new FXMLLoader(getClass().getResource("/chat/ChatGUI.fxml"));
			chatLoader.setController(new ControllerChat(model));
			Parent chatUI = chatLoader.load();
			
			
			
			Scene scene = new Scene(root, 300, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/application/donut.png"));
			primaryStage.setTitle("Lunchbuddy");
			
			primaryStage.setMinHeight(550);
			primaryStage.setMinWidth(300);
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
