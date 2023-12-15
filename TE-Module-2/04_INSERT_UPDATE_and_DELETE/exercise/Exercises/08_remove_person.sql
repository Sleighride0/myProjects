-- 8. Remove "Penn Jillette" from the person table 
-- You'll have to remove data from another table before you can make him "disappear" (Get it? Because he's a magician...) (1 row each)
SELECT * FROM person
JOIN movie_actor ON movie_actor.actor_id = person.person_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE person_name = 'Penn Jillette';

DELETE FROM movie_actor
WHERE actor_id = 37221;
DELETE FROM person
WHERE person_id = 37221
