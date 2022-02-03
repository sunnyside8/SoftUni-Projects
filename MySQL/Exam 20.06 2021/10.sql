DELIMITER %%
CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(cou.client_id) FROM clients AS cl
JOIN courses AS cou ON cou.client_id = cl.id
WHERE phone_number = phone_num);
END %%
DELIMITER ;

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 