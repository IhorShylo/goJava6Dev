CREATE DATABASE IF NOT EXISTS goJava6_db;

CREATE TABLE IF NOT EXISTS ranks (
  rank_id    INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  rank_title VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS skills (
  skill_id    INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  skill_title VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS developers (
  developer_id INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name   VARCHAR(30) NOT NULL,
  last_name    VARCHAR(30) NOT NULL,
  age          INT         NOT NULL,
  salary       DOUBLE      NOT NULL,
  rank_id      INT         NOT NULL,
  FOREIGN KEY (rank_id) REFERENCES ranks (rank_id)
);

CREATE TABLE IF NOT EXISTS projects (
  project_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(30) NOT NULL,
  start_date   DATE,
  end_date     DATE
);

CREATE TABLE IF NOT EXISTS companies (
  companie_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  companie_name VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
  customer_id     INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  customer_name   VARCHAR(30) NOT NULL,
  customer_adress VARCHAR(50),
  customer_email  VARCHAR(30) UNIQUE
);


/*Tables of relations*/
CREATE TABLE IF NOT EXISTS developers_skills (
  developer_id INT NOT NULL,
  skill_id     INT NOT NULL,
  CONSTRAINT PK_Developers_Skills PRIMARY KEY (developer_id, skill_id),
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (skill_id) REFERENCES skills (skill_id)
);

CREATE TABLE IF NOT EXISTS projects_developers (
  project_id   INT NOT NULL,
  developer_id INT NOT NULL,
  CONSTRAINT PK_Projects_Developers PRIMARY KEY (project_id, developer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id),
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id)
);

CREATE TABLE IF NOT EXISTS companies_projects (
  companie_id INT NOT NULL,
  project_id  INT NOT NULL,
  CONSTRAINT PK_Companies_Projects PRIMARY KEY (companie_id, project_id),
  FOREIGN KEY (companie_id) REFERENCES companies (companie_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE IF NOT EXISTS customers_projects (
  customer_id INT NOT NULL,
  project_id  INT NOT NULL,
  CONSTRAINT PK_Customers_Projects PRIMARY KEY (customer_id, project_id),
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);