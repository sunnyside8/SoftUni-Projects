SELECT p.id,
p.`date` AS 'date_and_time',
p.`description`,
(SELECT COUNT(*) FROM comments WHERE photo_id = p.id) AS'commentsCount'
FROM photos AS p
ORDER BY commentsCount DESC,p.id
LIMIT 5;
