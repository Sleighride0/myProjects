-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT *
FROM state;


-- The biggest parks by area
SELECT *
FROM park
ORDER BY area DESC;



-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
limit 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_established, (CURRENT_DATE - date_established) / 365 AS years
FROM park
ORDER BY date_established ASC, park_name ASC
LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ', ' || state_abbreviation) AS city_and_state
FROM city;

-- The all parks by name and date established.
SELECT (park_name || ' est: ' || date_established) AS park_name_and_date
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT (census_region || ', ' || state_name) AS census_and_state
FROM state
WHERE census_region IN ('West','Midwest')
ORDER BY census_region;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_pop
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population)
FROM state
WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(city_name)
FROM city
WHERE population > 1000000

-- The number of state nicknames.


-- The area of the smallest and largest parks.



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.


-- Determine the average park area depending upon whether parks allow camping or not.


-- Sum of the population of cities in each state ordered by state abbreviation.


-- The smallest city population in each state ordered by city population.



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

