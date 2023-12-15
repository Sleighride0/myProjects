-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.
SELECT * FROM person
JOIN movie_actor ON movie_actor.actor_id = person.person_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE movie.movie_id = 299536;

DELETE FROM movie_actor
WHERE movie_id = 299536
