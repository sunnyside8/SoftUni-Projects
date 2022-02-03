SELECT DISTINCT ca.id,ca.make,ca.mileage,
(select count(*) FROM courses AS cour2 WHERE  cour2.car_id = ca.id) AS 'count_of_courses',
ROUND((SELECT AVG(bill) FROM courses AS cour2 WHERE  cour2.car_id = ca.id),2) AS 'avg_bill'
FROM courses AS cour
RIGHT JOIN cars AS ca on cour.car_id = ca.id
HAVING count_of_courses  != 2
ORDER BY count_of_courses DESC,ca.id;
