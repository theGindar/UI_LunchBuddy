package chat;

public class ChatMessage {
	private String messageText;
	private boolean receivedMessage;
	
	ChatMessage(String messageText, boolean receivedMessage){
		setMessageText(messageText);
		setReceivedMessage(receivedMessage);	
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public boolean getReceivedMessage() {
		return receivedMessage;
	}
	
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	public void setReceivedMessage(boolean receivedMessage) {
		this.receivedMessage = receivedMessage;		
	}
}
