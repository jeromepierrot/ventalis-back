DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS admins;
DROP TABLE IF EXISTS employees;

CREATE TABLE IF NOT EXISTS admins (
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE KEY,
    password VARCHAR(256) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255),
    role VARCHAR(255),
    is_enabled BIT DEFAULT 1,
    registration_code BIGINT(20) DEFAULT(UUID_SHORT()) UNIQUE KEY,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS employees (
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE KEY,
    password VARCHAR(256) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255),
    role VARCHAR(255),
    is_enabled BIT DEFAULT 1,
    registration_code BIGINT(20) DEFAULT(UUID_SHORT()) UNIQUE KEY,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS users (
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE KEY,
    password VARCHAR(256) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255),
    role VARCHAR(255),
    is_enabled BIT DEFAULT 1,
    company VARCHAR(255) NOT NULL,
    adviser_id     BIGINT(20),
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (adviser_id)
        REFERENCES employees(id)
        ON DELETE NO ACTION
        ON UPDATE CASCADE
);