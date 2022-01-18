SELECT department_id,min(salary) AS 'Min salary'
FROM employees
GROUP BY department_id
HAVING `Min salary` > 800;