SELECT DISTINCT reverse(s.`name`) AS 'reversed_name',
CONCAT(UPPER(t.`name`),'-',a.`name`) AS 'full_address',
(SELECT COUNT(store_id) FROM employees AS e2 WHERE e.store_id = e2.store_id) AS 'employees_count'
FROM towns AS t
JOIN addresses as a ON a.town_id = t.id
JOIN stores AS s ON s.address_id = a.id
JOIN employees AS e ON e.store_id =s.id
ORDER BY full_address;
