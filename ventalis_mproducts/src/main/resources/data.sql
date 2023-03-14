INSERT INTO categories (`id`,`name`, `is_visible`)
VALUES (
           null,
           'categorie1',
           true
       ),
       (
           null,
           'categorie2',
           true
       ),
       (
           null,
           'categorie3',
           false
       );

INSERT INTO products (`id`,`description`, `image_resource_url`, `is_visible`, `label`, `min_order_quantity`, `unit_priceht`, `id_category`)
VALUES (
           null,
           'Un super produit',
           null,
           true,
           'produit1',
           1001,
           0.01,
           null
       ),
       (
           null,
           'Un 2eme supper produit',
           null,
           true,
           'produit2',
           100,
           10,
           null
       ),
       (
           null,
           'Un magnifique produit',
           null,
           true,
           'produit3',
           1001,
           2,
           2
       ),
       (
           null,
           'Un autre super produit',
           null,
           true,
           'produit4',
           1000,
           0.01,
           1
       ),
       (
           null,
           'Un dernier super produit',
           null,
           true,
           'produit5',
           1000,
           0.01,
           2
       );