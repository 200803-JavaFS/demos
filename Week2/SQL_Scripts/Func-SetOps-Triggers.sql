--Scalar Function
SELECT LOWER(last_name) AS lower_lname FROM avengers;

--Aggregate Function
SELECT SUM(power_level) AS total_sum FROM avengers WHERE superhero_id < 5;

--subquery
SELECT COUNT(upper_name) FROM 
(SELECT UPPER(first_name) AS upper_name FROM avengers) AS upcount 
WHERE upper_name LIKE '%C%'; 


--functions
-- or replace is used here in the same that "if exists" is used with drop. It will replace the function if it already exists. 
CREATE OR REPLACE FUNCTION get_current_time() RETURNS TIME WITH TIME ZONE
AS $$
-- curent_time is a built value that is just the current time.  
SELECT current_time;
$$ LANGUAGE SQL; 

SELECT get_current_time(); 


CREATE OR REPLACE FUNCTION avenger_name() RETURNS TABLE(
	first_name VARCHAR(30),
	last_name VARCHAR(30)
) AS
$func$

SELECT first_name, last_name FROM avengers;

$func$ LANGUAGE SQL;
	

SELECT * FROM avenger_name();

CREATE OR REPLACE FUNCTION avenger_power_under(lpower INTEGER) RETURNS SETOF avengers
AS
$$
	SELECT * FROM avengers WHERE power_level < lpower; 
$$ LANGUAGE SQL;

SELECT * FROM avenger_power_under(1000);  

CREATE OR REPLACE FUNCTION trigger_set_time() RETURNS TRIGGER 
AS $$
--Returning a Trigger allows for use of some special varaibles NEW and OLD which represent the 
--state of the database before and after the event. 

BEGIN
	NEW.update_at = NOW();
	RETURN NEW; 
END;
$$ LANGUAGE plpgsql; 


ALTER TABLE avengers ADD COLUMN update_at TIMESTAMP;

CREATE TRIGGER set_time BEFORE UPDATE ON avengers FOR EACH ROW
EXECUTE PROCEDURE trigger_set_time();

UPDATE avengers SET power_level = 3000 WHERE superhero_id = 5; 




