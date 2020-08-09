BEGIN;

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (id bigserial, name varchar(255), age smallint, PRIMARY KEY (id));
INSERT INTO users (name, age) VALUES
('Alex', 22),
('Andrey', 18),
('Alice', 15),
('Bob', 24),
('Galina', 34),
('Diana', 30),
('Denis', 28),
('Vlad', 30);

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial, name varchar(255), cost DECIMAL, PRIMARY KEY (id));
INSERT INTO products (name, cost) VALUES
('toy', 100),
('ball', 120),
('pen', 140),
('pencil', 25),
('telephone', 8900),
('car', 250000),
('telly', 10000),
('pillow', 3400),
('clothes', 2340);

COMMIT;