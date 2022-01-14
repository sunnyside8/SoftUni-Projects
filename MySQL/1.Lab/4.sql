ALTER TABLE `products` 
ADD CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
 REFERENCES `categories`(`id`); 
