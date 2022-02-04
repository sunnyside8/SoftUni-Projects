SELECT s.`name`,
(SELECT COUNT(product_id) FROM products_stores AS ps2 WHERE ps.store_id = ps2.store_id)AS 'product_count',
(SELECT ROUND(AVG(price),2) FROM products_stores AS ps3 JOIN products AS p2 ON p2.id = ps3.product_id WHERE ps3.store_id = ps.store_id) AS 'avg'
FROM products AS pr
JOIN products_stores AS ps ON pr.id = ps.product_id
RIGHT JOIN stores AS s ON ps.store_id = s.id
GROUP BY s.`name`
ORDER BY product_count DESC,`avg` DESC,s.id ;