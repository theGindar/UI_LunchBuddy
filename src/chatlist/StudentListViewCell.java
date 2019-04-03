package chatlist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class StudentListViewCell extends ListCell<Student> {

	@FXML
	private Label label1;

	@FXML
	private Label label2;

	@FXML
	private GridPane gridPane;

	private FXMLLoader mLLoader;

	@Override
	protected void updateItem(Student student, boolean empty) {
		super.updateItem(student, empty);

		if (empty || student == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("ListCell.fxml"));
				mLLoader.setController(this);

				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			label2.setText(student.getName());

			setText(null);
			setGraphic(gridPane);
		}

	}
}
