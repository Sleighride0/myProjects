-- 23. The name and date established of parks opened in the 1960s (6 rows)
SELECT park_name, date_established
FROM park
WHERE date_established > '1959-12-31' AND date_established < '1970-01-01'
