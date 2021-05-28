INSERT INTO client (name)
	SELECT 'Gaspar'
	WHERE NOT EXISTS (SELECT * FROM client);


set @books = NOT EXISTS (SELECT id FROM client limit 1);

INSERT INTO book (status, title, last_rent_date, client_id) VALUES
	(0, 'The Hobbit', CURRENT_DATE, (SELECT id FROM client limit 1)),
	(0, 'The Hobbit 2', CURRENT_DATE, (SELECT id FROM client limit 1)),
	(0, 'The Hobbit 3', CURRENT_DATE, (SELECT id FROM client limit 1)),
	(0, 'Matrix', CURRENT_DATE, (SELECT id FROM client limit 1)),
	(0, 'Dallas Buyers Club', CURRENT_DATE, (SELECT id FROM client limit 1));