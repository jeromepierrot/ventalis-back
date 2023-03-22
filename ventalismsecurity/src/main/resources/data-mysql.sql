INSERT INTO admins (`lastname`,`firstname`, `email`, `password`, `is_enabled`, `created_date`, `modified_date`)
VALUES
    ('Jeunet-Viail',
     'Genneviève',
     'gjv@ventalis.fr.',
     'supermotdepasse',
     1,
     SUBDATE(NOW(), INTERVAL 60 DAY),
     SUBDATE(NOW(), INTERVAL 60 DAY)
    )
;

INSERT INTO employees (`lastname`,`firstname`, `email`, `password`, `is_enabled`, `created_date`, `modified_date`)
VALUES
    ('Jeunet-Boe',
     'John',
     'jjb@ventalis.fr.',
     'supermotdepasse',
     1,
     SUBDATE(NOW(), INTERVAL 59 DAY),
     SUBDATE(NOW(), INTERVAL 59 DAY)
    )
;

INSERT INTO users (`company`, `lastname`,`firstname`, `email`, `password`, `adviser_id`, `is_enabled`, `created_date`, `modified_date`)
VALUES
    (
     'Toto et cie',
     'Toto',
    'Gérard',
    'gerard@toto.com',
     '$2a$10$YdH8qCWotWKZFAuRPM//6OLjww.2qmSj03BWdulXbHl/0LFTrqH6C',
     1,
     1,
     SUBDATE(NOW(), INTERVAL 60 DAY),
     SUBDATE(NOW(), INTERVAL 34 DAY)
    ),
    (
     'Yoyo et cie',
     'Yoyo',
     'Tata',
     'tatayoyo@gmail.com',
     '$2a$10$JnqgWloXneFJaZEK/KxQ9O0vERlIcDvBAA3NNAuskj5fAbiDBj2oa',
     1,
     1,
     SUBDATE(NOW(), INTERVAL 40 DAY),
     SUBDATE(NOW(), INTERVAL 25 DAY)
    ),
    (
     'Titi et cie',
     'Rominet',
     'Titi',
     'titi-rominet@orange.fr',
     '$2a$10$jnd7Qh593vT57rb2j8YCQO.jZ4icaqjUSJPXYzzrcqkbJOVDMKUo2',
     1,
     1,
     SUBDATE(NOW(), INTERVAL 20 DAY),
     SUBDATE(NOW(), INTERVAL 18 DAY)
     ),
     (
      'Aucune',
      'Giesse',
      'Eric',
      'eric.giesse@yahoo.fr',
      '$2a$10$JnqgWloXneFJaZEK/KxQ9O0vERlIcDvBAA3NNAuskj5fAbiDBj2oa',
      1,
      1,
      SUBDATE(NOW(), INTERVAL 20 DAY),
      SUBDATE(NOW(), INTERVAL 18 DAY)
    )
;

