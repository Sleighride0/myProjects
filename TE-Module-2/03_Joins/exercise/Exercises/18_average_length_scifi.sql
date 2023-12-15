-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result between 110-120)

SELECT AVG(length_minutes) AS average_length
FROM genre
JOIN movie_genre ON movie_genre.genre_id = genre.genre_id
JOIN movie ON movie.movie_id = movie_genre.movie_id
--JOIN movie_actor ON movie_actor.movie_id = movie.movie_id 
WHERE genre_name = 'Science Fiction'
--ORDER BY genre_name
