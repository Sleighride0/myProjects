-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set
--     their collection ID to the "Bill Murray Collection". (1 row, 6 rows)

-- SELECT *
-- FROM collection
-- ORDER BY collection_id
-- LEFT JOIN movie_actor ON person.person_id = movie_actor.actor_id
-- LEFT JOIN movie ON movie_actor.movie_id = movie.movie_id
-- LEFT JOIN collection ON collection.collection_id = movie.collection_id
-- ORDER BY person_name;


INSERT INTO collection (collection_id, collection_name)
VALUES (1,'Bill Murray Collection');

UPDATE movie
SET collection_id = '1'
WHERE movie_id IN (SELECT movie_id FROM movie_actor WHERE actor_id = '1532');