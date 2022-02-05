SELECT g.`name`,
g.release_date,
CONCAT(LEFT(`description`,10),'...') AS 'summary',
(CASE
WHEN MONTH(g.release_date) < 4 THEN 'Q1'
WHEN MONTH(g.release_date) < 7 THEN 'Q2'
WHEN MONTH(g.release_date) < 10 THEN 'Q3'
ELSE 'Q4'
END 
)AS 'quarter',
t.`name`
 FROM games AS g
 LEFT JOIN teams AS t ON g.team_id = t.id
 WHERE YEAR(g.release_date) = 2022  AND 
 CAST(MONTH(g.release_date) AS UNSIGNED) % 2 = 0
 AND RIGHT(g.name,1) = '2'
 ORDER BY `quarter`;