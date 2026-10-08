package main.java.fr.school42.chat.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	private long userId;
	private String login;
	private String password;
	private List<ChatRoom> createdRooms;
	private List<ChatRoom> socializeChatRooms;

	public User(long userId, String login, String password, List<ChatRoom> createdRooms,
			List<ChatRoom> socializeChatRooms) {
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.createdRooms = (createdRooms != null) ? createdRooms : new ArrayList<>();
		this.socializeChatRooms = (socializeChatRooms != null) ? socializeChatRooms : new ArrayList<>();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return userId == user.userId &&
				Objects.equals(login, user.login) &&
				Objects.equals(password, user.password) &&
				Objects.equals(createdRooms, user.createdRooms) &&
				Objects.equals(socializeChatRooms, user.socializeChatRooms);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, login, password, createdRooms, socializeChatRooms);
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", login='" + login + '\'' +
				", password='[PROTECTED]'" +
				", createdRoomsCount=" + (createdRooms != null ? createdRooms.size() : 0) +
				", socializeChatRoomsCount=" + (socializeChatRooms != null ? socializeChatRooms.size() : 0) +
				'}';
	}

	// Getters and Setters
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ChatRoom> getCreatedRooms() {
		return createdRooms;
	}

	public void setCreatedRooms(List<ChatRoom> createdRooms) {
		this.createdRooms = (createdRooms != null) ? createdRooms : new ArrayList<>();
	}

	public List<ChatRoom> getSocializeChatRooms() {
		return socializeChatRooms;
	}

	public void setSocializeChatRooms(List<ChatRoom> socializeChatRooms) {
		this.socializeChatRooms = (socializeChatRooms != null) ? socializeChatRooms : new ArrayList<>();
	}
}