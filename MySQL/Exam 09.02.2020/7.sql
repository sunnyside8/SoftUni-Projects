SELECT t.`name`,t.established,t.fan_base,
(SELECT COUNT(*) FROM players WHERE team_id = t.id) AS 'players_count'
FROM teams AS t
ORDER BY players_count DESC,fan_base DESC;