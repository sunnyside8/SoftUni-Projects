SELECT cr.id,
concat(cr.card_number,' : ',cl.full_name) AS 'card_token'
FROM cards AS cr 
JOIN bank_accounts AS ba ON cr.bank_account_id = ba.id
JOIN clients AS cl ON cl.id = ba.client_id
ORDER BY cr.id DESC;