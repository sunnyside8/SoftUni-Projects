SELECT p.`name`,
(SELECT COUNT(*) 
FROM planets AS p2 
JOIN spaceports AS s2 ON s2.planet_id = p2.id
JOIN journeys AS j2 ON j2.destination_spaceport_id = s2.id
WHERE p2.id = p.id 
) AS 'journeys_count'
FROM planets AS p 
JOIN spaceports AS s ON s.planet_id = p.id
JOIN journeys AS j ON j.destination_spaceport_id = s.id
GROUP BY p.`name`
ORDER BY journeys_count DESC,p.`name`;