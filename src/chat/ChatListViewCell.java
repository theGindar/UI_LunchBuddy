package chat;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;

public class ChatListViewCell extends ListCell<ChatMessage> {
	@FXML
	private Label label1;
	
	@FXML
	private GridPane gridPane;
	
	private FXMLLoader mLLoader;
	
	protected void updateItem(ChatMessage chatMessage, boolean empty) {
		super.updateItem(chatMessage, empty);

        if(empty || chatMessage == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("ChatMessage.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            label1.setText(String.valueOf(chatMessage.getMessageText()));

            

            setText(null);
            setGraphic(gridPane);
        }
	}
}
