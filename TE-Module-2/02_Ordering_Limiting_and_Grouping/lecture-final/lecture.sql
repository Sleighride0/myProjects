-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT *
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest parks by area
SELECT park_name, area
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
limit 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_established, (CURRENT_DATE - date_established )/ 365 AS years
FROM park
ORDER BY date_established, park_name
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ', ' || state_abbreviation) AS city_and_state
FROM city;

-- The all parks by name and date established.
SELECT (park_name || ' est: ' || date_established) AS park_and_date_est
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT (census_region || ' , ' || state_name ) AS census_and_state
FROM state
WHERE census_region ILIKE '%west'
ORDER BY census_region ASC, state_name;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT ROUND(AVG(population), 2) AS avg_pop
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS sum_pop_South_West_cr
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*)
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*)
FROM state
WHERE state_nickname IS NOT Null;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT COUNT(state_abbreviation), state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY COUNT(state_abbreviation) DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, ROUND(AVG(area), 2)
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT SUM(population), state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;
-- The smallest city population in each state ordered by city population.
SELECT MIN(population) AS min_pop, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY min_pop;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,



SELECT COUNT(city_name) AS cities, 
	(SELECT state_name FROM state WHERE state_abbreviation = city.state_abbreviation)
FROM city
GROUP BY state_abbreviation;


-- Include the names of the smallest and largest parks

SELECT park_name, area
FROM park
WHERE area = (SELECT MIN(area) FROM park) OR area = (SELECT MAX(area)FROM park);
-- List the capital cities for the states in the Northeast census region.

SELECT city_name FROM city WHERE city_id IN 
(SELECT capital FROM state WHERE census_region = 'Northeast')
;

SELECT (SELECT city_name FROM city WHERE city_id = state.capital) || ', ' || state_name AS state_capitals FROM state
WHERE census_region = 'Northeast'
ORDER BY state_name;



--list every city in a state with a state population greater than 10 million
-- need cities from city table
-- need pop from state qualified above 10 million
SELECT * FROM city WHERE state_abbreviation IN 

(SELECT state_abbreviation FROM state WHERE population > 10000000);

