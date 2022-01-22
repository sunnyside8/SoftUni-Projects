CREATE TABLE passports(
`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
`passport_number` VARCHAR(20) UNIQUE
)AUTO_INCREMENT = 101;

INSERT INTO `passports` (`passport_number`)
VALUES 
('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

CREATE TABLE `people` (
`person_id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(20),
`salary` DECIMAL(10,2),
`passport_id` INT UNIQUE,
CONSTRAINT `fk_people_passports`
FOREIGN KEY (`passport_id`)
REFERENCES passports(`passport_id`)
);

INSERT INTO `people` 
VALUES 
(1,'Roberto',43300.00,102),
(2,'Tom',56100.00,103),
(3,'Yana',60200.00,101);