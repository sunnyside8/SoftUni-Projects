INSERT INTO reviews (content,picture_url,published_at,rating)
SELECT LEFT(`description`,15),reverse(`name`),'2020-10-10',price/8
FROM products 
WHERE id >= 5;