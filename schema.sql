-- =========================
-- TABLE CITY
-- =========================
CREATE TABLE city (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- =========================
-- FEDERATION
-- =========================
CREATE TABLE federation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cotisation_percentage DECIMAL(5,2) NOT NULL DEFAULT 10.00
);

-- =========================
-- MEMBER
-- =========================
CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    enrolment_date TIMESTAMP NOT NULL,
    address TEXT NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(50) NOT NULL UNIQUE,
    job VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    CHECK (gender IN ('MALE', 'FEMALE'))
);

-- =========================
-- COLLECTIVITY
-- =========================
CREATE TABLE collectivity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL UNIQUE,
    speciality VARCHAR(255) NOT NULL,
    creation_datetime TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    authorization_date TIMESTAMP,
    id_federation INT NOT NULL,
    id_city INT NOT NULL,
    CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED'))
);

-- =========================
-- MEMBER_COLLECTIVITY
-- =========================
CREATE TABLE member_collectivity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_member INT NOT NULL,
    id_collectivity INT NOT NULL,
    post_name VARCHAR(30) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,
    CHECK (post_name IN ('PRESIDENT', 'DEPUTY_PRESIDENT', 'TREASURER', 'SECRETARY', 'CONFIRMED', 'JUNIOR'))
);

-- =========================
-- SPONSORSHIP
-- =========================
CREATE TABLE sponsorship (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_candidate INT NOT NULL,
    id_sponsor INT NOT NULL,
    id_collectivity INT NOT NULL,
    relationship VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (id_candidate, id_sponsor)
);

-- =========================
-- MANDATE FEDERATION
-- =========================
CREATE TABLE mandate_federation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_member INT NOT NULL,
    id_federation INT NOT NULL,
    post_name VARCHAR(30) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,
    CHECK (post_name IN ('PRESIDENT', 'DEPUTY_PRESIDENT', 'TREASURER', 'SECRETARY'))
);

-- =========================
-- COTISATION PLAN
-- =========================
CREATE TABLE cotisation_plan (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_collectivity INT NOT NULL,
    label VARCHAR(255) NOT NULL,
    frequency VARCHAR(20) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    year INT,
    is_active BOOLEAN DEFAULT TRUE,
    CHECK (frequency IN ('MONTHLY', 'ANNUAL', 'PUNCTUAL'))
);

-- =========================
-- ACCOUNT
-- =========================
CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_collectivity INT,
    id_federation INT,
    CHECK (
        (id_collectivity IS NOT NULL AND id_federation IS NULL) OR
        (id_collectivity IS NULL AND id_federation IS NOT NULL)
    )
);

-- =========================
-- CASH ACCOUNT
-- =========================
CREATE TABLE cash_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_account INT UNIQUE NOT NULL
);

-- =========================
-- ACCOUNT MOVEMENT
-- =========================
CREATE TABLE account_movement (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_account INT NOT NULL,
    type VARCHAR(10) NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CHECK (type IN ('IN', 'OUT')),
    CHECK (amount > 0)
);

-- =========================
-- BANK ACCOUNT
-- =========================
CREATE TABLE bank_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_account INT UNIQUE NOT NULL,
    holder_name VARCHAR(255) NOT NULL,
    bank_name VARCHAR(30) NOT NULL,
    bank_code CHAR(5) NOT NULL,
    branch_code CHAR(5) NOT NULL,
    account_number CHAR(11) NOT NULL,
    rib_key CHAR(2) NOT NULL,
    CHECK (bank_name IN ('BRED','MCB','BMOI','BOA','BGFI','AFG','ACCES_BANQUE','BAOBAB','SIPEM'))
);

-- =========================
-- MOBILE MONEY ACCOUNT
-- =========================
CREATE TABLE mobile_money_account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_account INT UNIQUE NOT NULL,
    holder_name VARCHAR(255) NOT NULL,
    service_name VARCHAR(30) NOT NULL,
    phone_number VARCHAR(50) UNIQUE NOT NULL,
    CHECK (service_name IN ('ORANGE_MONEY','MVOLA','AIRTEL_MONEY'))
);

