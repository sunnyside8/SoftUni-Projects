SELECT COUNT(tc.colonist_id) AS 'count'
FROM travel_cards AS tc JOIN journeys AS j ON tc.journey_id = j.id
WHERE j.purpose = 'Technical';