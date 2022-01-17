SELECT town_id,`name` 
FROM `towns`
WHERE LEFT(`name`,1) NOT IN('r','B','D')
ORDER BY `name`;