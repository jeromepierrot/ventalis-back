INSERT INTO categories (`name`, `is_visible`)
VALUES (
           'Services',
           true
       ),
       (
           'Logiciels',
           true
       ),
       (
           'Accessoires',
           true
       ),
       (
           'Pack1',
           false
       );

INSERT INTO products (`label`, `description`,  `unit_price_ht`, `id_category`, `created_date`, `modified_date`)
VALUES (
           'Cartes de visites électroniques',
           'Plus de cartes de visites, un simple geste entre mobile et vous échanger vos données avec vos clients',
           0.1,
           3,
           SUBDATE(NOW(), INTERVAL 60 DAY),
           SUBDATE(NOW(), INTERVAL 31 DAY)
       ),
       (
           'Marketing pour les nuls',
           'Adapté à tous nos clients',
           10.,
           1,
           SUBDATE(NOW(), INTERVAL 60 DAY),
           SUBDATE(NOW(), INTERVAL 31 DAY)
       ),
       (
           'Produit magnifique',
           'Un magnifique produit',
           2.,
           1,
           SUBDATE(NOW(), INTERVAL 31 DAY),
           SUBDATE(NOW(), INTERVAL 31 DAY)
       ),
       (
           'Pack all-in-one',
           'Un nouveau pack de produits',
           10.,
           4,
           SUBDATE(NOW(), INTERVAL 20 DAY),
           SUBDATE(NOW(), INTERVAL 20 DAY)
       ),
       (
           'Application mobile',
           'Offerte avec toutes nos offres pendant 1 an et pour 1000 comptes',
           0.05,
           2,
           SUBDATE(NOW(), INTERVAL 18 DAY),
           SUBDATE(NOW(), INTERVAL 18 DAY)
       ),
       (
           'Etude basique',
           'Notre offre découverte permettant de mettre en place des outils marketing standard mais indispensables',
           3.,
           4,
           SUBDATE(NOW(), INTERVAL 18 DAY),
           SUBDATE(NOW(), INTERVAL 18 DAY)
       ),
       (
           'Etude optimisée',
           'Notre offre phare permettant de mettre en place un marketing efficace et moderne',
           5.,
           4,
           SUBDATE(NOW(), INTERVAL 18 DAY),
           NOW()
       ),
       (
           'Etude complète',
           'Notre offre complète permet une intégration marketing dans toutes les strates de votre entreprise',
           10.,
           4,
           SUBDATE(NOW(), INTERVAL 18 DAY),
           NOW()
       ),
       (
           'Divers 1',
           'Description divers 1',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 10 DAY),
           SUBDATE(NOW(), INTERVAL 10 DAY)
       ),
       (
           'Divers 2',
           'Description divers 2',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 10 DAY),
           SUBDATE(NOW(), INTERVAL 10 DAY)
       ),
       (
           'Divers 3',
           'Description divers 3',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 10 DAY),
           SUBDATE(NOW(), INTERVAL 10 DAY)
       ),
       (
           'Divers 4',
           'Description divers 4',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 8 DAY),
           SUBDATE(NOW(), INTERVAL 8 DAY)
       ),
       (
           'Divers 5',
           'Description divers 5',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 7 DAY),
           SUBDATE(NOW(), INTERVAL 7 DAY)
       ),
       (
           'Divers 6',
           'Description divers 6',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 5 DAY),
           SUBDATE(NOW(), INTERVAL 5 DAY)
       ),
       (
           'Divers 7',
           'Description divers 7',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 4 DAY),
           SUBDATE(NOW(), INTERVAL 4 DAY)
       ),
       (
           'Divers 8',
           'Description divers 8',
           0.05,
           null,
           SUBDATE(NOW(), INTERVAL 2 DAY),
           SUBDATE(NOW(), INTERVAL 2 DAY)
       ),
       (
           'Divers 9',
           'Description divers 9',
           0.05,
           null,
           NOW(),
           NOW()
       ),
       (
           'Divers 10',
           'Description divers 10',
           0.05,
           null,
           NOW(),
           NOW()
       );