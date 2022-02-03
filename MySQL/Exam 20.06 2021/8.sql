SELECT DISTINCT cl.full_name,
(SELECT count(cour2.car_id) FROM courses AS cour2 where cour2.client_id = cl.id ) AS 'count_of_cars',
(SELECT SUM(cour3.bill) FROM courses AS cour3 WHERE cour3.client_id = cl.id) AS 'total_sum'
FROM courses AS c 
JOIN clients AS cl on c.client_id = cl.id
HAVING count_of_cars > 1 AND cl.full_name LIKE "_a%"
ORDER BY cl.full_name;
