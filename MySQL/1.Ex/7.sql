CREATE SCHEMA `users`;
USE `users`;

CREATE TABLE `users`(
`id`INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30),
`password` VARCHAR(30),
`profile_picture` BLOB,
`last_login_time` DATETIME DEFAULT NOW(),
`is_deleted` BOOLEAN DEFAULT 1
);

INSERT INTO `users` (`username`,`password`,`profile_picture`)
VALUES
('sunny','fifo14',null),
('pipi','pipo14',null),
('shishi','shisho14',null),
('gerald','ciri14',null),
('yenifer','triss14',null);
