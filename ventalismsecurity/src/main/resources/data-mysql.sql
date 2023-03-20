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
     'blagues',
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
     'jenaipas',
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
     'cH4ta!0r5',
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
      'CtotoM4t!x',
      1,
      1,
      SUBDATE(NOW(), INTERVAL 20 DAY),
      SUBDATE(NOW(), INTERVAL 18 DAY)
    )
;

