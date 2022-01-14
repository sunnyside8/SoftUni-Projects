CREATE SCHEMA `soft_uni`;
CREATE TABLE `towns`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`address_text` VARCHAR(100) NOT NULL,
`town_id` INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY(`town_id`) 
REFERENCES `towns`(`id`)
);

create table `departments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` varchar(20) not null
);

DROP TABLE `employees`;

create table `employees`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` varchar(30) not null,
`middle_name` varchar(30) not null,
`last_name` varchar(30) not null,
`job_title` varchar(20) not null,
`department_id` int,
`hire_date` date,
`salary` int,
`address_id`INT,
constraint fk_employees_departments
foreign key(`department_id`) references `departments` (`id`),
constraint fk_employees_addresses
foreign key(`address_id`) references `addresses` (`id`)
);

INSERT INTO `towns`(`name`)
VALUES 
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO `departments`(`name`)
VALUES 
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO `employees`
VALUES
(1,'Ivan','Ivanov','Ivanov','.NET Developer',4,"2013-02-01,",3500.00,NULL),
(2,'Petar','Petrov','Petrov','Senior Engineer',1,"2004-03-02,",4000.00,NULL),
(3,'Maria','Petrova','Ivanova','Intern',5,"2016-08-28,",525.25,NULL),
(4,'Georgi','Terziev','Ivanov','CEO',2,"2007-12-09,",3000.00,NULL),
(5,'Peter','Pan','Pan','Intern',3,"2016-08-28,",599.88,NULL);


