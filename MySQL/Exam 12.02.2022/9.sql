SELECT COUNT(*) AS 'items_count',c.`name`,
(SELECT SUM(quantity_in_stock) FROM products AS p1 WHERE p1.category_id = c.id) AS 'total_quantity'
FROM products AS p 
JOIN categories AS c ON p.category_id = c.id
GROUP BY category_id
ORDER BY items_count DESC,total_quantity
LIMIT 5;