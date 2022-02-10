DELIMITER %%
CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(planet_id)  
FROM colonists AS cl 
 JOIN travel_cards AS tc ON tc.colonist_id = cl.id
 JOIN journeys AS j ON tc.journey_id = j.id
 JOIN spaceports AS s ON j.destination_spaceport_id = s.id
 JOIN planets AS p ON p.id = s.planet_id
 where p.`name` = planet_name
 GROUP BY planet_id);
END %%
DELIMITER ;

SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.`name` = 'Otroyphus';

