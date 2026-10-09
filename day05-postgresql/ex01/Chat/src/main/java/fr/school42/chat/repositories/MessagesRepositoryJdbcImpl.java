package main.java.fr.school42.chat.repositories;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import javax.sql.DataSource;

import main.java.fr.school42.chat.models.*;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
	private final DataSource dataSource;

	public MessagesRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Optional<Message> findById(Long id) throws SQLException {
		Connection connection = dataSource.getConnection();

		Statement MsgStatement = connection.createStatement();
		String queryMsg = "SELECT * FROM chat.messages WHERE id = " + id + ";";
		ResultSet resultMsgSet = MsgStatement.executeQuery(queryMsg);
		resultMsgSet.next();

		Statement userStatement = connection.createStatement();
		String queryUser = "SELECT * FROM chat.users WHERE id = " + resultMsgSet.getLong("author") + ";";
		ResultSet resultUserset = userStatement.executeQuery(queryUser);
		resultUserset.next();

		Statement chatroomStatement = connection.createStatement();
		String queryChatroom = "SELECT * FROM chat.chatrooms WHERE id = " + resultMsgSet.getLong("room") + ";";
		ResultSet resultCharroomset = chatroomStatement.executeQuery(queryChatroom);
		resultCharroomset.next();

		User user = new User(resultUserset.getLong("id"), resultUserset.getString("login"),
				resultUserset.getString("password"), null, null);
		ChatRoom chatroom = new ChatRoom(resultCharroomset.getLong("id"), resultCharroomset.getString("name"), user,
				null);
		Optional<Message> OptionalMsg = Optional.of(new Message(resultMsgSet.getLong("id"), user, chatroom,
				resultMsgSet.getString("content"), " 11111111for testin1111"));

		// print
		System.out.println(OptionalMsg.get());

		return OptionalMsg;

	}
}