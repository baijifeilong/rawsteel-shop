CREATE TABLE user (
  id       INTEGER PRIMARY KEY                    AUTOINCREMENT,
  username TEXT    NOT NULL UNIQUE,
  password TEXT,
  age      INTEGER NOT NULL                       DEFAULT 0
);

INSERT INTO user (username, password, age) VALUES ('ant', 'ANT', 11);
INSERT INTO user (username, password, age) VALUES ('bee', 'BEE', 22);
INSERT INTO user (username, password, age) VALUES ('cat', 'CAT', 33);
