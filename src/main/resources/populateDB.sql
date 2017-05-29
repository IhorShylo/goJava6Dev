INSERT INTO ranks (rank_title) VALUES
  ('Junior'),
  ('Middle'),
  ('Senior')
;

INSERT INTO skills (skill_title) VALUES
  ('Java'),
  ('C++'),
  ('Git'),
  ('Mercurial'),
  ('Maven'),
  ('Gradle'),
  ('Spring'),
  ('JavaEE'),
  ('SOAP'),
  ('REST'),
  ('Hibernate'),
  ('JDBC'),
  ('Angular'),
  ('HTML'),
  ('CSS'),
  ('JS')
;

INSERT INTO developers (first_name, last_name, age, salary, rank_id) VALUES
  ('Ivan', 'Petrov', 26, 800, 1),
  ('John', 'Smith', 30, 800, 1),
  ('Peter', 'Parker', 23, 600, 1),
  ('Aloha', 'Dance', 24, 1500, 2),
  ('Peter', 'Parker', 24, 1600, 2),
  ('Ihor', 'Shylo', 27, 2000, 3)
;

INSERT INTO projects (project_name, start_date, end_date) VALUES
  ('Mtools', '2013-01-01', '2018-01-01'),
  ('ME', '2014-06-01', '2018-01-01'),
  ('goJava6FinalProject', '2017-04-12', '2018-05-12')
;

INSERT INTO companies (companie_name) VALUES
  ('Luxoft'),
  ('GlobalLogic'),
  ('EPAM'),
  ('Ciclum')
;


INSERT INTO customers (customer_name, customer_adress, customer_email) VALUES
  ('Client1', 'Osokorki', 'client1@gmail.com'),
  ('Client2', 'Posnyaki', 'client2@gmail.com'),
  ('Client3', 'Harkivskya', 'client3@gmail.com')
;

INSERT INTO developers_skills (developer_id, skill_id) VALUES
  (1, 1),
  (1, 3),
  (1, 5),
  (2, 2),
  (2, 4),
  (2, 5),
  (3, 1),
  (3, 3),
  (6, 1),
  (6, 2),
  (6, 3),
  (6, 4),
  (6, 5),
  (6, 6),
  (6, 7),
  (6, 8),
  (6, 9),
  (6, 10),
  (6, 11),
  (6, 12),
  (6, 13),
  (6, 14),
  (6, 15),
  (6, 16),
  (4, 1),
  (4, 3),
  (4, 5),
  (4, 7),
  (4, 9),
  (4, 11),
  (4, 13),
  (4, 15),
  (5, 2),
  (5, 4),
  (5, 6),
  (5, 8),
  (5, 10),
  (5, 12),
  (5, 14),
  (5, 16)
;

INSERT INTO projects_developers (project_id, developer_id) VALUES
  (1, 1),
  (1, 3),
  (1, 4),
  (1, 5),
  (1, 6),
  (2, 1),
  (2, 2),
  (2, 4),
  (2, 6),
  (3, 1),
  (3, 2),
  (3, 3),
  (3, 6)
;

INSERT INTO companies_projects (companie_id, project_id) VALUES
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 2),
  (3, 3),
  (4, 1),
  (4, 3)
;

INSERT INTO customers_projects (customer_id, project_id) VALUES
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 2),
  (3, 3)
;
