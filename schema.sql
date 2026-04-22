DROP TABLE IF EXISTS sponsorship CASCADE;
DROP TABLE IF EXISTS member CASCADE;
DROP TABLE IF EXISTS collectivity CASCADE;
DROP TABLE IF EXISTS city CASCADE;
DROP TABLE IF EXISTS federation CASCADE;

CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE federation (
    id SERIAL PRIMARY KEY,
    cotisation_percentage DECIMAL(5,2) NOT NULL DEFAULT 10.00
);

CREATE TABLE collectivity (
    id SERIAL PRIMARY KEY,
    number VARCHAR(100) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL UNIQUE,
    speciality VARCHAR(255) NOT NULL,
    creation_datetime TIMESTAMP NOT NULL DEFAULT NOW(),
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    authorization_date TIMESTAMP,
    id_federation INT NOT NULL,
    id_city INT NOT NULL
);

CREATE TABLE member (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    admission_date DATE,
    join_date DATE,
    address VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(50) UNIQUE,
    job VARCHAR(255),
    gender VARCHAR(10) NOT NULL,
    collectivity_id INT
);

CREATE TABLE sponsorship (
    id SERIAL PRIMARY KEY,
    id_candidate INT NOT NULL,
    id_sponsor INT NOT NULL,
    id_collectivity INT NOT NULL,
    relationship VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE (id_candidate, id_sponsor)
);

ALTER TABLE collectivity
ADD CONSTRAINT fk_collectivity_federation
FOREIGN KEY (id_federation) REFERENCES federation(id);

ALTER TABLE collectivity
ADD CONSTRAINT fk_collectivity_city
FOREIGN KEY (id_city) REFERENCES city(id);

ALTER TABLE member
ADD CONSTRAINT fk_member_collectivity
FOREIGN KEY (collectivity_id) REFERENCES collectivity(id);

ALTER TABLE sponsorship
ADD CONSTRAINT fk_sponsorship_candidate
FOREIGN KEY (id_candidate) REFERENCES member(id);

ALTER TABLE sponsorship
ADD CONSTRAINT fk_sponsorship_sponsor
FOREIGN KEY (id_sponsor) REFERENCES member(id);

ALTER TABLE sponsorship
ADD CONSTRAINT fk_sponsorship_collectivity
FOREIGN KEY (id_collectivity) REFERENCES collectivity(id);