SELECT COUNT(*) FROM employees AS emp
WHERE salary > (SELECT AVG(salary) from employees);