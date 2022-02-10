SELECT p.id,
(SELECT COUNT(*) FROM likes AS l1 WHERE l.photo_id = l1.photo_id ) AS 'likes_count',
(SELECT COUNT(*) FROM comments AS c1 WHERE c.photo_id = c1.photo_id ) AS'comments_count'
FROM likes AS l 
RIGHT JOIN photos AS p on l.photo_id = p.id
LEFT JOIN comments AS c on p.id = c.photo_id
GROUP BY  p.id
ORDER BY likes_count DESC,comments_count DESC,p.id;

