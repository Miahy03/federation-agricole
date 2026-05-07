DELETE FROM payments;
DELETE FROM membership_fees;
DELETE FROM financial_accounts;
DELETE FROM members;
DELETE FROM collectivities;

INSERT INTO collectivities (id, numero, nom, localite, specialite, date_creation, statut) VALUES
('col-1', '1', 'Mpanorina', 'Ambatondrazaka', 'Riziculture', '2026-01-01', 'ACTIVE'),
('col-2', '2', 'Dobo voalohany', 'Ambatondrazaka', 'Pisciculture', '2026-01-01', 'ACTIVE'),
('col-3', '3', 'Tantely mamy', 'Brickaville', 'Apiculture', '2026-01-01', 'ACTIVE');


INSERT INTO financial_accounts (id, collectivity_id, type, holder_name, balance, balance_date, phone_number) VALUES
('C1-A-CASH', 'col-1', 'CASH', NULL, 0, '2026-01-01', NULL),
('C1-A-MOBILE-1', 'col-1', 'ORANGE_MONEY', 'Mpanorina', 0, '2026-01-01', '0370489612');


INSERT INTO financial_accounts (id, collectivity_id, type, holder_name, balance, balance_date, phone_number) VALUES
('C2-A-CASH', 'col-2', 'CASH', NULL, 0, '2026-01-01', NULL),
('C2-A-MOBILE-1', 'col-2', 'ORANGE_MONEY', 'Dobo voalohany', 0, '2026-01-01', '0320489612');

INSERT INTO financial_accounts (id, collectivity_id, type, holder_name, balance, balance_date) VALUES
('C3-A-CASH', 'col-3', 'CASH', NULL, 0, '2026-01-01');


INSERT INTO financial_accounts (id, collectivity_id, type, holder_name, balance, balance_date, bank_name, bank_code, branch_code, account_number, rib_key) VALUES
('C3-A-BANK-1', 'col-3', 'BANK', 'Koto', 0, '2026-01-01', 'BMOI', '00004', '00001', '1234567890', '12'),
('C3-A-BANK-2', 'col-3', 'BANK', 'Naivo', 0, '2026-01-01', 'BRED', '00008', '00003', '4567890123', '58');

INSERT INTO financial_accounts (id, collectivity_id, type, holder_name, balance, balance_date, phone_number, mobile_money_service) VALUES
('C3-A-MOBILE-1', 'col-3', 'MVOLA', 'Kolo', 0, '2026-01-01', '0341889612', 'MVOLA');


