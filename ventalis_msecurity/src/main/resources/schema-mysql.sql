DROP TABLE IF EXISTS companies;
DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS companies (
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL UNIQUE KEY
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE KEY,
    password VARCHAR(256) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) DEFAULT NULL,
    role VARCHAR(255) NOT NULL,
    is_enabled BIT DEFAULT 1,
    company_id BIGINT(20) DEFAULT NULL,
    adviser_id BIGINT(20) DEFAULT NULL,
    registration_code BIGINT(16) DEFAULT NULL,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (adviser_id)
        REFERENCES users(id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE,
    FOREIGN KEY (company_id)
        REFERENCES companies(id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
);
