-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)
SELECT title, person_name FROM person
JOIN movie_actor ON movie_actor.actor_id = person.person_id
JOIN movie ON movie.movie_id = movie_actor.movie_id AND person.person_id = movie.director_id
ORDER BY title
