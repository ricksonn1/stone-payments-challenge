CREATE TABLE transactions (  
  id BIGINT PRIMARY KEY AUTO_INCREMENT,  
  client_id BIGINT NOT NULL,  
  total_to_pay INT NOT NULL,
  card_number VARCHAR(16),
  value INT,
  cvv INT,
  card_holder_name VARCHAR(255),
  exp_date VARCHAR(10),

  FOREIGN KEY (client_id) REFERENCES clients (id)  
);  
