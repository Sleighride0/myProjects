-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
SELECT * FROM park
ORDER BY park_id DESC;

INSERT INTO park (park_name, date_established, area, has_camping)
VALUES('Disneyland', '1955-07-17', 2.1, false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
SELECT * FROM city
ORDER BY state_abbreviation DESC;

INSERT INTO city(city_name, state_abbreviation, population, area)
VALUES('Hawkins', 'IN', 30000, 38.1), ('Cicely', 'AK', 839, 11.4);

INSERT INTO city(city_name, state_abbreviation, population, area)
VALUES('JavaBlue', 'OH', 18, .001)RETURNING city_id;

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
SELECT * FROM park_state
ORDER BY park_id DESC;
SELECT park_id FROM park WHERE park_name = 'Disneyland';

INSERT INTO park_state(park_id,state_abbreviation)
VALUES((SELECT park_id FROM park WHERE park_name = 'Disneyland'),'FL');

INSERT INTO park_state(park_id,state_abbreviation)
VALUES(85,'CA');
-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * FROM state
ORDER BY state_abbreviation;

UPDATE state
SET state_nickname = 'A Place on Earth'
WHERE state_nickname = 'The Okayest Place on Earth';

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state_name = 'California';

-- Change the capital of California to Anaheim.
UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_name = 'California';

-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA'), population = population - 1000000, state_nickname = 'The Golden State'
WHERE state_name = 'California';


-- DELETE

-- Delete Hawkins, IN from the city table.
DELETE FROM city
WHERE city_name = 'Hawkins';

-- Delete all cities with a population of less than 1,000 people from the city table.
DELETE FROM city
WHERE population < 1000;


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
SELECT * FROM state
ORDER BY state_abbreviation DESC;

INSERT INTO city (city_name, state_abbreviation,population, area )
VALUES ('test', 'XX', 1, 1);


-- Try deleting California from the state table.

UPDATE state
SET capital = 74
WHERE state_abbreviation = 'CA';

DELETE FROM city
WHERE state_abbreviation = 'CA';

DELETE FROM park_state
WHERE state_abbreviation = 'CA';

DELETE FROM state
WHERE state_name = 'California';


-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
DELETE FROM park
WHERE park_name = 'Disneyland';

DELETE FROM park_state
WHERE park_id = 64;

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
INSERT INTO city (city_name, state_abbreviation)
VALUES('Smallville', 'KS');
-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (state_abbreviation, city_name, area)
VALUES( 'KS', 'Smallerville', 2);

SELECT * FROM city;
-- Retrieve the new record to confirm it has been given a default, non-null value for population.


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
SELECT * FROM state WHERE state_name = 'Ohio';
UPDATE state
SET state_nickname = 'Vacationland 2 the sql'
WHERE state_name = 'Ohio';
-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state
SET census_region = 'Southeast'
WHERE state_name = 'Florida';


-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
START TRANSACTION;
DELETE FROM city
WHERE city_name = 'Smallville';
COMMIT;
-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
START TRANSACTION;
DELETE FROM park;
SELECT * FROM park;
ROLLBACK;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
START TRANSACTION;
UPDATE city
SET state_abbreviation = 'XX';
UPDATE city
SET state_abbreviation = 'TX';
ROLLBACK;
SELECT * FROM city;

-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed 