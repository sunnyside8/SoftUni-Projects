SELECT t.`name` AS 'team_name',
a.name AS 'address_name',
char_length(a.`name`) AS 'count_of_characters'
FROM teams AS t
JOIN offices AS o ON t.office_id = o.id
JOIN addresses AS a ON o.address_id = a.id
where website IS NOT NULL
ORDER BY team_name,address_name;