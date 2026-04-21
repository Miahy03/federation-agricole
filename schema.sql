-- =========================
-- TYPES ENUM
-- =========================

CREATE TYPE collectivity_post_name AS ENUM (
    'PRESIDENT', 'DEPUTY_PRESIDENT', 'TREASURER', 'SECRETARY',
    'CONFIRMED', 'JUNIOR'
);

CREATE TYPE federation_post_name AS ENUM (
    'PRESIDENT', 'DEPUTY_PRESIDENT', 'TREASURER', 'SECRETARY'
);

CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');

CREATE TYPE payment_mode AS ENUM ('CASH', 'BANK_TRANSFER', 'MOBILE_MONEY');

CREATE TYPE cotisation_frequency AS ENUM ('MONTHLY', 'ANNUAL', 'PUNCTUAL');

CREATE TYPE bank_name_enum AS ENUM (
    'BRED', 'MCB', 'BMOI', 'BOA', 'BGFI', 'AFG',
    'ACCES_BANQUE', 'BAOBAB', 'SIPEM'
);

CREATE TYPE mobile_money_service AS ENUM (
    'ORANGE_MONEY', 'MVOLA', 'AIRTEL_MONEY'
);

CREATE TYPE activity_type AS ENUM (
    'MONTHLY_GA', 'JUNIOR_TRAINING', 'EXCEPTIONAL'
);

CREATE TYPE collectivity_status AS ENUM (
    'PENDING', 'APPROVED', 'REJECTED'
);

CREATE TYPE movement_type AS ENUM ('IN', 'OUT');


-- =========================
-- CORE TABLES
-- =========================

CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE federation (
    id SERIAL PRIMARY KEY,
    cotisation_percentage NUMERIC(5,2) NOT NULL DEFAULT 10.00
);

CREATE TABLE member (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    birth_date DATE NOT NULL,
    enrolment_date TIMESTAMP NOT NULL,
    address TEXT NOT NULL,
    email VARCHAR UNIQUE NOT NULL,
    phone VARCHAR UNIQUE NOT NULL,
    job VARCHAR NOT NULL,
    gender gender NOT NULL
);

CREATE TABLE collectivity (
    id SERIAL PRIMARY KEY,
    number VARCHAR UNIQUE NOT NULL,
    name VARCHAR UNIQUE NOT NULL,
    speciality VARCHAR NOT NULL,
    creation_datetime TIMESTAMP NOT NULL,
    status collectivity_status NOT NULL DEFAULT 'PENDING',
    authorization_date TIMESTAMP,
    id_federation INT NOT NULL,
    id_city INT NOT NULL,

    FOREIGN KEY (id_federation) REFERENCES federation(id),
    FOREIGN KEY (id_city) REFERENCES city(id)
);


-- =========================
-- MEMBERSHIP
-- =========================

CREATE TABLE member_collectivity (
    id SERIAL PRIMARY KEY,
    id_member INT NOT NULL,
    id_collectivity INT NOT NULL,
    post_name collectivity_post_name NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,

    FOREIGN KEY (id_member) REFERENCES member(id),
    FOREIGN KEY (id_collectivity) REFERENCES collectivity(id)
);

-- Un seul poste actif par collectivité (fixe)
CREATE UNIQUE INDEX uq_active_post
ON member_collectivity (id_collectivity, post_name)
WHERE end_date IS NULL
AND post_name IN ('PRESIDENT','DEPUTY_PRESIDENT','TREASURER','SECRETARY');


-- =========================
-- SPONSORSHIP (B-2)
-- =========================

CREATE TABLE sponsorship (
    id SERIAL PRIMARY KEY,
    id_candidate INT NOT NULL,
    id_sponsor INT NOT NULL,
    id_collectivity INT NOT NULL,
    relationship VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),

    UNIQUE (id_candidate, id_sponsor),

    FOREIGN KEY (id_candidate) REFERENCES member(id),
    FOREIGN KEY (id_sponsor) REFERENCES member(id),
    FOREIGN KEY (id_collectivity) REFERENCES collectivity(id)
);


-- =========================
-- FEDERATION MANDATE
-- =========================

CREATE TABLE mandate_federation (
    id SERIAL PRIMARY KEY,
    id_member INT NOT NULL,
    id_federation INT NOT NULL,
    post_name federation_post_name NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP,

    FOREIGN KEY (id_member) REFERENCES member(id),
    FOREIGN KEY (id_federation) REFERENCES federation(id)
);


-- =========================
-- COTISATION / PAYMENT
-- =========================

