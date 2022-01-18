SELECT category_id,
Round(AVG(price),2)AS 'Average Price',
Round(MIN(price),2) AS 'Cheapest Product',
Round(MAX(price),2) AS 'Most Expensive Product'
FROM products
GROUP BY category_id;