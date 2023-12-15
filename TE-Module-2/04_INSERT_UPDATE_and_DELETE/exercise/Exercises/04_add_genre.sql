-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 row)
SELECT * FROM genre;
INSERT INTO genre (genre_id, genre_name)
VALUES (10771, 'Sports');

INSERT INTO movie_genre (movie_id, genre_id)
VALUES (7214, 10771)



