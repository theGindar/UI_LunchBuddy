package passwortAendern;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chatlist.ControllerChatlist;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Model;

public class PasswortAendernController {

	@FXML
	private AnchorPane hintergrundLogIn;

	@FXML
	private Button btnZurueckZuLogin;

	@FXML
	private Label PwFalsch;

	@FXML
	private PasswordField pw1;

	@FXML
	private PasswordField pw2;

	@FXML
	private PasswordField pw3;

	@FXML
	private Button btnNeuesPwSpeichern;
	@FXML
	private Button btnBestaetigen;
	@FXML
	private Label labelpw1;
	@FXML
	private Label labelpw2;
	@FXML
	private Label labelMail;
	@FXML
	private TextField txtMail;

	// Klick auf "Enter" Taste bei email bestätigung
	@FXML
	public void onEnter(ActionEvent ae) throws IOException {
		System.out.println("Enter gedrückt");

		eMailBestaetigen(ae);

	}

	// Klick auf "Enter" Taste bei Passwort Eingabe
	@FXML
	public void onEnterPW(ActionEvent ae) throws IOException {
		System.out.println("Enter gedrückt");

		pwSpeichernBtn(ae);

	}

	// Hier wird die eMail bestätigt
	public void eMailBestaetigen(ActionEvent event) throws IOException {
		String pattern = "[\\w\\.äöü-]+@[\\w\\.äöü-]+\\.(de|com|net|org)";
		Pattern pt = Pattern.compile(pattern);
		Matcher m = pt.matcher(txtMail.getText());
		if (m.find()) {

			labelpw1.setVisible(true);
			labelpw2.setVisible(true);
			pw1.setVisible(true);
			pw2.setVisible(true);
			pw3.setVisible(true);
			btnNeuesPwSpeichern.setVisible(true);
			btnBestaetigen.setVisible(false);
			txtMail.setVisible(false);

			btnNeuesPwSpeichern.setText("Speichern");
			labelMail.setText("Altes Password eingeben:");

			PwFalsch.setText(" ");

		} else {
			PwFalsch.setText("Bitte eine korrekte E-Mail eingeben");
			PwFalsch.setTextFill(Color.web("#FF0000"));

		}
	}

	/**
	 * Wenn man in der EinloggSceene den Anmelden-Button drückt und zum
	 * Haupt-,SwipeScreen weitergeleitet wird
	 **/
	public void pwSpeichernBtn(ActionEvent event) throws IOException {
		if (pw1.getText().trim().isEmpty()) {
			PwFalsch.setText("Bitte alle Felder ausfüllen!");
			PwFalsch.setTextFill(Color.web("#FF0000"));
		}

		if (pw2.getText().trim().isEmpty()) {
			PwFalsch.setText("Bitte alle Felder ausfüllen!");
			PwFalsch.setTextFill(Color.web("#FF0000"));
		}

		if (pw3.getText().trim().isEmpty()) {
			PwFalsch.setText("Bitte alle Felder ausfüllen!");
			PwFalsch.setTextFill(Color.web("#FF0000"));
		}

		if (pw3.getText().equals(pw2.getText())) {
			if (pw1.getText().trim().isEmpty()) {
				PwFalsch.setText("Bitte alle Felder ausfüllen!");
				PwFalsch.setTextFill(Color.web("#FF0000"));
			} else {
				if (pw2.getText().trim().isEmpty()) {
					PwFalsch.setText("Bitte alle Felder ausfüllen!");
					PwFalsch.setTextFill(Color.web("#FF0000"));
				} else {
					if (pw3.getText().trim().isEmpty()) {
						PwFalsch.setText("Bitte alle Felder ausfüllen!");
						PwFalsch.setTextFill(Color.web("#FF0000"));
					} else {
						System.out.println("Korrekt!");
						PwFalsch.setText("Passwort wurde geändert!");
						PwFalsch.setTextFill(Color.web("#12D81B"));
						
						pw1.setDisable(true);
						pw2.setDisable(true);
						pw3.setDisable(true);
						
						
					}
				}
			}
		} else {
			PwFalsch.setText("Neue Passwörter nicht identisch!");
			PwFalsch.setTextFill(Color.web("#FF0000"));
		}

	}

	/**
	 * Wenn man in der PasswordVergessenSceene den Zurück-Button drückt und zum
	 * LogInScene weitergeleitet wird
	 **/
	public void zurueckZuEinstellungen(ActionEvent event) throws IOException {

		Parent zurueckZuEinstellungenParent = FXMLLoader.load(getClass().getResource("/einstellungen/EinstellungenController.fxml"));
		Scene zurueckZuEinstellungenScene = new Scene(zurueckZuEinstellungenParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(zurueckZuEinstellungenScene);
		window.show();

	}
}
