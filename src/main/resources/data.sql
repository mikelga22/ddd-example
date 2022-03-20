create table if not exists users (
    id varchar(36) PRIMARY KEY,
    username varchar(30),
    can_borrow boolean
);

create table if not exists books (
    id varchar(36) PRIMARY KEY,
    title text,
    isbn varchar(50),
    is_available boolean
);

create table if not exists borrowings (
    id varchar(36) PRIMARY KEY,
    book uuid,
    user uuid
);


INSERT INTO users(id, username, can_borrow) VALUES ('021f9960-b0c0-4863-bb00-bf865dfe9b76', 'mozart', true);
INSERT INTO users(id, username, can_borrow) VALUES ('a48850af-5ab7-4dfa-ad02-9d8ec250221e', 'beethoven', true);
INSERT INTO users(id, username, can_borrow) VALUES ('26d2271a-a9f7-4403-9a4f-019cdabb5b42', 'vivaldi', true);


INSERT INTO books(id, title, isbn, is_available) VALUES ('0af05196-b74f-4d6a-90bb-79b5be4ad4ad', 'Book 1', '123456789', true);
INSERT INTO books(id, title, isbn, is_available) VALUES ('199c9d9d-e361-4fe2-b926-8254efc4a100', 'Book 1', '123456789', true);
INSERT INTO books(id, title, isbn, is_available) VALUES ('d3ef5d62-799e-4d0d-bf8a-43c029a9156e', 'Book 1', '123456789', true);
INSERT INTO books(id, title, isbn, is_available) VALUES ('4a160e72-3a45-495a-b34b-4b32ad559293', 'Book 1', '123456789', true);