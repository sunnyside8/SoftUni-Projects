SELECT e.employee_id,concat(e.first_name,' ',e.last_name),
d.department_id,d.name
FROM departments AS d
LEFT JOIN employees AS e 
ON d.manager_id = e.employee_id
ORDER BY e.employee_id 
LIMIT 5;
