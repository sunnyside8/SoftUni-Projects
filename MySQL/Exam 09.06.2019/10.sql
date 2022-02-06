DELIMITER %%
CREATE FUNCTION udf_client_cards_count(`name` VARCHAR(30)) 
RETURNS INTEGER
DETERMINISTIC
BEGIN
RETURN (SELECT COUNT(*)
FROM cards AS cr
right JOIN bank_accounts AS ba ON cr.bank_account_id = ba.id 
right JOIN clients AS c ON ba.client_id = c.id
WHERE c.full_name = `name`
GROUP BY c.id);
END%%

DELIMITER ;
