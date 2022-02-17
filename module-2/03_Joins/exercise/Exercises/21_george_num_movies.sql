-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in
--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'

SELECT person_name, COUNT(movie_id) AS num_of_movies
FROM movie
JOIN movie_actor USING (movie_id)
RIGHT JOIN person ON person.person_id = movie_actor.actor_id
WHERE person_name LIKE 'George %'
GROUP BY actor_id, person_name
ORDER BY person_name;