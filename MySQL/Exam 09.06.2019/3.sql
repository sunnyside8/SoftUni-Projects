UPDATE employees_clients AS ec
SET ec.employee_id = 10
WHERE ec.employee_id = ec.client_id;