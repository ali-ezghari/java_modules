package main.java.fr.school42.chat.models;


import java.util.Objects;

public class Message {
	private long msgId;
	private User author;
	private ChatRoom chatRoom;
	private String text;
	private String dateTime;

	public Message(long msgId, User author, ChatRoom chatRoom, String text, String dateTime) {
		this.msgId = msgId;
		this.author = author;
		this.chatRoom = chatRoom;
		this.text = text;
		this.dateTime = dateTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Message message = (Message) o;
		return msgId == message.msgId &&
				Objects.equals(author, message.author) &&
				Objects.equals(chatRoom, message.chatRoom) &&
				Objects.equals(text, message.text) &&
				Objects.equals(dateTime, message.dateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(msgId, author, chatRoom, text, dateTime);
	}

	// Getters and Setters
	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}