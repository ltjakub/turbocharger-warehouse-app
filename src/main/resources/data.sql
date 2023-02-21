INSERT INTO company (id, name)
VALUES ('993ccd82-8e52-4cf8-b140-fd32ce5cdb59', 'company 1');

INSERT INTO part (id, name, serial_no, company_id, quantity)
VALUES ('a0176d96-aeb5-11ed-afa1-0242ac120002',
        'TW', 'JWDP5G', '993ccd82-8e52-4cf8-b140-fd32ce5cdb59', 5);
INSERT INTO address(id, city, state, street, zip)
VALUES ('6fcab65e-af76-11ed-afa1-0242ac120002', 'Olesnica', 'Dolnoslaskie', 'Klonowa', '56-400');
INSERT INTO client (id, email, address_id, company_id)
VALUES ('ad1353fe-af76-11ed-afa1-0242ac120002', 'klient@klient.com', '6fcab65e-af76-11ed-afa1-0242ac120002', '993ccd82-8e52-4cf8-b140-fd32ce5cdb59')