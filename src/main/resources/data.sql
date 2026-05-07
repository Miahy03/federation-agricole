DELETE FROM attendances;
DELETE FROM activities;
DELETE FROM payments;
DELETE FROM membership_fees;
DELETE FROM financial_accounts;
DELETE FROM members;
DELETE FROM collectivities;

INSERT INTO collectivities (id, numero, nom, localite, specialite, datecreation, statut) VALUES
('col-1', '1', 'Mpanorina', 'Ambatondrazaka', 'Riziculture', '2026-01-01', 'ACTIVE'),
('col-2', '2', 'Dobo voalohany', 'Ambatondrazaka', 'Pisciculture', '2026-01-01', 'ACTIVE'),
('col-3', '3', 'Tantely mamy', 'Brickaville', 'Apiculture', '2026-01-01', 'ACTIVE');

INSERT INTO financial_accounts (id, collectivity_id, type, holder_name, balance, balance_date) VALUES
('C1-A-CASH', 'col-1', 'CASH', NULL, 0, '2026-01-01'),
('C2-A-CASH', 'col-2', 'CASH', NULL, 0, '2026-01-01'),
('C3-A-CASH', 'col-3', 'CASH', NULL, 0, '2026-01-01');

INSERT INTO members (id, nom, prenom, datenaissance, dateadhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
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
('C2-M8', 'Nom membre 8', 'Prénom membre 8', '1975-08-20', '2026-01-01', 'M', 'Ambato', 'Riziculteur', '0370234567', 'c2m8@fed.mg', 'TREASURER', 'col-2'),

('C3-M1', 'Nom membre 9', 'Prénom membre 9', '1988-01-02', '2026-01-01', 'M', 'Antsirabe', 'Apiculteur', '034034567', 'c3m1@fed.mg', 'PRESIDENT', 'col-3'),
('C3-M2', 'Nom membre 10', 'Prénom membre 10', '1982-03-05', '2026-01-01', 'M', 'Antsirabe', 'Agriculteur', '0338634567', 'c3m2@fed.mg', 'VICE_PRESIDENT', 'col-3'),
('C3-M3', 'Nom membre 11', 'Prénom membre 11', '1992-03-12', '2026-01-01', 'M', 'Antsirabe', 'Collecteur', '0338234567', 'c3m3@fed.mg', 'SECRETARY', 'col-3'),
('C3-M4', 'Nom membre 12', 'Prénom membre 12', '1988-05-10', '2026-01-01', 'F', 'Antsirabe', 'Distributeur', '0382334567', 'c3m4@fed.mg', 'TREASURER', 'col-3'),
('C3-M5', 'Nom membre 13', 'Prénom membre 13', '1999-08-11', '2026-01-01', 'M', 'Antsirabe', 'Apiculteur', '0373365567', 'c3m5@fed.mg', 'CONFIRMED_MEMBER', 'col-3'),
('C3-M6', 'Nom membre 14', 'Prénom membre 14', '1998-08-09', '2026-01-01', 'F', 'Antsirabe', 'Apiculteur', '0378234567', 'c3m6@fed.mg', 'CONFIRMED_MEMBER', 'col-3'),
('C3-M7', 'Nom membre 15', 'Prénom membre 15', '1998-01-13', '2026-01-01', 'M', 'Antsirabe', 'Apiculteur', '0374914567', 'c3m7@fed.mg', 'CONFIRMED_MEMBER', 'col-3'),
('C3-M8', 'Nom membre 16', 'Prénom membre 16', '1975-08-02', '2026-01-01', 'M', 'Antsirabe', 'Apiculteur', '0370634567', 'c3m8@fed.mg', 'CONFIRMED_MEMBER', 'col-3');

INSERT INTO membership_fees (id, collectivity_id, label, amount, period, start_date, end_date, active) VALUES
('cot-1', 'col-1', 'Cotisation annuelle', 200000, 'ANNUALLY', '2026-01-01', '2027-01-01', true),
('cot-3', 'col-2', 'Cotisation annuelle', 200000, 'ANNUALLY', '2026-01-01', '2027-01-01', true),
('cot-5', 'col-3', 'Cotisation mensuelle', 25000, 'MONTHLY', '2026-04-01', '2026-05-01', true);

INSERT INTO payments (id, date, amount, method, member_id, collectivity_id) VALUES
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
('pay-16', '2026-01-01', 120000, 'MOBILE_MONEY', 'C2-M8', 'col-2'),
('pay-17', '2026-04-01', 25000, 'CASH', 'C3-M1', 'col-3'),
('pay-18', '2026-04-01', 25000, 'CASH', 'C3-M2', 'col-3'),
('pay-19', '2026-04-01', 25000, 'CASH', 'C3-M3', 'col-3'),
('pay-20', '2026-04-01', 25000, 'CASH', 'C3-M4', 'col-3'),
('pay-21', '2026-05-01', 25000, 'CASH', 'C3-M1', 'col-3'),
('pay-22', '2026-05-01', 25000, 'CASH', 'C3-M2', 'col-3'),
('pay-23', '2026-05-01', 15000, 'MOBILE_MONEY', 'C3-M3', 'col-3'),
('pay-24', '2026-05-01', 15000, 'MOBILE_MONEY', 'C3-M4', 'col-3');

INSERT INTO activities (id, collectivity_id, label, activity_type, scheduled_date, mandatory, target_role, recurrence_rule, created_at) VALUES
('act-1', 'col-1', 'AG1', 'MEETING', NULL, true, 'ALL', '1st Saturday of each month', '2026-01-01'),
('act-2', 'col-1', 'Formation de base', 'TRAINING', NULL, true, 'JUNIOR', '2nd Sunday of each month', '2026-01-01'),
('act-3', 'col-2', 'AG2', 'MEETING', NULL, true, 'ALL', '1st Sunday of each month', '2026-01-01'),
('act-4', 'col-2', 'Formation de base', 'TRAINING', NULL, true, 'JUNIOR', '3rd Sunday of each month', '2026-01-01'),
('act-5', 'col-2', 'Perfectionnement', 'PUNCTUAL', '2026-04-30', true, 'SENIOR', NULL, '2026-01-01'),
('act-6', 'col-3', 'AG3', 'MEETING', NULL, true, 'ALL', '1st Friday of each month', '2026-01-01'),
('act-7', 'col-3', 'Formation de base', 'TRAINING', NULL, true, 'JUNIOR', '4th Wednesday of each month', '2026-01-01');

INSERT INTO attendances (id, activity_id, collectivity_id, member_id, member_name, status, recorded_at, counted_for_assiduity) VALUES
('att-1', 'act-1', 'col-1', 'C1-M1', 'Nom membre 1', 'PRESENT', '2026-03-07', true),
('att-2', 'act-1', 'col-1', 'C1-M2', 'Nom membre 2', 'PRESENT', '2026-03-07', true),
('att-3', 'act-1', 'col-1', 'C1-M3', 'Nom membre 3', 'PRESENT', '2026-03-07', true),
('att-4', 'act-1', 'col-1', 'C1-M4', 'Nom membre 4', 'PRESENT', '2026-03-07', true),
('att-5', 'act-1', 'col-1', 'C1-M5', 'Nom membre 5', 'PRESENT', '2026-03-07', true),
('att-6', 'act-1', 'col-1', 'C1-M6', 'Nom membre 6', 'PRESENT', '2026-03-07', true),
('att-7', 'act-1', 'col-1', 'C1-M7', 'Nom membre 7', 'MISSING', '2026-03-07', true),
('att-8', 'act-1', 'col-1', 'C1-M8', 'Nom membre 8', 'MISSING', '2026-03-07', true),
('att-9', 'act-1', 'col-1', 'C1-M1', 'Nom membre 1', 'PRESENT', '2026-04-04', true),
('att-10', 'act-1', 'col-1', 'C1-M2', 'Nom membre 2', 'PRESENT', '2026-04-04', true),
('att-11', 'act-1', 'col-1', 'C1-M3', 'Nom membre 3', 'MISSING', '2026-04-04', true),
('att-12', 'act-1', 'col-1', 'C1-M4', 'Nom membre 4', 'MISSING', '2026-04-04', true),
('att-13', 'act-1', 'col-1', 'C1-M5', 'Nom membre 5', 'PRESENT', '2026-04-04', true),
('att-14', 'act-1', 'col-1', 'C1-M6', 'Nom membre 6', 'PRESENT', '2026-04-04', true),
('att-15', 'act-1', 'col-1', 'C1-M7', 'Nom membre 7', 'PRESENT', '2026-04-04', true),
('att-16', 'act-1', 'col-1', 'C1-M8', 'Nom membre 8', 'PRESENT', '2026-04-04', true),
('att-17', 'act-3', 'col-2', 'C2-M1', 'Nom membre 1', 'PRESENT', '2026-03-08', true),
('att-18', 'act-3', 'col-2', 'C2-M2', 'Nom membre 2', 'PRESENT', '2026-03-08', true),
('att-19', 'act-3', 'col-2', 'C2-M3', 'Nom membre 3', 'MISSING', '2026-03-08', true),
('att-20', 'act-3', 'col-2', 'C2-M4', 'Nom membre 4', 'MISSING', '2026-03-08', true),
('att-21', 'act-3', 'col-2', 'C2-M5', 'Nom membre 5', 'PRESENT', '2026-03-08', true),
('att-22', 'act-3', 'col-2', 'C2-M6', 'Nom membre 6', 'PRESENT', '2026-03-08', true),
('att-23', 'act-3', 'col-2', 'C2-M7', 'Nom membre 7', 'PRESENT', '2026-03-08', true),
('att-24', 'act-3', 'col-2', 'C2-M8', 'Nom membre 8', 'PRESENT', '2026-03-08', true),
('att-25', 'act-3', 'col-2', 'C2-M1', 'Nom membre 1', 'PRESENT', '2026-04-05', true),
('att-26', 'act-3', 'col-2', 'C2-M2', 'Nom membre 2', 'PRESENT', '2026-04-05', true),
('att-27', 'act-3', 'col-2', 'C2-M3', 'Nom membre 3', 'MISSING', '2026-04-05', true),
('att-28', 'act-3', 'col-2', 'C2-M4', 'Nom membre 4', 'PRESENT', '2026-04-05', true),
('att-29', 'act-3', 'col-2', 'C2-M5', 'Nom membre 5', 'PRESENT', '2026-04-05', true),
('att-30', 'act-3', 'col-2', 'C2-M6', 'Nom membre 6', 'PRESENT', '2026-04-05', true),
('att-31', 'act-3', 'col-2', 'C2-M7', 'Nom membre 7', 'PRESENT', '2026-04-05', true),
('att-32', 'act-3', 'col-2', 'C2-M8', 'Nom membre 8', 'MISSING', '2026-04-05', true),
('att-33', 'act-5', 'col-2', 'C2-M1', 'Nom membre 1', 'PRESENT', '2026-04-30', true),
('att-34', 'act-5', 'col-2', 'C2-M2', 'Nom membre 2', 'PRESENT', '2026-04-30', true),
('att-35', 'act-5', 'col-2', 'C2-M3', 'Nom membre 3', 'PRESENT', '2026-04-30', true),
('att-36', 'act-5', 'col-2', 'C2-M4', 'Nom membre 4', 'MISSING', '2026-04-30', true),
('att-37', 'act-5', 'col-2', 'C2-M5', 'Nom membre 5', 'UNDEFINED', '2026-04-30', false),
('att-38', 'act-5', 'col-2', 'C2-M6', 'Nom membre 6', 'UNDEFINED', '2026-04-30', false),
('att-39', 'act-5', 'col-2', 'C2-M7', 'Nom membre 7', 'UNDEFINED', '2026-04-30', false),
('att-40', 'act-5', 'col-2', 'C2-M8', 'Nom membre 8', 'UNDEFINED', '2026-04-30', false),
('att-41', 'act-6', 'col-3', 'C3-M1', 'Nom membre 9', 'PRESENT', '2026-03-06', true),
('att-42', 'act-6', 'col-3', 'C3-M2', 'Nom membre 10', 'PRESENT', '2026-03-06', true),
('att-43', 'act-6', 'col-3', 'C3-M3', 'Nom membre 11', 'PRESENT', '2026-03-06', true),
('att-44', 'act-6', 'col-3', 'C3-M4', 'Nom membre 12', 'PRESENT', '2026-03-06', true),
('att-45', 'act-6', 'col-3', 'C3-M5', 'Nom membre 13', 'PRESENT', '2026-03-06', true),
('att-46', 'act-6', 'col-3', 'C3-M6', 'Nom membre 14', 'PRESENT', '2026-03-06', true),
('att-47', 'act-6', 'col-3', 'C3-M7', 'Nom membre 15', 'MISSING', '2026-03-06', true),
('att-48', 'act-6', 'col-3', 'C3-M8', 'Nom membre 16', 'MISSING', '2026-03-06', true),
('att-49', 'act-6', 'col-3', 'C3-M1', 'Nom membre 9', 'PRESENT', '2026-04-03', true),
('att-50', 'act-6', 'col-3', 'C3-M2', 'Nom membre 10', 'PRESENT', '2026-04-03', true),
('att-51', 'act-6', 'col-3', 'C3-M3', 'Nom membre 11', 'MISSING', '2026-04-03', true),
('att-52', 'act-6', 'col-3', 'C3-M4', 'Nom membre 12', 'MISSING', '2026-04-03', true),
('att-53', 'act-6', 'col-3', 'C3-M5', 'Nom membre 13', 'PRESENT', '2026-04-03', true),
('att-54', 'act-6', 'col-3', 'C3-M6', 'Nom membre 14', 'PRESENT', '2026-04-03', true),
('att-55', 'act-6', 'col-3', 'C3-M7', 'Nom membre 15', 'MISSING', '2026-04-03', true),
('att-56', 'act-6', 'col-3', 'C3-M8', 'Nom membre 16', 'PRESENT', '2026-04-03', true),
('att-57', 'act-6', 'col-3', 'C1-M1', 'Nom membre 1', 'PRESENT', '2026-04-03', false);
