INSERT INTO chat.users (login, password) VALUES ('user1','pass1'),('user2','pass2'),('user3','pass3'),('user4','pass4'),('user5','pass5');


INSERT INTO chat.chatroom (name, owner) VALUES
    ('General', (SELECT user_id FROM chat.users WHERE login = 'user1')),
    ('Random', 1),
    ('Java Developers', 2),
    ('SQL Experts', 3),
    ('Off-Topic', 4);

INSERT INTO chat.message (author, room, content, datetime) VALUES
	(1, (SELECT chatroom_id FROM chat.chatroom WHERE name = 'General'), 'chatroom conetnt', NOW()), 
	(2, 1, 'Hey Alice, welcome!', NOW()),
    (3, 3, 'Anyone knows how JDBC works?', NOW()),
    (1, 3, 'Yes! You need a Driver and Connection.', NOW()),
    (4, 5, 'Did anyone see the match yesterday?', NOW());

INSERT INTO chat.users_chatrooms (user_id, chatroom_id) VALUES
    (1, 1),
    (1, 3),
    (2, 1),
    (3, 3),
    (4, 5); 