SELECT g.`name`,
 IF(g.budget < 50000,'Normal budget','Insufficient budget') AS 'budget_level',
t.`name`,
a.`name`
FROM games_categories AS gc
Right JOIN games AS g ON gc.game_id = g.id
 JOIN teams AS t ON g.team_id = t.id
JOIN offices AS o ON t.office_id = o.id
 JOIN addresses AS a ON o.address_id = a.id
WHERE release_date IS NULL AND category_id IS NULL
ORDER BY g.`name`;