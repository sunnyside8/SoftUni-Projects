SELECT  id, concat_ws(' ',first_name,last_name) AS 'Full name',job_title,salary
FROM employees
WHERE salary>1000
ORDER BY id ASC;