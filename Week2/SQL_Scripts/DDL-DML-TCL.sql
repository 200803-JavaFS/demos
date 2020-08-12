--CREATE DATABASE demos;
--This is a SQL comment.

--DDL commands

DROP TABLE IF EXISTS avengers; 

CREATE TABLE avengers (
	superhero_name VARCHAR(30),
	superhero_power VARCHAR(30),
	real_name VARCHAR(30),
	power_level INTEGER
);

ALTER TABLE avengers ADD COLUMN active BOOLEAN;

TRUNCATE TABLE avengers; 

--DML commands

INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 20),
	('Hawkeye', 'plucky can-do attitude', 'Clint Barton', 55);

UPDATE avengers SET active = false WHERE superhero_name = 'Capt. America';
UPDATE avengers SET active = true WHERE superhero_name = 'Hawkeye';

DELETE FROM avengers WHERE real_name = 'Steve Rogers'; 

--DQL

SELECT real_name FROM avengers;

SELECT * FROM avengers WHERE superhero_name = 'Hawkeye'; 

--Transaction

BEGIN;
INSERT INTO avengers (superhero_name, superhero_power, real_name, power_level)
	VALUES ('Capt. America', 'Super Strong Frisbee', 'Steve Rogers', 20),
	('Hawkeye', 'plucky can-do attitude', 'Clint Barton', 55);
UPDATE avengers SET active = false WHERE superhero_name = 'Capt. America';
UPDATE avengers SET active = true WHERE superhero_name = 'Hawkeye';
COMMIT; 

--ROLLBACK;
