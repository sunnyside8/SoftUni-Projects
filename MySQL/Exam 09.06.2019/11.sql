DELIMITER %%
CREATE PROCEDURE `udp_clientinfo`( full_name VARCHAR(50))
BEGIN
SELECT c.full_name,
c.age,
ba.account_number,
concat('$', ba.balance) AS 'balance'
FROM  bank_accounts AS ba 
right JOIN clients AS c ON ba.client_id = c.id
WHERE c.full_name = full_name;
END%%
DELIMITER ;

CALL udp_clientinfo('Hunter Wesgate');
