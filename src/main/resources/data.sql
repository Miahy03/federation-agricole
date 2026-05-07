DELETE FROM attendance;
DELETE FROM activity;
DELETE FROM payments;
DELETE FROM members;
DELETE FROM collectivities;

INSERT INTO collectivities (id, numero, nom, localite, specialite, datecreation, statut) VALUES
('col-1', '1', 'Mpanorina', 'Ambatondrazaka', 'Riziculture', '2026-01-01', 'ACTIVE'),
('col-2', '2', 'Dobo voalohany', 'Ambatondrazaka', 'Pisciculture', '2026-01-01', 'ACTIVE'),
('col-3', '3', 'Tantely mamy', 'Brickaville', 'Apiculture', '2026-01-01', 'ACTIVE');

INSERT INTO members (id, nom, prenom, datenaissance, dateadhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
(1, 'Nom membre 1', 'Prenom 1', '1980-02-01', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0341234567', 'm1@mail.com', 'PRESIDENT', 'col-1'),
(2, 'Nom membre 2', 'Prenom 2', '1982-03-05', '2026-01-01', 'M', 'Ambato', 'Agriculteur', '0321234567', 'm2@mail.com', 'VICE_PRESIDENT', 'col-1'),
(3, 'Nom membre 3', 'Prenom 3', '1992-03-10', '2026-01-01', 'M', 'Ambato', 'Collecteur', '0331234567', 'm3@mail.com', 'SECRETARY', 'col-1'),
(4, 'Nom membre 4', 'Prenom 4', '1988-05-22', '2026-01-01', 'F', 'Ambato', 'Distributeur', '0381234567', 'm4@mail.com', 'TREASURER', 'col-1'),
(5, 'Nom membre 5', 'Prenom 5', '1999-08-21', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0373434567', 'm5@mail.com', 'CONFIRMED_MEMBER', 'col-1'),
(6, 'Nom membre 6', 'Prenom 6', '1998-08-22', '2026-01-01', 'F', 'Ambato', 'Riziculteur', '0372234567', 'm6@mail.com', 'CONFIRMED_MEMBER', 'col-1'),
(7, 'Nom membre 7', 'Prenom 7', '1998-01-31', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0374234567', 'm7@mail.com', 'CONFIRMED_MEMBER', 'col-1'),
(8, 'Nom membre 8', 'Prenom 8', '1975-08-20', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0370234567', 'm8@mail.com', 'CONFIRMED_MEMBER', 'col-1'),

(9, 'Nom membre 9', 'Prenom 9', '1980-02-01', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0341234567', 'm9@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(10, 'Nom membre 10', 'Prenom 10', '1982-03-05', '2026-01-01', 'M', 'Ambato', 'Agriculteur', '0321234567', 'm10@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(11, 'Nom membre 11', 'Prenom 11', '1992-03-10', '2026-01-01', 'M', 'Ambato', 'Collecteur', '0331234567', 'm11@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(12, 'Nom membre 12', 'Prenom 12', '1988-05-22', '2026-01-01', 'F', 'Ambato', 'Distributeur', '0381234567', 'm12@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(13, 'Nom membre 13', 'Prenom 13', '1999-08-21', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0373434567', 'm13@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(14, 'Nom membre 14', 'Prenom 14', '1998-08-22', '2026-01-01', 'F', 'Ambato', 'Riziculteur', '0372234567', 'm14@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(15, 'Nom membre 15', 'Prenom 15', '1998-01-31', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0374234567', 'm15@mail.com', 'CONFIRMED_MEMBER', 'col-2'),
(16, 'Nom membre 16', 'Prenom 16', '1975-08-20', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0370234567', 'm16@mail.com', 'CONFIRMED_MEMBER', 'col-2'),

(17, 'Nom membre 17', 'Prenom 17', '1980-02-01', '2026-01-01', 'M', 'Ambato', 'Apiculteur', '0341234567', 'm17@mail.com', 'CONFIRMED_MEMBER', 'col-3'),
(18, 'Nom membre 18', 'Prenom 18', '1982-03-05', '2026-01-01', 'M', 'Ambato', 'Agriculteur', '0321234567', 'm18@mail.com', 'CONFIRMED_MEMBER', 'col-3'),
(19, 'Nom membre 19', 'Prenom 19', '1992-03-10', '2026-01-01', 'M', 'Ambato', 'Collecteur', '0331234567', 'm19@mail.com', 'CONFIRMED_MEMBER', 'col-3'),
(20, 'Nom membre 20', 'Prenom 20', '1988-05-22', '2026-01-01', 'F', 'Ambato', 'Distributeur', '0381234567', 'm20@mail.com', 'CONFIRMED_MEMBER', 'col-3');

INSERT INTO activity (date, name) VALUES
('2026-03-01', 'act-1'),
('2026-04-14', 'act-2'),
('2026-03-01', 'act-3'),
('2026-03-21', 'act-4'),
('2026-04-30', 'act-5'),
('2026-03-06', 'act-6'),
('2026-03-25', 'act-7');

INSERT INTO attendance (id, present, activity_id, member_id) VALUES
(1, true, 1, 1),(2, true, 1, 2),(3, true, 1, 3),(4, true, 1, 4),(5, true, 1, 5),(6, true, 1, 6),(7, false, 1, 7),(8, false, 1, 8),

(9, true, 2, 1),(10, true, 2, 2),(11, false, 2, 3),(12, false, 2, 4),(13, true, 2, 5),(14, true, 2, 6),(15, true, 2, 7),(16, true, 2, 8),

(17, true, 3, 9),(18, true, 3, 10),(19, false, 3, 11),(20, false, 3, 12),(21, true, 3, 13),(22, true, 3, 14),(23, true, 3, 15),(24, true, 3, 16),

(25, true, 4, 9),(26, true, 4, 10),(27, true, 4, 11),(28, false, 4, 12),(29, true, 4, 13),(30, true, 4, 14),(31, false, 4, 15),(32, true, 4, 16),

(33, true, 5, 17),(34, true, 5, 18),(35, true, 5, 19),(36, true, 5, 20),

(37, true, 6, 17),(38, false, 6, 18),(39, false, 6, 19),(40, true, 6, 20),

(41, true, 7, 17),(42, true, 7, 18),(43, true, 7, 19),(44, false, 7, 20);

INSERT INTO payments (id, date, amount, method, member_id, collectivity_id) VALUES
('p1','2026-01-01',200000,'CASH',1,'col-1'),
('p2','2026-01-01',200000,'CASH',2,'col-1'),
('p3','2026-01-01',150000,'MOBILE_MONEY',3,'col-1'),
('p4','2026-01-01',100000,'CASH',4,'col-1'),
('p5','2026-01-01',90000,'CASH',5,'col-1'),
('p6','2026-01-01',120000,'CASH',9,'col-2'),
('p7','2026-01-01',180000,'CASH',10,'col-2'),
('p8','2026-01-01',200000,'CASH',11,'col-2'),
('p9','2026-01-01',200000,'CASH',17,'col-3'),
('p10','2026-01-01',150000,'CASH',18,'col-3');