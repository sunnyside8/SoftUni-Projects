DELIMITER %%
CREATE PROCEDURE `udp_find_playmaker`(min_dribble_points INT ,team_name VARCHAR(45))
DETERMINISTIC
BEGIN
SELECT concat_ws(' ',first_name,last_name) AS 'full_name',
 age, salary, dribbling, speed,t.`name`
FROM players AS p
JOIN skills_data AS sd ON p.skills_data_id = sd.id
JOIN teams AS t ON p.team_id = t.id
WHERE (t.`name` = team_name) and 
speed > (SELECT AVG(speed) from skills_data)
AND dribbling > min_dribble_points
ORDER BY speed DESC 
LIMIT 1;
END %%
DELIMITER ;

CALL udp_find_playmaker (20, 'Skyble');