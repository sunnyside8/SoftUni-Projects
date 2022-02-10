SELECT sp.`name`,s.`name`
 FROM spaceships AS sp JOIN journeys AS j ON 	j.spaceship_id = sp.id
JOIN spaceports AS s ON j.destination_spaceport_id = s.id
ORDER BY light_speed_rate DESC
LIMIT 1
;