SELECT concat_ws(' ',e.first_name,e.last_name) AS 'Full name',
s.`name`,
a.`name` AS 'address',
e.salary
FROM addresses AS a
RIGHT JOIN stores AS s ON a.id = s.address_id
RIGHT JOIN employees AS e ON e.store_id = s.id
WHERE e.salary < 4000 AND a.`name` LIKE "%5%" AND char_length(s.`name`) > 8 AND RIGHT(e.last_name,1) = 'n' ;