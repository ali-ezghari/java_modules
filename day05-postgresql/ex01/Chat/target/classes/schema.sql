DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA chat;

CREATE TABLE chat.users (
    id SERIAL PRIMARY KEY,
    login TEXT UNIQUE NOT NULL, 
    password TEXT NOT NULL
);

CREATE TABLE chat.chatrooms (
    id SERIAL PRIMARY KEY, 
    name TEXT NOT NULL, 
    owner BIGINT REFERENCES chat.users(id) ON DELETE CASCADE
);

CREATE TABLE chat.messages (
    id SERIAL PRIMARY KEY, 
    author BIGINT REFERENCES chat.users(id) ON DELETE CASCADE, 
    room BIGINT REFERENCES chat.chatrooms(id) ON DELETE CASCADE,  
    content TEXT NOT NULL, 
    datetime TIMESTAMP NOT NULL
);             

CREATE TABLE chat.users_chatrooms (
    user_id BIGINT REFERENCES chat.users(id) ON DELETE CASCADE,
    chatroom_id BIGINT REFERENCES chat.chatrooms(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, chatroom_id)
);



-- 			System.err.println("Database connection failed!");
