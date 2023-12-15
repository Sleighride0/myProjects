-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. 
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)
SELECT title, length_minutes, release_date
FROM genre
JOIN movie_genre ON movie_genre.genre_id = genre.genre_id
JOIN movie ON movie.movie_id = movie_genre.movie_id
WHERE genre_name = 'Action'
ORDER BY length_minutes DESC, release_date DESC
limit 5
