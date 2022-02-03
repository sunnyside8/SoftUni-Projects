SELECT a.`name`, 
(CASE
WHEN HOUR(`start`) BETWEEN 6 AND 20 THEN 'Day'
ELSE 'Night'
END) AS 'day_time',
cou.bill,
cl.full_name,
ca.make,
ca.model,
cat.`name`
FROM  addresses as a 
JOIN courses AS cou on a.id = cou.from_address_id
JOIN cars AS ca on ca.id = cou.car_id
left JOIN categories AS cat ON cat.id = ca.category_id 
JOIN clients AS cl ON cl.id = cou.client_id
ORDER BY cou.id;