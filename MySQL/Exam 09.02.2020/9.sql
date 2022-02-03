SELECT c.`name`,
COUNT(p.id) AS 'total_count_of_players',
SUM(p.salary) AS 'total_sum_of_salaries'
FROM countries AS c
LEFT JOIN towns AS tw ON c.id = tw.country_id
LEFT JOIN stadiums AS s ON tw.id = s.town_id
LEFT JOIN teams AS t ON s.id = t.stadium_id
LEFT JOIN players AS p ON t.id = p.team_id
GROUP BY c.`name`
order by total_count_of_players DESC,c.name;