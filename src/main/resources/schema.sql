DROP TABLE IF EXISTS payments;
DROP TABLE IF EXISTS membership_fees;
DROP TABLE IF EXISTS financial_accounts;
DROP TABLE IF EXISTS members;
DROP TABLE IF EXISTS collectivities;

CREATE TABLE IF NOT EXISTS collectivities (
    id VARCHAR(255) PRIMARY KEY,
    numero VARCHAR(50),
    nom VARCHAR(255),
    localite VARCHAR(255),
    specialite VARCHAR(255),
    date_creation DATE,
    statut VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS members (
    id VARCHAR(255) PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    date_naissance DATE,
    date_adhesion DATE,
    genre VARCHAR(10),
    adresse VARCHAR(255),
    metier VARCHAR(255),
    telephone VARCHAR(50),
    email VARCHAR(255),
    poste VARCHAR(50),
    collectivity_id VARCHAR(255),
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS financial_accounts (
    id VARCHAR(255) PRIMARY KEY,
    collectivity_id VARCHAR(255),
    type VARCHAR(50),
    holder_name VARCHAR(255),
    balance DECIMAL(15,2) DEFAULT 0,
    balance_date DATE,
    phone_number VARCHAR(50),
    mobile_money_service VARCHAR(50),
    bank_name VARCHAR(50),
    bank_code VARCHAR(10),
    branch_code VARCHAR(10),
    account_number VARCHAR(20),
    rib_key VARCHAR(5),
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS membership_fees (
    id VARCHAR(255) PRIMARY KEY,
    collectivity_id VARCHAR(255),
    label VARCHAR(255),
    amount DECIMAL(15,2),
    period VARCHAR(50),
    start_date DATE,
    end_date DATE,
    active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS payments (
    id VARCHAR(255) PRIMARY KEY,
    date DATE,
    amount DECIMAL(15,2),
    method VARCHAR(50),
    member_id VARCHAR(255),
    collectivity_id VARCHAR(255),
    account_id VARCHAR(255),
    FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE SET NULL,
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE CASCADE,
    FOREIGN KEY (account_id) REFERENCES financial_accounts(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS transactions (
    id VARCHAR(255) PRIMARY KEY,
    creation_date DATE,
    amount DECIMAL(15,2),
    payment_method VARCHAR(50),
    collectivity_id VARCHAR(255),
    member_id VARCHAR(255),
    account_id VARCHAR(255),
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE SET NULL,
    FOREIGN KEY (account_id) REFERENCES financial_accounts(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS activities (
    id VARCHAR(255) PRIMARY KEY,
    collectivity_id VARCHAR(255),
    label VARCHAR(255),
    activity_type VARCHAR(50),
    scheduled_date TIMESTAMP,
    mandatory BOOLEAN DEFAULT TRUE,
    target_role VARCHAR(50),
    recurrence_rule VARCHAR(255),
    created_at TIMESTAMP,
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS attendances (
    id VARCHAR(255) PRIMARY KEY,
    activity_id VARCHAR(255),
    collectivity_id VARCHAR(255),
    member_id VARCHAR(255),
    member_name VARCHAR(255),
    member_collectivity_id VARCHAR(255),
    status VARCHAR(20),
    excuse_reason VARCHAR(255),
    recorded_at TIMESTAMP,
    counted_for_assiduity BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (activity_id) REFERENCES activities(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE SET NULL,
    FOREIGN KEY (collectivity_id) REFERENCES collectivities(id) ON DELETE CASCADE
);

CREATE INDEX idx_members_collectivity ON members(collectivity_id);
CREATE INDEX idx_members_email ON members(email);
CREATE INDEX idx_payments_member ON payments(member_id);
CREATE INDEX idx_payments_collectivity ON payments(collectivity_id);
CREATE INDEX idx_payments_date ON payments(date);
CREATE INDEX idx_membership_fees_collectivity ON membership_fees(collectivity_id);
CREATE INDEX idx_membership_fees_active ON membership_fees(active);
CREATE INDEX idx_financial_accounts_collectivity ON financial_accounts(collectivity_id);
CREATE INDEX idx_activities_collectivity ON activities(collectivity_id);
CREATE INDEX idx_attendances_activity ON attendances(activity_id);
CREATE INDEX idx_attendances_member ON attendances(member_id);