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
  ('Ihor', 'Shylo', 27, 2000, 3)
;

INSERT INTO projects (project_name, start_date, end_date) VALUES
  ('Mtools', '2013-01-01', '2018-01-01'),
  ('ME', '2014-06-01', '2018-01-01'),
  ('goJava6FinalProject', '2017-04-12', '2018-05-12')
;