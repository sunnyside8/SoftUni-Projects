UPDATE employees
SET manager_id = '3' ,salary = salary - 500
WHERE YEAR(hire_date)> 2003 and store_id NOT IN (14,5);