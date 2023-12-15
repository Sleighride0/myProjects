-- 6. For movies that are longer than 3 hours and 30 minutes (210 minutes), set their overview to "This is a long movie. N minutes long."
--    where N is the length. Eg. "This is a long movie. 229 minutes long." (5 rows)
SELECT * FROM movie
WHERE length_minutes > 210;
UPDATE movie
SET overview = 'This is a long movie. ' || (SELECT length_minutes FROM movie WHERE movie_id = 947) || ' minutes long.'
WHERE movie_id = 947;
UPDATE movie
SET overview = 'This is a long movie. ' || (SELECT length_minutes FROM movie WHERE movie_id = 377462) || ' minutes long.'
WHERE movie_id = 377462;
UPDATE movie
SET overview = 'This is a long movie. ' || (SELECT length_minutes FROM movie WHERE movie_id = 311) || ' minutes long.'
WHERE movie_id = 311;
UPDATE movie
SET overview = 'This is a long movie. ' || (SELECT length_minutes FROM movie WHERE movie_id = 770) || ' minutes long.'
WHERE movie_id = 770;
UPDATE movie
SET overview = 'This is a long movie. ' || (SELECT length_minutes FROM movie WHERE movie_id = 3870) || ' minutes long.'
WHERE movie_id = 3870;
