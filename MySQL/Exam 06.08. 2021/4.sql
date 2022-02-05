DELETE 
FROM games 
WHERE id NOT IN (SELECT game_id FROM games_categories)
AND release_date IS NULL;
