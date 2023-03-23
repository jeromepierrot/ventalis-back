DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS pictures;

CREATE TABLE IF NOT EXISTS categories
(
    id     BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255) UNIQUE KEY,
    is_visible BIT DEFAULT 0,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS pictures
(
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    file_content MEDIUMBLOB DEFAULT NULL,
    size BIGINT(20) NOT NULL DEFAULT 0,
    created_by VARCHAR(25) NOT NULL DEFAULT 'unknown',
    modified_by VARCHAR(25) NOT NULL DEFAULT 'unknown',
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS products
(
    id     BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(255) NOT NULL UNIQUE KEY,
    id_picture BIGINT(20) DEFAULT NULL,
    description TEXT(1000) DEFAULT NULL,
    unit_price_ht FLOAT DEFAULT NULL,
    min_order_quantity INT(11) DEFAULT 1000,
    is_visible BIT(1) DEFAULT 0,
    id_category BIGINT(20) DEFAULT NULL,
    created_by VARCHAR(25) NOT NULL DEFAULT 'unknown',
    modified_by VARCHAR(25) NOT NULL DEFAULT 'unknown',
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (id_category)
        REFERENCES categories (id)
        ON DELETE SET NULL,
    FOREIGN KEY (id_picture)
        REFERENCES pictures (id)
        ON DELETE CASCADE
);