-- =========================
-- ACTIVITY
-- =========================
CREATE TABLE activity (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    activity_date TIMESTAMP NOT NULL,
    activity_type VARCHAR(30) NOT NULL,
    is_mandatory_all BOOLEAN DEFAULT FALSE,
    id_collectivity INT,
    id_federation INT,
    CHECK (activity_type IN ('MONTHLY_GA','JUNIOR_TRAINING','EXCEPTIONAL')),
    CHECK (
        (id_collectivity IS NOT NULL AND id_federation IS NULL) OR
        (id_collectivity IS NULL AND id_federation IS NOT NULL)
    )
);

-- =========================
-- ACTIVITY MANDATORY ROLE
-- =========================
CREATE TABLE activity_mandatory_role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_activity INT NOT NULL,
    post_name VARCHAR(30) NOT NULL,
    UNIQUE (id_activity, post_name)
);

-- =========================
-- ATTENDANCE
-- =========================
CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_activity INT NOT NULL,
    id_member INT NOT NULL,
    is_present BOOLEAN DEFAULT FALSE,
    is_excused BOOLEAN DEFAULT FALSE,
    excuse_reason TEXT,
    id_member_collectivity INT NOT NULL,
    UNIQUE (id_activity, id_member)
);

-- =========================
-- FOREIGN KEYS
-- =========================
ALTER TABLE collectivity
ADD FOREIGN KEY (id_federation) REFERENCES federation(id),
ADD FOREIGN KEY (id_city) REFERENCES city(id);

ALTER TABLE member_collectivity
ADD FOREIGN KEY (id_member) REFERENCES member(id),
ADD FOREIGN KEY (id_collectivity) REFERENCES collectivity(id);

ALTER TABLE mandate_federation
ADD FOREIGN KEY (id_member) REFERENCES member(id),
ADD FOREIGN KEY (id_federation) REFERENCES federation(id);

ALTER TABLE sponsorship
ADD FOREIGN KEY (id_candidate) REFERENCES member(id),
ADD FOREIGN KEY (id_sponsor) REFERENCES member(id),
ADD FOREIGN KEY (id_collectivity) REFERENCES collectivity(id);

ALTER TABLE cotisation_plan
ADD FOREIGN KEY (id_collectivity) REFERENCES collectivity(id);

ALTER TABLE account
ADD FOREIGN KEY (id_collectivity) REFERENCES collectivity(id),
ADD FOREIGN KEY (id_federation) REFERENCES federation(id);

ALTER TABLE cash_account
ADD FOREIGN KEY (id_account) REFERENCES account(id);

ALTER TABLE account_movement
ADD FOREIGN KEY (id_account) REFERENCES account(id);

ALTER TABLE bank_account
ADD FOREIGN KEY (id_account) REFERENCES account(id);

ALTER TABLE mobile_money_account
ADD FOREIGN KEY (id_account) REFERENCES account(id);

ALTER TABLE activity
ADD FOREIGN KEY (id_collectivity) REFERENCES collectivity(id),
ADD FOREIGN KEY (id_federation) REFERENCES federation(id);

ALTER TABLE activity_mandatory_role
ADD FOREIGN KEY (id_activity) REFERENCES activity(id);

ALTER TABLE attendance
ADD FOREIGN KEY (id_activity) REFERENCES activity(id),
ADD FOREIGN KEY (id_member) REFERENCES member(id),
ADD FOREIGN KEY (id_member_collectivity) REFERENCES member_collectivity(id);

-- =========================
-- INDEX COMPATIBLE H2 (IMPORTANT)
-- =========================
CREATE UNIQUE INDEX uq_unique_active_post_per_collectivity
ON member_collectivity (id_collectivity, post_name);