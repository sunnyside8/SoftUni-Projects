SELECT sp.`name`,sp.`manufacturer`
FROM spaceships AS sp 
join journeys AS j ON j.spaceship_id = sp.id
join travel_cards AS tc ON tc.journey_id = j.id
join colonists AS c ON tc.colonist_id = c.id
WHERE (2019 - year(c.birth_date)) < 30 
GROUP BY sp.`name`
ORDER BY sp.`name`;