DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  username VARCHAR(250) DEFAULT NULL,
  password VARCHAR(250) DEFAULT NULL,
  role VARCHAR(250) DEFAULT NULL,
  key varchar(250) default null
);
 
INSERT INTO users (first_name, last_name, username, password, role) VALUES
  ('Tom', 'Tom', 'tom', 'tom', 'user'),
  ('John', 'John', 'john', 'john', 'admin');
  

DROP TABLE IF EXISTS exclusion_accounts ;

CREATE TABLE exclusion_accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  account_number VARCHAR(20) NOT NULL
);
 
INSERT INTO exclusion_accounts (account_number) VALUES
  ('1237'),
  ('1238')
  ;

 
DROP TABLE IF EXISTS user_request ;  
CREATE TABLE user_request (
  request_id INT AUTO_INCREMENT  PRIMARY KEY,
  submitted_by VARCHAR(10) NOT NULL,
  submitted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null ,
  approved_by VARCHAR(10),
  approval_date TIMESTAMP,
  status VARCHAR(10) NOT NULL,
  
  account_number VARCHAR(20) NOT NULL
);
 
INSERT INTO user_request (submitted_by, approved_by, status, account_number) VALUES
  ('tom', '', 'pending', '1234')
    
  
 