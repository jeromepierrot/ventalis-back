INSERT INTO categories (`id`,`name`, `is_visible`)
VALUES (
           null,
           'Services',
           true
       ),
       (
           null,
           'Logiciels',
           true
       ),
       (
           null,
           'Accessoires',
           true
       ),
       (
           null,
           'Pack1',
           false
       );


INSERT INTO products (`name`, `description`,  `unit_price_ht`, `id_category`) -- TODO: change 'name' by 'label' when test are ok with 'name'
VALUES (
           'Cartes de visites électroniques',
           'Plus de cartes de visites, un simple geste entre mobile et vous échanger vos données avec vos clients',
           0.1,
           3
       ),
       (
           'Marketing pour les nuls',
           'Adapté à tous nos clients',
           10.,
           1
       ),
       (
           'Produit magnifique',
           'Un magnifique produit',
           2.,
           1
       ),
       (
           'Pack all-in-one',
           'Un nouveau pack de produits',
           10.,
           4
       ),
       (
           'Application mobile',
           'Offerte avec toutes nos offres pendant 1 an et pour 1000 comptes',
           0.05,
           2
       );