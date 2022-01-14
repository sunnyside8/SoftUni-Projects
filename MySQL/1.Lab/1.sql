CREATE TABLE `employees`(
`id` INT PRIMARY KEY  AUTO_INCREMENT,
`first_name` VARCHAR(30) NOT NULL,
`last_name` VARCHAR(30) NOT NULL
);

create table categories(
id int primary key auto_increment,
name VARCHAR(40) NOT NULL
);

CREATE TABLE `products`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL,
`category_id` INT
);