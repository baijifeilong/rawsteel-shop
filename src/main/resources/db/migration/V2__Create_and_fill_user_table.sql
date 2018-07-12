CREATE TABLE user (
  id       INTEGER PRIMARY KEY AUTOINCREMENT,
  username TEXT    NOT NULL UNIQUE,
  password TEXT,
  nickname TEXT,
  avatar   TEXT,
  age      INTEGER,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);
