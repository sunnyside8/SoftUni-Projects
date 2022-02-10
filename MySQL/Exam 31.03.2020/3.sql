UPDATE addresses 
SET country = 
(CASE LEFT(country,1)
WHEN 'B' THEN 'Blocked'
WHEN 'T' THEN 'Test'
WHEN  'P' THEN 'In Progress'
END
)
WHERE LEFT(country,1) IN('B','T','P');
