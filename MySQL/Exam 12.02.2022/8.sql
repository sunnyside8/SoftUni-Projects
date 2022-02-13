SELECT 
concat(c.first_name,' ',c.last_name) AS 'full_name',
c.address,o.order_datetime
FROM orders AS o 
JOIN customers AS c ON o.customer_id = c.id
WHERE YEAR(order_datetime) <= 2018
ORDER BY full_name DESC; 