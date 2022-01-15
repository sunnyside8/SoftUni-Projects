CREATE SCHEMA `car_rental`;

CREATE TABLE `categories`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(50) NOT NULL,
    `daily_rate` FLOAT,
    `weekly_rate` FLOAT,
    `monthly_rate` FLOAT,
    `weekend_rate` FLOAT
);

INSERT INTO `categories`
VALUES
(1,'CATEGORY',12.5,20.5,45.5,100.5),
(2,'CATEGORY',12.5,20.5,45.5,100.5),
(3,'CATEGORY',12.5,20.5,45.5,100.5);

CREATE TABLE `cars`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `plate_number` VARCHAR(10) NOT NULL,
    `make` VARCHAR(30) NOT NULL,
    `model` VARCHAR(30) NOT NULL,
    `car_year` YEAR NOT NULL,
    `category_id` INT,
    `doors` INT NOT NULL,
    `picture` BLOB,
    `car_condition` VARCHAR(70),
    `available` BOOLEAN
);

INSERT INTO `cars`
VALUES
(1,'CH1757AC','MAKER','C-CLASS',1995,1,5,NULL,'USED',0),
(2,'CH1757AC','MAKER','C-CLASS',1995,1,5,NULL,'USED',0),
(3,'CH1757AC','MAKER','C-CLASS',1995,1,5,NULL,'USED',0);

CREATE TABLE `employees`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO `employees`
VALUES
(1,'SUNNY','SIDE','MANAGER',NULL),
(2,'SUNNY','SIDE','MANAGER',NULL),
(3,'SUNNY','SIDE','MANAGER',NULL);

CREATE TABLE `customers`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `driver_licence_number` INT NOT NULL,
    `full_name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(200) NOT NULL,
    `city` VARCHAR(30) NOT NULL,
    `zip_code` INT ,
    `notes` TEXT
);

INSERT INTO `customers`
VALUES
(1,234567,'CLOUDY CLOUD','SOMEWHERE OUT THERE','SLIVEN',8800,NULL),
(2,234567,'CLOUDY CLOUD','SOMEWHERE OUT THERE','SLIVEN',8800,NULL),
(3,234567,'CLOUDY CLOUD','SOMEWHERE OUT THERE','SLIVEN',8800,NULL);

CREATE TABLE `rental_orders`(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT NOT NULL,
    `customer_id` INT NOT NULL,
    `car_id` INT NOT NULL,
    `car_condition` VARCHAR(70),
    `tank_level` INT NOT NULL,
    `kilometrage_start` FLOAT NOT NULL,
    `kilometrage_end` FLOAT NOT NULL,
    `total_kilometrage` FLOAT NOT NULL,
    `start_date` DATE ,
    `end_date` DATE,
    `total_days` INT NOT NULL,
    `rate_applied` FLOAT NOT NULL,
    `tax_rate` FLOAT NOT NULL,
    `order_status` BOOLEAN,
    `notes` TEXT
);

INSERT INTO `rental_orders`
VALUES
(1,2,1,1,'USED',10,123.12,153.12,30.0,'2007-07-08','2021-12-08',70,245.5,50.1,0,NULL),
(2,2,1,1,'USED',10,123.12,153.12,30.0,'2007-07-08','2021-12-08',70,245.5,50.1,0,NULL),
(3,2,1,1,'USED',10,123.12,153.12,30.0,'2007-07-08','2021-12-08',70,245.5,50.1,0,NULL);



