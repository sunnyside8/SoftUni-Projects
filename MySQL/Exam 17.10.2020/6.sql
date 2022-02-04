SELECT pr.name,
pr.price ,
pr.best_before,
CONCAT(LEFT(pr.`description`,10),'...') AS 'short_description',
pic.url 
FROM products AS pr
JOIN pictures AS pic ON pr.picture_id = pic.id
WHERE char_length(pr.`description`) > 100 AND YEAR(added_on) < 2019
AND pr.price > 20
ORDER BY pr.price DESC;