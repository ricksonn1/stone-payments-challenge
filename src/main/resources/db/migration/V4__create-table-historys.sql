CREATE TABLE historys (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  client_id BIGINT NOT NULL,
  purchase_id BIGINT NOT NULL,
  date VARCHAR(10) NOT NULL,
  FOREIGN KEY (client_id) REFERENCES clients (id),
  FOREIGN KEY (purchase_id) REFERENCES transactions (id)
);