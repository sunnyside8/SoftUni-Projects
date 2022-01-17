SELECT `name`,DATE_FORMAT(`start`, '%Y-%m-%d')
FROM `games`
WHERE YEAR(`start`) IN (2011,2012)
ORDER by `start`,`name`
LIMIT 50;
