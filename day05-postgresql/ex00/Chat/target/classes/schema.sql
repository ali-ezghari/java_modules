DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA chat;

CREATE TABLE chat.users (
    user_id SERIAL PRIMARY KEY,
    login TEXT UNIQUE NOT NULL, 
    password TEXT NOT NULL
);

CREATE TABLE chat.chatroom (
    chatroom_id SERIAL PRIMARY KEY, 
    name TEXT NOT NULL, 
    owner BIGINT REFERENCES chat.users(user_id) ON DELETE CASCADE
);

CREATE TABLE chat.message (
    message_id SERIAL PRIMARY KEY, 
    author BIGINT REFERENCES chat.users(user_id) ON DELETE CASCADE, 
    room BIGINT REFERENCES chat.chatroom(chatroom_id) ON DELETE CASCADE,  
    content TEXT NOT NULL, 
    datetime TIMESTAMP NOT NULL
);             

CREATE TABLE chat.users_chatrooms (
    user_id BIGINT REFERENCES chat.users(user_id) ON DELETE CASCADE,
    chatroom_id BIGINT REFERENCES chat.chatroom(chatroom_id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, chatroom_id)
);