SELECT j.id,
p.`name`,
s.`name`,
j.purpose
FROM planets AS p 
JOIN spaceports AS s ON s.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = s.id
ORDER BY DATEDIFF(j.journey_end,j.journey_start)
LIMIT 1;
