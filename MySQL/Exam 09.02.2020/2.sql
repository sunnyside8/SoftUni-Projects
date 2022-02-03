INSERT INTO coaches (first_name,last_name,salary,coach_level)
SELECT first_name,last_name,(salary * 2),char_length(first_name)
FROM players
WHERE age >= 45;