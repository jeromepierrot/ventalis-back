# Read Me First
This project is part of Ventalis project (back-end microservice).
This microservice is not supposed to work alone and should be running alongside other micro-services.

      For the time being, only 'mproducts' (this one) and 'msecurity' micro-services are available.

The website (front-end) part of the project is stored in another Git repositories :
https://github.com/jeromepierrot/ventalis-front

# Getting Started

For full Getting started instructions, please see the global project's [README.md file](../README.md).

## Installation :

To run this micro-service on a development environment and as standalone application, you need :

- Java JDK version 17* installed on your machine (OpenJDK or others : see https://adoptium.net/ for pre-built OpenJDK LTS release)
- Maven 4.0.0 project management tool
- recommended IDE : IntelliJ Idea (VS Code, Eclipse or STS can be used but not tested)
- MariaDB's SQL Database is required (local or server hosted).

*(JDK version 17 is required for Spring Boot 3.0.x)

### Installing the dependencies :

If running IntelliJ Idea :

1. open the Maven (top-right ),
2. click on the icon with the "arrow+folder" to generate project files (.iml and so on)
3. deploy the chosen sub-project/module folder (ie : ventalis-morders) + deploy the Lifecycle folder, then double-click on "clean"
4. double-click on "validate"
5. double-click on "compile"
   (note : keep in mind the 'compile' button, it may be useful  later on)

![maven-generate-update_intelliJ.png](..%2Freadme%2Fmaven-generate-update_intelliJ.png)

![maven-clean_intelliJ.png](..%2Freadme%2Fmaven-clean_intelliJ.png)

or,

If using CLI or running VS Code, and compile of one subproject/module  :
- be sure to be inside the correct subproject folder (ie : `cd ventalis_back/ventalis_morders`)
- then run the command below to clean and install dependencies :

`mvn clean install`
(it will perform the 3 above operation in one time)

In both cases, if you are experiencing some errors during TESTS and/or BUILD time (TEST FAILURE / BUILD FAILURE), it is normal as you will need to properly set your database configuration, by editing the 'application.yml' file (see below).
But for now, you should get a new 'target' folder including all the dependency's source files installed (+ one .iml file per module in case of IntelliJ Idea).

## Running the project :

From IntelliJ Idea :
1. be sure to select the correct module's Configuration (ie: VentalisMordersApplication)
2. (in some cases, if you've got strange not 'in-phase' code, or changes that don't seem to apply, you'll certainly need to re-compile the project manually, remember point 5. above in Maven section).
3. then choose 'run' (or 'debug', or 'coverage' as you wish)

![maven-run_intelliJ.png](..%2Freadme%2Fmaven-run_intelliJ.png)

From CLI (or VS Code), enter the command below :
`mvn spring-boot:run`

### About Database : 
MariaDB's SQL Database is required (local or server hosted).

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

# Functional details

      This section is not fully edited yet. Please come back later for any update

### Original Reference Documentation and Guide
[See HELP.md file](.%2FHELP.md)