INSERT INTO members (id, nom, prenom, date_naissance, date_adhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
('C1-M1', 'Nom membre 1', 'Prénom membre 1', '1980-02-01', '2026-01-01', 'M', 'Lot II V M Ambato.', 'Riziculteur', '0341234567', 'member.1@fed-agri.mg', 'PRESIDENT', 'col-1'),
('C1-M2', 'Nom membre 2', 'Prénom membre 2', '1982-03-05', '2026-01-01', 'M', 'Lot II F Ambato.', 'Agriculteur', '0321234567', 'member.2@fed-agri.mg', 'VICE_PRESIDENT', 'col-1'),
('C1-M3', 'Nom membre 3', 'Prénom membre 3', '1992-03-10', '2026-01-01', 'M', 'Lot II J Ambato.', 'Collecteur', '0331234567', 'member.3@fed-agri.mg', 'SECRETARY', 'col-1'),
('C1-M4', 'Nom membre 4', 'Prénom membre 4', '1988-05-22', '2026-01-01', 'F', 'Lot A K 50 Ambato.', 'Distributeur', '0381234567', 'member.4@fed-agri.mg', 'TREASURER', 'col-1'),
('C1-M5', 'Nom membre 5', 'Prénom membre 5', '1999-08-21', '2026-01-01', 'M', 'Lot UV 80 Ambato.', 'Riziculteur', '0373434567', 'member.5@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-1'),
('C1-M6', 'Nom membre 6', 'Prénom membre 6', '1998-08-22', '2026-01-01', 'F', 'Lot UV 6 Ambato.', 'Riziculteur', '0372234567', 'member.6@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-1'),
('C1-M7', 'Nom membre 7', 'Prénom membre 7', '1998-01-31', '2026-01-01', 'M', 'Lot UV 7 Ambato.', 'Riziculteur', '0374234567', 'member.7@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-1'),
('C1-M8', 'Nom membre 8', 'Prénom membre 8', '1975-08-20', '2026-01-01', 'M', 'Lot UV 8 Ambato.', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-1');

INSERT INTO members (id, nom, prenom, date_naissance, date_adhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
('C2-M1', 'Nom membre 1', 'Prénom membre 1', '1980-02-01', '2026-01-01', 'M', 'Lot II V M Ambato.', 'Riziculteur', '0341234567', 'member.1@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M2', 'Nom membre 2', 'Prénom membre 2', '1982-03-05', '2026-01-01', 'M', 'Lot II F Ambato.', 'Agriculteur', '0321234567', 'member.2@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M3', 'Nom membre 3', 'Prénom membre 3', '1992-03-10', '2026-01-01', 'M', 'Lot II J Ambato.', 'Collecteur', '0331234567', 'member.3@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M4', 'Nom membre 4', 'Prénom membre 4', '1988-05-22', '2026-01-01', 'F', 'Lot A K 50 Ambato.', 'Distributeur', '0381234567', 'member.4@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-2'),
('C2-M5', 'Nom membre 5', 'Prénom membre 5', '1999-08-21', '2026-01-01', 'M', 'Lot UV 80 Ambato.', 'Riziculteur', '0373434567', 'member.5@fed-agri.mg', 'PRESIDENT', 'col-2'),
('C2-M6', 'Nom membre 6', 'Prénom membre 6', '1998-08-22', '2026-01-01', 'F', 'Lot UV 6 Ambato.', 'Riziculteur', '0372234567', 'member.6@fed-agri.mg', 'VICE_PRESIDENT', 'col-2'),
('C2-M7', 'Nom membre 7', 'Prénom membre 7', '1998-01-31', '2026-01-01', 'M', 'Lot UV 7 Ambato.', 'Riziculteur', '0374234567', 'member.7@fed-agri.mg', 'SECRETARY', 'col-2'),
('C2-M8', 'Nom membre 8', 'Prénom membre 8', '1975-08-20', '2026-01-01', 'M', 'Lot UV 8 Ambato.', 'Riziculteur', '0370234567', 'member.8@fed-agri.mg', 'TREASURER', 'col-2');


INSERT INTO members (id, nom, prenom, date_naissance, date_adhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
('C3-M1', 'Nom membre 9', 'Prénom membre 9', '1988-01-02', '2026-01-01', 'M', 'Lot 33 J Antsirabe', 'Apiculteur', '034034567', 'member.9@fed-agri.mg', 'PRESIDENT', 'col-3'),
('C3-M2', 'Nom membre 10', 'Prénom membre 10', '1982-03-05', '2026-01-01', 'M', 'Lot 2 J Antsirabe', 'Agriculteur', '0338634567', 'member.10@fed-agri.mg', 'VICE_PRESIDENT', 'col-3'),
('C3-M3', 'Nom membre 11', 'Prénom membre 11', '1992-03-12', '2026-01-01', 'M', 'Lot 8 KM Antsirabe', 'Collecteur', '0338234567', 'member.11@fed-agri.mg', 'SECRETARY', 'col-3'),
('C3-M4', 'Nom membre 12', 'Prénom membre 12', '1988-05-10', '2026-01-01', 'F', 'Lot A K 50 Antsirabe', 'Distributeur', '0382334567', 'member.12@fed-agri.mg', 'TREASURER', 'col-3'),
('C3-M5', 'Nom membre 13', 'Prénom membre 13', '1999-08-11', '2026-01-01', 'M', 'Lot UV 80 Antsirabe', 'Apiculteur', '0373365567', 'member.13@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-3'),
('C3-M6', 'Nom membre 14', 'Prénom membre 14', '1998-08-09', '2026-01-01', 'F', 'Lot UV 6 Antsirabe', 'Apiculteur', '0378234567', 'member.14@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-3'),
('C3-M7', 'Nom membre 15', 'Prénom membre 15', '1998-01-13', '2026-01-01', 'M', 'Lot UV 7 Antsirabe', 'Apiculteur', '0374914567', 'member.15@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-3'),
('C3-M8', 'Nom membre 16', 'Prénom membre 16', '1975-08-02', '2026-01-01', 'M', 'Lot UV 8 Antsirabe', 'Apiculteur', '0370634567', 'member.16@fed-agri.mg', 'CONFIRMED_MEMBER', 'col-3');


INSERT INTO members (id, nom, prenom, date_naissance, date_adhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
('C1-N1', 'Nouveau 1', 'Prénom N1', '1995-01-01', '2026-04-01', 'M', 'Adresse random 1', 'Junior', '0340000001', 'new1@email.com', 'JUNIOR_MEMBER', 'col-1'),
('C1-N2', 'Nouveau 2', 'Prénom N2', '1996-02-02', '2026-04-01', 'F', 'Adresse random 2', 'Junior', '0340000002', 'new2@email.com', 'JUNIOR_MEMBER', 'col-1'),
('C1-N3', 'Nouveau 3', 'Prénom N3', '1997-03-03', '2026-05-01', 'M', 'Adresse random 3', 'Junior', '0340000003', 'new3@email.com', 'JUNIOR_MEMBER', 'col-1'),
('C1-N4', 'Nouveau 4', 'Prénom N4', '1998-04-04', '2026-06-01', 'F', 'Adresse random 4', 'Junior', '0340000004', 'new4@email.com', 'JUNIOR_MEMBER', 'col-1');

INSERT INTO members (id, nom, prenom, date_naissance, date_adhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
('C2-N1', 'Nouveau 5', 'Prénom N5', '1995-05-05', '2026-03-01', 'M', 'Adresse random 5', 'Junior', '0340000005', 'new5@email.com', 'JUNIOR_MEMBER', 'col-2'),
('C2-N2', 'Nouveau 6', 'Prénom N6', '1996-06-06', '2026-03-01', 'F', 'Adresse random 6', 'Junior', '0340000006', 'new6@email.com', 'JUNIOR_MEMBER', 'col-2'),
('C2-N3', 'Nouveau 7', 'Prénom N7', '1997-07-07', '2026-03-01', 'M', 'Adresse random 7', 'Junior', '0340000007', 'new7@email.com', 'JUNIOR_MEMBER', 'col-2');


INSERT INTO members (id, nom, prenom, date_naissance, date_adhesion, genre, adresse, metier, telephone, email, poste, collectivity_id) VALUES
('C3-N1', 'Nouveau 8', 'Prénom N8', '1995-08-08', '2026-01-01', 'M', 'Adresse random 8', 'Junior', '0340000008', 'new8@email.com', 'JUNIOR_MEMBER', 'col-3'),
('C3-N2', 'Nouveau 9', 'Prénom N9', '1996-09-09', '2026-02-01', 'F', 'Adresse random 9', 'Junior', '0340000009', 'new9@email.com', 'JUNIOR_MEMBER', 'col-3'),
('C3-N3', 'Nouveau 10', 'Prénom N10', '1997-10-10', '2026-02-01', 'M', 'Adresse random 10', 'Junior', '0340000010', 'new10@email.com', 'JUNIOR_MEMBER', 'col-3'),
('C3-N4', 'Nouveau 11', 'Prénom N11', '1998-11-11', '2026-03-01', 'F', 'Adresse random 11', 'Junior', '0340000011', 'new11@email.com', 'JUNIOR_MEMBER', 'col-3'),
('C3-N5', 'Nouveau 12', 'Prénom N12', '1999-12-12', '2026-03-01', 'M', 'Adresse random 12', 'Junior', '0340000012', 'new12@email.com', 'JUNIOR_MEMBER', 'col-3'),
('C3-N6', 'Nouveau 13', 'Prénom N13', '2000-01-01', '2026-03-01', 'F', 'Adresse random 13', 'Junior', '0340000013', 'new13@email.com', 'JUNIOR_MEMBER', 'col-3');


INSERT INTO membership_fees (id, collectivity_id, label, amount, period, start_date, end_date, active) VALUES
('cot-ancien-1', 'col-1', 'Cotisation annuelle ancienne', 100000, 'ANNUALLY', '2026-01-01', '2027-01-01', false),
('cot-ancien-2', 'col-2', 'Cotisation annuelle ancienne', 100000, 'ANNUALLY', '2026-01-01', '2027-01-01', false),
('cot-ancien-3', 'col-3', 'Cotisation annuelle ancienne', 50000, 'ANNUALLY', '2026-01-01', '2027-01-01', false);


INSERT INTO membership_fees (id, collectivity_id, label, amount, period, start_date, end_date, active) VALUES
('cot-1', 'col-1', 'Cotisation annuelle', 200000, 'ANNUALLY', '2026-01-01', '2027-01-01', true),
('cot-2', 'col-1', 'Famangiana', 20000, 'PUNCTUALLY', '2026-04-30', '2026-05-30', true),
('cot-3', 'col-2', 'Cotisation annuelle', 200000, 'ANNUALLY', '2026-01-01', '2027-01-01', true),
('cot-4', 'col-2', 'Cotisation 2025', 100000, 'ANNUALLY', '2025-01-01', '2026-01-01', false),
('cot-5', 'col-3', 'Cotisation mensuelle', 25000, 'MONTHLY', '2026-04-01', '2026-05-01', true);


INSERT INTO payments (id, date, amount, method, member_id, collectivity_id, account_id) VALUES
('pay-ancien-1', '2026-01-01', 100000, 'CASH', 'C1-M1', 'col-1', 'C1-A-CASH'),
('pay-ancien-2', '2026-01-01', 100000, 'CASH', 'C1-M2', 'col-1', 'C1-A-CASH'),
('pay-ancien-3', '2026-01-01', 100000, 'CASH', 'C1-M3', 'col-1', 'C1-A-CASH'),
('pay-ancien-4', '2026-01-01', 100000, 'CASH', 'C1-M4', 'col-1', 'C1-A-CASH'),
('pay-ancien-5', '2026-01-01', 100000, 'CASH', 'C1-M5', 'col-1', 'C1-A-CASH'),
('pay-ancien-6', '2026-01-01', 100000, 'CASH', 'C1-M6', 'col-1', 'C1-A-CASH'),
('pay-ancien-7', '2026-01-01', 60000, 'CASH', 'C1-M7', 'col-1', 'C1-A-CASH'),
('pay-ancien-8', '2026-01-01', 90000, 'CASH', 'C1-M8', 'col-1', 'C1-A-CASH');


INSERT INTO payments (id, date, amount, method, member_id, collectivity_id, account_id) VALUES
('pay-ancien-9', '2026-01-01', 60000, 'CASH', 'C2-M1', 'col-2', 'C2-A-CASH'),
('pay-ancien-10', '2026-01-01', 90000, 'CASH', 'C2-M2', 'col-2', 'C2-A-CASH'),
('pay-ancien-11', '2026-01-01', 100000, 'CASH', 'C2-M3', 'col-2', 'C2-A-CASH'),
('pay-ancien-12', '2026-01-01', 100000, 'CASH', 'C2-M4', 'col-2', 'C2-A-CASH'),
('pay-ancien-13', '2026-01-01', 100000, 'CASH', 'C2-M5', 'col-2', 'C2-A-CASH'),
('pay-ancien-14', '2026-01-01', 100000, 'CASH', 'C2-M6', 'col-2', 'C2-A-CASH'),
('pay-ancien-15', '2026-01-01', 40000, 'MOBILE_MONEY', 'C2-M7', 'col-2', 'C2-A-MOBILE-1'),
('pay-ancien-16', '2026-01-01', 60000, 'MOBILE_MONEY', 'C2-M8', 'col-2', 'C2-A-MOBILE-1');


INSERT INTO payments (id, date, amount, method, member_id, collectivity_id, account_id) VALUES
('pay-1', '2026-01-01', 200000, 'CASH', 'C1-M1', 'col-1', 'C1-A-CASH'),
('pay-2', '2026-01-01', 200000, 'CASH', 'C1-M2', 'col-1', 'C1-A-CASH'),
('pay-3', '2026-01-01', 200000, 'MOBILE_MONEY', 'C1-M3', 'col-1', 'C1-A-MOBILE-1'),
('pay-4', '2026-01-01', 200000, 'MOBILE_MONEY', 'C1-M4', 'col-1', 'C1-A-MOBILE-1'),
('pay-5', '2026-01-01', 150000, 'MOBILE_MONEY', 'C1-M5', 'col-1', 'C1-A-MOBILE-1'),
('pay-6', '2026-05-01', 100000, 'CASH', 'C1-M6', 'col-1', 'C1-A-CASH'),
('pay-7', '2026-05-01', 60000, 'CASH', 'C1-M7', 'col-1', 'C1-A-CASH'),
('pay-8', '2026-05-01', 90000, 'CASH', 'C1-M8', 'col-1', 'C1-A-CASH');

INSERT INTO payments (id, date, amount, method, member_id, collectivity_id, account_id) VALUES
('pay-9', '2026-01-01', 120000, 'CASH', 'C2-M1', 'col-2', 'C2-A-CASH'),
('pay-10', '2026-01-01', 180000, 'CASH', 'C2-M2', 'col-2', 'C2-A-CASH'),
('pay-11', '2026-01-01', 200000, 'CASH', 'C2-M3', 'col-2', 'C2-A-CASH'),
('pay-12', '2026-01-01', 200000, 'CASH', 'C2-M4', 'col-2', 'C2-A-CASH'),
('pay-13', '2026-01-01', 200000, 'CASH', 'C2-M5', 'col-2', 'C2-A-CASH'),
('pay-14', '2026-01-01', 200000, 'CASH', 'C2-M6', 'col-2', 'C2-A-CASH'),
('pay-15', '2026-01-01', 80000, 'MOBILE_MONEY', 'C2-M7', 'col-2', 'C2-A-MOBILE-1'),
('pay-16', '2026-01-01', 120000, 'MOBILE_MONEY', 'C2-M8', 'col-2', 'C2-A-MOBILE-1');

INSERT INTO payments (id, date, amount, method, member_id, collectivity_id, account_id) VALUES
('pay-17', '2026-04-01', 25000, 'BANK', 'C3-M1', 'col-3', 'C3-A-BANK-1'),
('pay-18', '2026-04-01', 25000, 'BANK', 'C3-M2', 'col-3', 'C3-A-BANK-1'),
('pay-19', '2026-04-01', 25000, 'BANK', 'C3-M3', 'col-3', 'C3-A-BANK-1'),
('pay-20', '2026-04-01', 25000, 'BANK', 'C3-M4', 'col-3', 'C3-A-BANK-1'),
('pay-21', '2026-04-01', 25000, 'BANK', 'C3-M5', 'col-3', 'C3-A-BANK-2'),
('pay-22', '2026-04-01', 25000, 'BANK', 'C3-M6', 'col-3', 'C3-A-BANK-2'),
('pay-23', '2026-04-01', 25000, 'CASH', 'C3-M7', 'col-3', 'C3-A-CASH'),
('pay-24', '2026-04-01', 25000, 'CASH', 'C3-M8', 'col-3', 'C3-A-CASH'),

('pay-25', '2026-05-01', 25000, 'BANK', 'C3-M1', 'col-3', 'C3-A-BANK-1'),
('pay-26', '2026-05-01', 25000, 'BANK', 'C3-M2', 'col-3', 'C3-A-BANK-1'),
('pay-27', '2026-05-01', 15000, 'MVOLA', 'C3-M3', 'col-3', 'C3-A-MOBILE-1'),
('pay-28', '2026-05-01', 15000, 'MVOLA', 'C3-M4', 'col-3', 'C3-A-MOBILE-1'),
('pay-29', '2026-05-01', 20000, 'BANK', 'C3-M5', 'col-3', 'C3-A-BANK-2'),
('pay-30', '2026-05-01', 25000, 'BANK', 'C3-M6', 'col-3', 'C3-A-BANK-2'),
('pay-31', '2026-05-01', 5000, 'CASH', 'C3-M7', 'col-3', 'C3-A-CASH'),
('pay-32', '2026-05-01', 5000, 'CASH', 'C3-M8', 'col-3', 'C3-A-CASH');

