-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)
SELECT title
FROM movie
JOIN collection ON collection.collection_id = movie.collection_id
JOIN person ON person.person_id = movie.director_id
WHERE person_name NOT IN ('George Lucas') AND collection_name = 'Star Wars Collection'
ORDER BY title
