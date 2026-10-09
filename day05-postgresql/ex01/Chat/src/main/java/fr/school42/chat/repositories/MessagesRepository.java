package main.java.fr.school42.chat.repositories;

import java.util.Optional;
import java.sql.SQLException;

import main.java.fr.school42.chat.models.*;

public interface MessagesRepository {
	Optional<Message> findById(Long id) throws SQLException;
}
