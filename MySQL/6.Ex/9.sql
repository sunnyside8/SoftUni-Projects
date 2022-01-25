SELECT e.employee_id,e.first_name,e.manager_id,e1.first_name AS 'manager_name'
FROM employees AS e 
JOIN employees AS e1 ON e.manager_id = e1.employee_id
WHERE e.manager_id IN (3,7)
ORDER BY e.first_name;
