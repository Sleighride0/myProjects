-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Add yourself to the person
--     table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)

-- SELECT * FROM movie

-- --WHERE title = 'The Blob'
-- ORDER BY director_id
INSERT INTO person (person_id, person_name)
VALUES (3984917, 'Aaron Loskota');
--SELECT * FROM person;
--LEFT JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
--LEFT JOIN movie ON person.person_id = movie.director_id
--ORDER BY person_id DESC;

UPDATE movie
SET director_id = 3984917
WHERE title = 'The Blob';