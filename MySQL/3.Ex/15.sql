SELECT 
    `name`,
    (CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END) AS 'Part of the Day',
    (
    CASE
    WHEN `duration` < 4 THEN 'Extra Short'
    WHEN `duration` < 7 THEN 'Short'
    WHEN `duration` < 11 THEN 'Long'
   ELSE 'Extra Long'
    END
    )
    AS 'Duration'
FROM
    `games`;