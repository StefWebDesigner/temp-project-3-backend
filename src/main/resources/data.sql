DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    username VARCHAR(50),
    pass VARCHAR(50)
);
insert into users (username, pass) values ('jeff', 'pass');