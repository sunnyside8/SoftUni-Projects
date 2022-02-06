INSERT INTO cards (card_number,card_status,bank_account_id )
SELECT reverse(full_name),'Active',id
FROM clients
WHERE id between 191 AND 200;