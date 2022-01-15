CREATE TABLE `directors`(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `directors` (`director_name`)
VALUES 
('Sunny'),
('Windy'),
('Iva'),
('Svetlio'),
('Watts');
 
 
CREATE TABLE `genres`(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `genres`(`genre_name`)
VALUE
('Action'),
('Comedy'),
('Criminal'),
('Drama'),
('Adventure');

 
 
CREATE TABLE `categories` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `categories` (`category_name`)
VALUE

('R'),
('PG'),
('PG-13'),
('NR'),
('G');
 
 
CREATE TABLE `movies`(
`id` INT PRIMARY KEY  AUTO_INCREMENT,
`title` VARCHAR(50) NOT NULL,
`director_id` INT,
`copyright_year` INT NOT NULL,
`length` INT NOT NULL,
`genre_id` INT,
`category_id` INT,
`rating` FLOAT,
`notes` TEXT
);
 
INSERT INTO `movies`
VALUE
(1, 'Movie', 1, 2021, 123, 2, 1, 7.5, 'text'),
(2, 'Movie', 1, 2021, 123, 2, 1, 7.5, 'text'),
(3, 'Movie', 1, 2021, 123, 2, 1, 7.5, 'text'),
(4, 'Movie', 1, 2021, 123, 2, 1, 7.5, 'text'),
(5, 'Movie', 1, 2021, 123, 2, 1, 7.5, 'text');