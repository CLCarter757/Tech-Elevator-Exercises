-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)

SELECT DISTINCT person_name, birthday
FROM person
JOIN movie_actor ON movie_actor.actor_id = person.person_id
JOIN movie USING (movie_id)
WHERE birthday >= '1950-01-01' AND birthday < '1960-01-01' AND release_date >= '1985-01-01' AND release_date <= '1985-12-31';