CREATE TABLE cotisation_plan (
    id SERIAL PRIMARY KEY,
    id_collectivity INT NOT NULL,
    label VARCHAR NOT NULL,
    frequency cotisation_frequency NOT NULL,
    amount NUMERIC(15,2) NOT NULL,
    year INT,
    is_active BOOLEAN DEFAULT TRUE,

    FOREIGN KEY (id_collectivity) REFERENCES collectivity(id)
);

CREATE TABLE account (
    id SERIAL PRIMARY KEY,
    id_collectivity INT,
    id_federation INT,

    FOREIGN KEY (id_collectivity) REFERENCES collectivity(id),
    FOREIGN KEY (id_federation) REFERENCES federation(id),

    CHECK (
        (id_collectivity IS NOT NULL AND id_federation IS NULL)
        OR
        (id_collectivity IS NULL AND id_federation IS NOT NULL)
    )
);

-- 🔥 CORRECTION IMPORTANTE (remplace ton index invalide)
CREATE UNIQUE INDEX uq_one_account_per_collectivity
ON account(id_collectivity)
WHERE id_collectivity IS NOT NULL;

CREATE UNIQUE INDEX uq_one_account_per_federation
ON account(id_federation)
WHERE id_federation IS NOT NULL;


CREATE TABLE cash_account (
    id SERIAL PRIMARY KEY,
    id_account INT UNIQUE NOT NULL,

    FOREIGN KEY (id_account) REFERENCES account(id) ON DELETE CASCADE
);


CREATE TABLE account_movement (
    id SERIAL PRIMARY KEY,
    id_account INT NOT NULL,
    type movement_type NOT NULL,
    amount NUMERIC(15,2) NOT NULL CHECK (amount > 0),
    created_at TIMESTAMP DEFAULT NOW(),

    FOREIGN KEY (id_account) REFERENCES account(id)
);


CREATE TABLE bank_account (
    id SERIAL PRIMARY KEY,
    id_account INT UNIQUE NOT NULL,
    holder_name VARCHAR NOT NULL,
    bank_name bank_name_enum NOT NULL,
    bank_code CHAR(5) NOT NULL,
    branch_code CHAR(5) NOT NULL,
    account_number CHAR(11) NOT NULL,
    rib_key CHAR(2) NOT NULL,

    FOREIGN KEY (id_account) REFERENCES account(id)
);

CREATE TABLE mobile_money_account (
    id SERIAL PRIMARY KEY,
    id_account INT UNIQUE NOT NULL,
    holder_name VARCHAR NOT NULL,
    service_name mobile_money_service NOT NULL,
    phone_number VARCHAR UNIQUE NOT NULL,

    FOREIGN KEY (id_account) REFERENCES account(id)
);


-- =========================
-- ACTIVITIES
-- =========================

CREATE TABLE activity (
    id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    description TEXT,
    activity_date TIMESTAMP NOT NULL,
    activity_type activity_type NOT NULL,
    is_mandatory_all BOOLEAN DEFAULT FALSE,

    id_collectivity INT,
    id_federation INT,

    FOREIGN KEY (id_collectivity) REFERENCES collectivity(id),
    FOREIGN KEY (id_federation) REFERENCES federation(id),

    CHECK (
        (id_collectivity IS NOT NULL AND id_federation IS NULL)
        OR
        (id_collectivity IS NULL AND id_federation IS NOT NULL)
    )
);

CREATE TABLE activity_mandatory_role (
    id SERIAL PRIMARY KEY,
    id_activity INT NOT NULL,
    post_name collectivity_post_name NOT NULL,

    UNIQUE (id_activity, post_name),
    FOREIGN KEY (id_activity) REFERENCES activity(id)
);


-- =========================
-- ATTENDANCE
-- =========================

CREATE TABLE attendance (
    id SERIAL PRIMARY KEY,
    id_activity INT NOT NULL,
    id_member INT NOT NULL,
    is_present BOOLEAN DEFAULT FALSE,
    is_excused BOOLEAN DEFAULT FALSE,
    excuse_reason TEXT,
    id_member_collectivity INT NOT NULL,

    UNIQUE (id_activity, id_member),

    FOREIGN KEY (id_activity) REFERENCES activity(id),
    FOREIGN KEY (id_member) REFERENCES member(id),
    FOREIGN KEY (id_member_collectivity)
        REFERENCES member_collectivity(id)
);


-- =========================
-- RULE METIER (optionnel mais conseillé)
-- =========================

ALTER TABLE member_collectivity
ADD CONSTRAINT chk_mandate_duration
CHECK (
    end_date IS NULL
    OR end_date <= start_date + INTERVAL '1 year'
);