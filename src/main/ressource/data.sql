DELETE FROM payments;
DELETE FROM members;
DELETE FROM collectivities;

INSERT INTO collectivities (
    id,
    numero,
    nom,
    localite,
    specialite,
    datecreation,
    statut
) VALUES
('col-1', '1', 'Mpanorina', 'Ambatondrazaka', 'Riziculture', '2026-01-01', 'ACTIVE'),
('col-2', '2', 'Dobo voalohany', 'Ambatondrazaka', 'Pisciculture', '2026-01-01', 'ACTIVE'),
('col-3', '3', 'Tantely mamy', 'Brickaville', 'Apiculture', '2026-01-01', 'ACTIVE');

INSERT INTO members (
    id,
    nom,
    prenom,
    datenaissance,
    dateadhesion,
    genre,
    adresse,
    metier,
    telephone,
    email,
    poste,
    collectivity_id
) VALUES
('C1-M1', 'Nom membre 1', 'Prénom membre 1', '1980-02-01', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0341234567', 'm1@fed.mg', 'PRESIDENT', 'col-1'),
('C1-M2', 'Nom membre 2', 'Prénom membre 2', '1982-03-05', '2026-01-01', 'M', 'Ambato', 'Agriculteur', '0321234567', 'm2@fed.mg', 'VICE_PRESIDENT', 'col-1'),
('C1-M3', 'Nom membre 3', 'Prénom membre 3', '1992-03-10', '2026-01-01', 'M', 'Ambato', 'Collecteur', '0331234567', 'm3@fed.mg', 'SECRETARY', 'col-1'),
('C1-M4', 'Nom membre 4', 'Prénom membre 4', '1988-05-22', '2026-01-01', 'F', 'Ambato', 'Distributeur', '0381234567', 'm4@fed.mg', 'TREASURER', 'col-1'),
('C1-M5', 'Nom membre 5', 'Prénom membre 5', '1999-08-21', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0373434567', 'm5@fed.mg', 'CONFIRMED_MEMBER', 'col-1'),
('C1-M6', 'Nom membre 6', 'Prénom membre 6', '1998-08-22', '2026-01-01', 'F', 'Ambato', 'Riziculteur', '0372234567', 'm6@fed.mg', 'CONFIRMED_MEMBER', 'col-1'),
('C1-M7', 'Nom membre 7', 'Prénom membre 7', '1998-01-31', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0374234567', 'm7@fed.mg', 'CONFIRMED_MEMBER', 'col-1'),
('C1-M8', 'Nom membre 8', 'Prénom membre 8', '1975-08-20', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0370234567', 'm8@fed.mg', 'CONFIRMED_MEMBER', 'col-1'),

('C2-M1', 'Nom membre 1', 'Prénom membre 1', '1980-02-01', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0341234567', 'c2m1@fed.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M2', 'Nom membre 2', 'Prénom membre 2', '1982-03-05', '2026-01-01', 'M', 'Ambato', 'Agriculteur', '0321234567', 'c2m2@fed.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M3', 'Nom membre 3', 'Prénom membre 3', '1992-03-10', '2026-01-01', 'M', 'Ambato', 'Collecteur', '0331234567', 'c2m3@fed.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M4', 'Nom membre 4', 'Prénom membre 4', '1988-05-22', '2026-01-01', 'F', 'Ambato', 'Distributeur', '0381234567', 'c2m4@fed.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M5', 'Nom membre 5', 'Prénom membre 5', '1999-08-21', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0373434567', 'c2m5@fed.mg', 'PRESIDENT', 'col-2'),
('C2-M6', 'Nom membre 6', 'Prénom membre 6', '1998-08-22', '2026-01-01', 'F', 'Ambato', 'Riziculteur', '0372234567', 'c2m6@fed.mg', 'VICE_PRESIDENT', 'col-2'),
('C2-M7', 'Nom membre 7', 'Prénom membre 7', '1998-01-31', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0374234567', 'c2m7@fed.mg', 'SECRETARY', 'col-2'),
('C2-M8', 'Nom membre 8', 'Prénom membre 8', '1975-08-20', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0370234567', 'c2m8@fed.mg', 'TREASURER', 'col-2');

INSERT INTO payments (
    id,
    date,
    amount,
    method,
    member_id,
    collectivity_id
) VALUES
('pay-1', '2026-01-01', 200000, 'CASH', 'C1-M1', 'col-1'),
('pay-2', '2026-01-01', 200000, 'CASH', 'C1-M2', 'col-1'),
('pay-3', '2026-01-01', 200000, 'MOBILE_MONEY', 'C1-M3', 'col-1'),
('pay-4', '2026-01-01', 200000, 'MOBILE_MONEY', 'C1-M4', 'col-1'),
('pay-5', '2026-01-01', 150000, 'MOBILE_MONEY', 'C1-M5', 'col-1'),
('pay-6', '2026-05-01', 100000, 'CASH', 'C1-M6', 'col-1'),
('pay-7', '2026-05-01', 60000, 'CASH', 'C1-M7', 'col-1'),
('pay-8', '2026-05-01', 90000, 'CASH', 'C1-M8', 'col-1'),

('pay-9', '2026-01-01', 120000, 'CASH', 'C2-M1', 'col-2'),
('pay-10', '2026-01-01', 180000, 'CASH', 'C2-M2', 'col-2'),
('pay-11', '2026-01-01', 200000, 'CASH', 'C2-M3', 'col-2'),
('pay-12', '2026-01-01', 200000, 'CASH', 'C2-M4', 'col-2'),
('pay-13', '2026-01-01', 200000, 'CASH', 'C2-M5', 'col-2'),
('pay-14', '2026-01-01', 200000, 'CASH', 'C2-M6', 'col-2'),
('pay-15', '2026-01-01', 80000, 'MOBILE_MONEY', 'C2-M7', 'col-2'),
('pay-16', '2026-01-01', 120000, 'MOBILE_MONEY', 'C2-M8', 'col-2');