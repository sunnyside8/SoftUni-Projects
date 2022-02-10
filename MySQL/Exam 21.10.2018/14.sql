SELECT tc.`job_during_journey`
FROM journeys AS j 
JOIN travel_cards as tc ON tc.journey_id = j.id
WHERE j.id = (SELECT j1.id FROM journeys as j1
ORDER BY DATEDIFF(j1.journey_end,j1.journey_start) DESC
LIMIT 1)
GROUP BY job_during_journey
LIMIT 1
;