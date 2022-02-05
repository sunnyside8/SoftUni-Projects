SELECT DISTINCT c.`name`,
(SELECT COUNT(*) FROM games_categories AS gc3 WHERE c.id = gc3.category_id)AS 'games_count',
ROUND((SELECT AVG(g2.budget) 
FROM games AS g2
 LEFT JOIN games_categories AS gc2 ON g2.id = gc2.game_id 
 LEFT JOIN categories AS c2 ON c2.id = gc2.category_id where c2.id = c.id ),2) 
 AS 'avg_budget',
ROUND((SELECT rating 
FROM games AS g2
 LEFT JOIN games_categories AS gc2 ON g2.id = gc2.game_id 
 LEFT JOIN categories AS c2 ON c2.id = gc2.category_id where c2.id = c.id
 ORDER BY rating desc limit 1),1) AS 'max_rating'
FROM categories AS c 
LEFT JOIN  games_categories AS gc ON c.id = gc.game_id
LEFT JOIN games AS g ON g.id = gc.game_id
HAVING max_rating >= 9.5
ORDER BY games_count DESC,c.name
;