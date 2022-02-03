DELIMITER %%
CREATE PROCEDURE `udp_courses_by_address` (address_name VARCHAR (100))
DETERMINISTIC
BEGIN
SELECT a.`name`,
cl.full_name,
(CASE 
WHEN cou.bill <= 20 THEN 'Low'
WHEN cou.bill <= 30 THEN 'Medium'
ELSE 'High'
END)AS 'level_of_bill',
ca.make,
ca.`condition`,
cat.`name`
FROM  addresses as a 
JOIN courses AS cou on a.id = cou.from_address_id
JOIN cars AS ca on ca.id = cou.car_id
left JOIN categories AS cat ON cat.id = ca.category_id 
JOIN clients AS cl ON cl.id = cou.client_id
WHERE a.`name` = address_name
order by ca.make,cl.full_name;
END %%
DELIMITER ;

CALL udp_courses_by_address('66 Thompson Drive');
