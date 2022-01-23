SELECT t.town_id,t.name AS town_name,a.address_text
FROM  addresses AS a
JOIN towns AS t ON t.town_id IN (9,32,15)
AND 
 a.town_id = t.town_id
 ORDER BY t.town_id,a.address_text;