# INSERT INTO admins (`lastname`,`firstname`, `email`, `password`, `is_enabled`, `created_date`, `modified_date`)
# VALUES
#     ('Jeunet-Viail',
#      'Genneviève',
#      'gjv@ventalis.fr.',
#      'supermotdepasse',
#      1,
#      SUBDATE(NOW(), INTERVAL 60 DAY),
#      SUBDATE(NOW(), INTERVAL 60 DAY)
#     )
# ;

# INSERT INTO employees (`lastname`,`firstname`, `email`, `password`, `is_enabled`, `created_date`, `modified_date`)
# VALUES
#     ('Jeunet-Boe',
#      'John',
#      'jjb@ventalis.fr.',
#      'supermotdepasse',
#      1,
#      SUBDATE(NOW(), INTERVAL 59 DAY),
#      SUBDATE(NOW(), INTERVAL 59 DAY)
#     )
# ;

INSERT INTO companies (`name`)
VALUES ('Toto et cie'),
           ('Yoyo et cie'),
           ('Titi et cie'),
           ('Aucune')
;

INSERT INTO users (`lastname`,`firstname`, `email`, `password`, role_type, `adviser_id`, `registration_code`, `is_enabled`, `created_date`, `modified_date`)
VALUES
    (
    'Niveck',
    'Kevin',
    'kevin@ventalis.fr',
    '$2a$10$7i5/JW8OWb9oTX4.a1dbZejNzsYrMqS83d3j/eRo0B/qy0JwKeEV.',
    'Employee',
    null,
    4036160,
    1,
    SUBDATE(NOW(), INTERVAL 60 DAY),
    SUBDATE(NOW(), INTERVAL 34 DAY)
    ),
    (
        'Nullstein',
        'Albert',
        'albert@ventalis.fr',
        '$2a$10$mrHf7N9Cn0GSpqF6dNs9Bu.bLqglb0eUxQ5EfUvS4H.NZuvsMiqyi',
        'Admin',
        null,
        53892383,
        1,
        SUBDATE(NOW(), INTERVAL 60 DAY),
        SUBDATE(NOW(), INTERVAL 34 DAY)
    ),
    (
     'Toto',
    'Gérard',
    'gerard@toto.com',
     '$2a$10$YdH8qCWotWKZFAuRPM//6OLjww.2qmSj03BWdulXbHl/0LFTrqH6C',
     'User',
     1,
     0,
     1,
     SUBDATE(NOW(), INTERVAL 60 DAY),
     SUBDATE(NOW(), INTERVAL 34 DAY)
    ),
    (
     'Yoyo',
     'Tata',
     'tatayoyo@gmail.com',
     '$2a$10$JnqgWloXneFJaZEK/KxQ9O0vERlIcDvBAA3NNAuskj5fAbiDBj2oa',
     'User',
     1,
     0,
     1,
     SUBDATE(NOW(), INTERVAL 40 DAY),
     SUBDATE(NOW(), INTERVAL 25 DAY)
    ),
    (
     'Rominet',
     'Titi',
     'titi-rominet@orange.fr',
     '$2a$10$jnd7Qh593vT57rb2j8YCQO.jZ4icaqjUSJPXYzzrcqkbJOVDMKUo2',
     'User',
     1,
     0,
     1,
     SUBDATE(NOW(), INTERVAL 20 DAY),
     SUBDATE(NOW(), INTERVAL 18 DAY)
     ),
     (
      'Giesse',
      'Eric',
      'eric.giesse@yahoo.fr',
      '$2a$10$JnqgWloXneFJaZEK/KxQ9O0vERlIcDvBAA3NNAuskj5fAbiDBj2oa',
      'User',
      1,
      0,
      1,
      SUBDATE(NOW(), INTERVAL 20 DAY),
      SUBDATE(NOW(), INTERVAL 18 DAY)
    )
;

