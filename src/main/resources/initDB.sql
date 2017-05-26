CREATE DATABASE goJava6_db;

create table IF NOT EXISTS developers (
  developer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  age INT NOT NULL,
  rank_id INT NOT NULL
);

create table IF NOT EXISTS skills (
  skill_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  skill_title VARCHAR(30) NOT NULL UNIQUE
);

create table IF NOT EXISTS developers_skills (
  developer_id INT NOT NULL,
  skill_id INT NOT NULL,
  CONSTRAINT PK_Developers_Skills PRIMARY KEY (developer_id,skill_id),
  FOREIGN KEY (developer_id) REFERENCES developers(developer_id),
  FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
);




