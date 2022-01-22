SELECT m.`mountain_range`,p.`peak_name`,p.`elevation`
FROM mountains AS m
JOIN peaks AS p ON p.mountain_id = m.id AND mountain_id=17
ORDER BY p.elevation DESC;