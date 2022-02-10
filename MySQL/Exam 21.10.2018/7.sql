SELECT c.id,concat(c.first_name,' ',c.last_name) AS 'full_name'
FROM colonists AS c
JOIN travel_cards AS tc on c.id = tc.colonist_id
WHERE job_during_journey = 'Pilot'
ORDER BY c.id;