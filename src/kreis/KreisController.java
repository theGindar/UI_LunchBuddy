package kreis;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class KreisController {
	
	@FXML
	private Circle Kreis;
	
	public void initialize(URL url, ResourceBundle rb) {
		Kreis.setStroke(Color.SEAGREEN);
		Image im= new Image("/application/pinguin.jpg");
		Kreis.setFill(new ImagePattern(im));
		Kreis.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
		
	}
	

}
