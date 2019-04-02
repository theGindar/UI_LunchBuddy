package application;

import einstellungen.EinstellungenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			// EinstellungenController.class.getClassLoader().getResource("Einstellungen.fxml");
			Parent root = FXMLLoader.load(getClass().getResource("/start/Start_gui.fxml"));

			Scene scene = new Scene(root, 300, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.getIcons().add(new Image("/application/donut.png"));
			primaryStage.setTitle("Lunchbuddy");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
