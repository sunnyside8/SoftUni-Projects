SELECT town_id,`name` FROM towns
WHERE left(`name`,1) IN ('M','K','B','E')
ORDER BY `name`;