-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population FROM state ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT census_region, state_name 
FROM state
ORDER BY census_region DESC, 
	     state_name ASC;

-- The biggest park by area
SELECT park_name, area
FROM park
ORDER BY area DESC
LIMIT 1;

-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT DATE_PART('year', CURRENT_DATE) - DATE_PART('year', date_established) AS years_established, park_name 
FROM park 
ORDER BY years_established DESC, park_name ASC 
LIMIT 20;

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ', ' || state_abbreviation AS city_state_name -- Akron, OH
FROM city;

-- The all parks by name and date established.
-- Name: <park_name> Date Established: <date_established>
SELECT 'Name: ' || park_name || ' Date Established: ' || date_established
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
-- <census_region>: <state_name>
SELECT census_region || ': ' || state_name AS region_and_state
FROM state
WHERE census_region = 'West' OR census_region = 'Midwest'
ORDER BY region_and_state;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT ROUND(AVG(population)) AS average_population
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_southwest_population
FROM state
WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(city_name) AS more_than_a_million
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(state_nickname) AS count_nicknames
FROM state;

SELECT * FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;

-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name) AS city_count
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

/*
 AK Fairbanks, Juneau
 AL 5
*/

-- Determine the average park area depending upon whether parks allow camping or not.
-- has_camping    avg_park_area
-- true           xx
-- false          xx
SELECT has_camping, AVG(area) AS average_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, population
FROM city
ORDER BY state_abbreviation;

SELECT state_abbreviation, SUM(population) AS state_population
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_population
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city_population;

-- two group bys

-- list of strings
SELECT state_abbreviation, STRING_AGG(city_name, ', ') AS city_list, COUNT(city_name) AS city_count
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- top two populations

SELECT state_abbreviation, population, row_number
FROM
   (SELECT state_abbreviation, population, ROW_NUMBER() OVER (PARTITION BY state_abbreviation ORDER BY population ASC) AS row_number 
   FROM city) temp_table
WHERE row_number <= 2;

-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name
FROM city
ORDER BY city_name
OFFSET 20 ROWS FETCH NEXT 10 ROWS ONLY;

-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT 
	 (
		 SELECT state_name 
	  	 FROM state 
	 	 WHERE state.state_abbreviation = city.state_abbreviation
	 ) AS state_name
	,COUNT(city_name) AS city_count
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- Include the names of the smallest and largest parks

SELECT park_name, area
FROM park, 
	(SELECT MIN(area) AS smallest, MAX(area) AS largest FROM park) AS smallest_and_largest
WHERE area = smallest
      OR area = largest;
	  
-- alternative with explicit table name and column name
SELECT park.park_name, park.area
FROM park, 
	(SELECT MIN(area) AS smallest, MAX(area) AS largest FROM park) AS smallest_and_largest
WHERE park.area = smallest_and_largest.smallest
      OR park.area = smallest_and_largest.largest;

-- List the capital cities for the states in the Northeast census region.
--	

SELECT 
	(SELECT city_name FROM city WHERE city.city_id = state.capital) AS capital_city_name
FROM state 
WHERE census_region = 'Northeast';

SELECT city_name
FROM city
WHERE city_id IN (SELECT capital FROM state WHERE census_region = 'Northeast');

-- The 10 largest cities by populations, ordered by city_name alphabetically
-- NOT DONE YET
SELECT city_name, population
FROM
		(
			SELECT city_name, population
			FROM city
			ORDER BY population DESC
			LIMIT 10
		) AS top_ten_city_populations
ORDER BY city_name;


