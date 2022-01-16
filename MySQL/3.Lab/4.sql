SELECT concat_ws(' ',first_name,last_name) ,
timestampdiff(day,`born`,`died`) as 'Days Lived'
FROM authors;