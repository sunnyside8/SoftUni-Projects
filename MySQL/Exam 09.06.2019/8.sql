SELECT concat_ws(' ',first_name,last_name) AS 'name',
started_on,
(SELECT COUNT(*) 
FROM employees_clients
WHERE employee_id = id
GROUP BY employee_id) AS 'count_of_clients'
from employees
ORDER BY count_of_clients DESC,id
LIMIT 5;