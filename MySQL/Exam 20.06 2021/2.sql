INSERT INTO clients (full_name,phone_number)
SELECT concat_ws(' ',first_name,last_name),concat('(088) 9999',2*id)
FROM drivers
WHERE id BETWEEN 10 AND 20 ;