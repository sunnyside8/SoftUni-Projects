DELIMITER %%

CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50)) 
RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
RETURN (SELECT CONCAT(
e.first_name,' ',e.middle_name,'. ',e.last_name,' ',
'works in store for ',
2020 - cast(YEAR(hire_date) AS UNSIGNED),' ',
'years'
)
FROM employees AS e 
JOIN stores AS s ON e.store_id = s.id
WHERE s.`name` = store_name
ORDER BY salary DESC
LIMIT 1);
END%%

DELIMITER ;

SELECT udf_top_paid_employee_by_store('Stronghold')udf_top_paid_employee_by_store;
