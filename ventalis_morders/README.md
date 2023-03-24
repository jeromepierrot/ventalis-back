# Read Me First
This project is part of Ventalis project (back-end microservice).
This microservice is not supposed to work alone and should be run with other micro-services
and their eco-system (Gateway, micro web-client, etc).

For the time being, only mproducts and msecurity services are available.

The website (front-end) part of the project is stored in another Git repositories :
https://github.com/jeromepierrot/ventalis-front

# Getting Started
For full Getting started instructions, please see the global project's [README.md file](../README.md).

To run this micro-service on a development environment and as standalone application, MariaDB's SQL Database is required (local or server hosted).

You can also change the database type (ie: PosgreSQL instead of MariaDB, but it has not been fully tested and not recommended).

Please see the file : [src/main/resources/application.yml]([application.yml](src%2Fmain%2Fresources%2Fapplication.yml))

If you wish to do it **anyway**, you must also edit this file by :
- modifying JPA's driver configuration according to the database type
- choosing the 'create' DDL Auto option to generate the database first, then change this option to '`update`' when in production/test.
=>  '`jpa:hibernate:ddl-auto: update`' 
 - - should be set to '`create`' on first launch
 - - then, should be is set to '`update`' for production / dev / test (= default setting) -> to persist database content
 - - choose '`validate`' or '`create-drop`' for testing new mods or setups (careful : 'create-drop' option will erase the database tables and their contents each time you launch the server).
 - - choose '`validate`' for testing new mods or setups (will not change data content)
 - Note : DO NOT use the *.sql files (line '`spring:sql:init:mode: never`' (= default setting) ).

You can create your own .sql schema and data init files by calling them 'schema-{platform}.sql' and 'data-{platform}.sql'.

Then adapt the queries according to the chosen DBMS. In this particular case set the application.yml like this :

'`jpa:hibernate:ddl-auto: validate`' or '`jpa:hibernate:ddl-auto: none`' -> will validate data according to JPA's annotation code
'`spring:sql:init:mode: always`' -> will reset the database content by executing the scripts 'schema-mysql.sql' then 'data-mysql.sql' file.
'`spring:sql:init:plateform: mysql`' (by default) or choose your keyword for any other DBMS or test purposes 
(ie: application.yml -> '`spring:sql:init:plateform: test`' | your files should be  -> 'schema-test.sql' and 'data-test.sql')

### Original Reference Documentation and Guide
[See HELP.md file](./HELP.md)