DELIMITER  %%
CREATE PROCEDURE udp_modify_user(p_address VARCHAR(30), p_town VARCHAR(30))
DETERMINISTIC
BEGIN
UPDATE users AS u
JOIN addresses AS a ON a.user_id = u.id
SET age = age +10
WHERE a.town = p_town
AND a.address = p_address;
END %%
DELIMITER ;

CALL udp_modify_user ('97 Valley Edge Parkway', 'Divinópolis');
SELECT u.username, u.email,u.gender,u.age,u.job_title FROM users AS u
WHERE u.username = 'eblagden21';
