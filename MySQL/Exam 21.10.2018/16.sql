DELIMITER %%
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11)) 
BEGIN
DECLARE specialty CONDITION FOR SQLSTATE '45000';
START TRANSACTION;

IF((SELECT COUNT(*) FROM  spaceships WHERE `name` = spaceship_name) = 0) THEN
SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.', MYSQL_ERRNO = 1001;
ROLLBACK;

ELSE

UPDATE spaceships SET light_speed_rate = light_speed_rate + light_speed_rate_increse
WHERE `name` = spaceship_name;

END IF;
END %%
DELIMITER ;


