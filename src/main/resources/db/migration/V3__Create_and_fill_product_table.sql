CREATE TABLE product (
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  name       TEXT     NOT NULL,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);

CREATE TABLE sku (
  id         INTEGER PRIMARY KEY AUTOINCREMENT,
  name       TEXT     NOT NULL,
  product_id INTEGER  NOT NULL,
  price      REAL     NOT NULL,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
)