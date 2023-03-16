DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;

CREATE TABLE IF NOT EXISTS categories
(
    id     BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255),
    is_visible BIT DEFAULT 0,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS products
(
    id     BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(255) NOT NULL,
    description TEXT DEFAULT NULL,
    unit_price_ht FLOAT DEFAULT NULL,
    min_order_quantity INT(11) DEFAULT 1000,
    image_resource_url VARCHAR(255) DEFAULT NULL,
    is_visible BIT(1) DEFAULT 0,
    id_category BIGINT(20) DEFAULT NULL,
    created_date DATETIME DEFAULT NOW(),
    modified_date DATETIME DEFAULT NOW(),
    FOREIGN KEY (id_category)
        REFERENCES categories (id)
        ON DELETE SET NULL
);