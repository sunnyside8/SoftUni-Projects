CREATE TABLE pictures(
id INT PRIMARY KEY AUTO_INCREMENT,
url VARCHAR (100) NOT NULL,
added_on DATETIME NOT NULL
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL unique
);

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(40) NOT NULL unique,
best_before DATE,
price DECIMAL(10,2) NOT NULL,
`description` TEXT,
category_id INT NOT NULL,
picture_id INT NOT NULL,
CONSTRAINT fk_products_categories
foreign key (category_id)
references categories(id),
CONSTRAINT fk_products_picturs
FOREIGN KEY (picture_id)
REFERENCES pictures(id)
);

CREATE TABLE towns(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL unique
);

CREATE TABLE addresses(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL unique,
town_id INT NOT NULL,
CONSTRAINT fk_addresses_towns
FOREIGN KEY (town_id)
REFERENCES towns(id)
);

CREATE TABLE stores(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(20) NOT NULL unique,
rating FLOAT NOT NULL,
has_parking TINYINT (1),
address_id INT NOT NULL,
CONSTRAINT fk_stores_addresses
FOREIGN KEY (address_id)
REFERENCES addresses(id)
);

CREATE TABLE products_stores(
product_id INT NOT NULL,
store_id INT NOT NULL,
CONSTRAINT pk_product_store
PRIMARY KEY(product_id,store_id),
CONSTRAINT fk_products_stores_products
FOREIGN KEY(product_id)
REFERENCES products(id),
CONSTRAINT fk_products_stores_stores
FOREIGN KEY (store_id)
REFERENCES stores(id)
);


CREATE TABLE employees(
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(15) NOT NULL,
middle_name CHAR(1),
last_name VARCHAR(20) NOT NULL,
salary DECIMAL(19,2) NOT NULL DEFAULT(0),
hire_date DATE,
manager_id INT,
store_id INT NOT NULL,
CONSTRAINT fk_employees_employees
FOREIGN KEY (manager_id)
REFERENCES employees(id),
CONSTRAINT fk_employees_stores
FOREIGN KEY (store_id)
REFERENCES stores(id)
);