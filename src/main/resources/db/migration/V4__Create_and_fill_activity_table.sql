CREATE TABLE activity (
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  name       TEXT     NOT NULL,
  type       TEXT     NOT NULL,
  started_at DATETIME NOT NULL,
  stopped_at DATETIME NOT NULL,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);

CREATE TABLE activity_rule (
  id                INTEGER PRIMARY KEY AUTOINCREMENT,
  special_price     REAL,
  money_off         READ,
  money_off_percent INTEGER,
  created_at        DATETIME NOT NULL,
  updated_at        DATETIME NOT NULL
);

CREATE TABLE activity_sku (
  id          INTEGER PRIMARY KEY AUTOINCREMENT,
  activity_id INTEGER  NOT NULL,
  sku_id      INTEGER  NOT NULL,
  created_at  DATETIME NOT NULL,
  updated_at  DATETIME NOT NULL
);