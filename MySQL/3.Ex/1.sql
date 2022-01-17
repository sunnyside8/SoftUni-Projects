SELECT first_name,last_name 
FROM employees 
WHERE substring(first_name,1,2) = 'Sa'
ORDER BY employee_id;