CREATE VIEW `v_top_paid` AS
SELECT * FROM employees
ORDER BY salary DESC
LIMIT 1; 

SELECT * FROM `v_top_paid`;