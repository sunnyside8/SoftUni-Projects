INSERT INTO travel_cards(card_number,job_during_journey,journey_id,colonist_id)
SELECT 
IF(birth_date > '1980-01-01',concat(YEAR(birth_date),DAY(birth_date),lEFT(ucn,4)),concat(YEAR(birth_date),MONTH(birth_date),Right(ucn,4))),
(CASE
WHEN id % 2 = 0 THEN 'Pilot'
WHEN id % 3 = 0 THEN 'Cook'
ELSE 'Engineer'
END ),LEFT(ucn,1),id
FROM colonists
WHERE id BETWEEN 96 AND 100;