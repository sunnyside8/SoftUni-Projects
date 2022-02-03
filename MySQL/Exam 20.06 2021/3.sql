UPDATE cars
SET `condition` = 'C'
WHERE  mileage >= 800000 OR mileage IS NULL 
AND CAST(`year` AS UNSIGNED) AND make != 'Mercedes-Benz';
