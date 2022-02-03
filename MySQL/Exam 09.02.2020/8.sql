SELECT MAX(sk.speed) AS 'max_speed',tw.name 
FROM towns AS tw 
JOIN stadiums AS s ON tw.id = s.town_id
LEFT JOIN teams AS t ON s.id = t.stadium_id
LEFT JOIN players AS p ON t.id = p.team_id
LEFT JOIN skills_data AS sk ON p.skills_data_id = sk.id
WHERE t.`name` != 'Devify'
GROUP BY  tw.`name`
ORDER BY max_speed DESC,tw.`name`;