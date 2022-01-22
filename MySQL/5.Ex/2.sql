CREATE TABLE `manufacturers`(
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL,
`established_on` DATE
);

INSERT INTO `manufacturers`(`name`,`established_on`)
VALUES 
('BMW','19160301'),
('Tesla','20030101'),
('Lada','19660501');

CREATE TABLE `models`(
`model_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (20) NOT NULL,
`manufacturer_id` INT,
CONSTRAINT fk_models_manufacturers
FOREIGN KEY (manufacturer_id)
REFERENCES manufacturers(manufacturer_id)
)AUTO_INCREMENT =101;

INSERT INTO `models`(`name`,`manufacturer_id`)
VALUES 
('X1','1'),
('i6','1'),
('Model S','2'),
('Model X','2'),
('Model 3','2'),
('Nova','3');
