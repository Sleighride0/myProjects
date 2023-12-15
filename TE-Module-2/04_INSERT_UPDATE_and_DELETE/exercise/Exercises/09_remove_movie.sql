-- 9. Remove "Memento" from the movie table
-- You'll have to remove data from two other tables before you can remove it (13 rows, 2 rows, 1 row)
SELECT * FROM movie
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
--JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE movie.title = 'Memento';

DELETE FROM movie_actor
WHERE movie_id = 77;
DELETE FROM movie_genre
WHERE movie_id = 77;
DELETE FROM movie
WHERE movie_id = 77;
