SELECT REPLACE (title,'The','***') 
FROM books
WHERE SUBSTRING(title,1,3) = 'The'
ORDER BY id;