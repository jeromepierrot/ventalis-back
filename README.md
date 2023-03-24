# VENTALIS Project (back-end part)

## Presentation

This project is the back-end part of Ventalis project.
Based on microservice architecture, the back-end is composed with multi-Java/Spring "mini-projects" (that is called "module" below).

For the time being, each module is a simple RESTful API with its own database.
Each Front-end service (Website, Desktop app and Mobile app) can directly access to them one by one using different URLs.

But later, it will be completed by some additional full micro-service architecture parts (ie: gateway based on Feign REST API, Gateway, Configurer, reverse-proxy servers, etc...) so that only one API (one URL) will "serve" the different front-end's requests.

The website (front-end) part of the project is stored in another Git repositories :
https://github.com/jeromepierrot/ventalis-front

Two others applications will be available soon :
- one Mobile Android application for registered clients only = Android application (based on Kotlin + JetPack Compose). iOS should be design ed to ()

(link will be available soon to download the apk installer from FTP server)

- one Desktop application for registered Employees : will be based on a PWA made with Angular CLI + Angular Material. It will run on any desktop OS but Windows and Mac OS are the main target OS.

(link will be available soon to download the app installer from FTP server)

Both applications will need an available account to work with.

## Getting started

Each project is a full Java Spring project using Maven project management system.
But be careful, the whole project is versioned with one commom GIT repository, it means that there are multiple .gitignore files : 
one into the main folder AND one into each module's subfolder.

    Attention :
    DO NOT MOVE nor RENAME nor DELETE any main subfolder (like 'ventalis_mmessages', 'ventalis_morders', 'ventalis_mmessages', etc...) if you fork the project.
    AND
    DO NOT DELETE any .git folder nor .gitignore files from the main folder OR any Subfolders,

    Reason : the project has been designed using IntelliJ's project and modules (.iml) and has been globally versioned using GIT.
    So it assumes that you load it also inside IntelliJ, even if you can run/build each module (= mini-project) independently.
    Of course, all IntelliJ like files are not part of this repository.

    See :  https://www.jetbrains.com/help/idea/creating-and-managing-modules.html for more informations

Each module is mainly based on :
- JAVA SE 17*
- Spring Boot Starter Web 3.0.4 (incl RESTful API + Tomcat server) 
- Spring Security 6.0.x
- Spring Data JPA (incl. JDBC + Hibernate ORM) + MariaDB drivers (10.6)
- Spring Validation (Hibernate Validator)

About the additional development tools :
- DevTools
- Lombok (included with)

_*(note : version 17 is required for Spring Boot 3.0.x)_

Unit test and mockup :
    
    Please come back later for any update

For more convenient, it is recommended to load the full project using **IntelliJ Idea's IDE** (project and module management).

    instruction will follow soon. This section is not fully edited yet. Please come back later for any update

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

![maven-generate-update_intelliJ.png](readme%2Fmaven-generate-update_intelliJ.png)

![maven-clean_intelliJ.png](readme%2Fmaven-clean_intelliJ.png)

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

![maven-run_intelliJ.png](readme%2Fmaven-run_intelliJ.png)

From CLI (or VS Code), enter the command below :
`mvn spring-boot:run`

---
_(Provisional)_

For the moment (as long as the project is not a fully micro-service architecture project) each module can also be loaded as a standalone back-end application, using its own localhost port.
Here are the default port allocation :

1. **'msecurity'** => http://localhost:9089 (or http://localhost:8089)
2. **'mproducts** => http://localhost:9081
3. **'morders'** => http://localhost:9082
4. **'mmessages'** => http://localhost:9083
5. **'mmail'** => http://localhost:9084

You can those settings by editing each application project's configuration file :

'ventalis_m{mservice}/src/main/resources/application.yml'

then edit the first command line :

'`server:port: xxxx`' where xxxx is the chosen port number.

Of course, each service must have its own single port and should NOT be the same as any other ones, nor as the front-end port (if local front-end's application server is used too, ie: port 4200).

---

Also, each module must have one access to its own MariaDB SQL Database. Please see So, each one has its own administrator login/password credentials. Those can also be set by editing each application's configuration 'application.yml' file :

'ventalis_m{mservice}/src/main/resources/application.yml'

You can also change the database type (ie: PosgreSQL instead of MariaDB, but it has not been fully tested and not recommended).
Please see details instructions inside each module's README.md file.

---

For the time being, only 'mproducts' and 'msecurity' services are available.
1. **'msecurity' deals with the login/signup authetications and authorizations**. It grants authorities depending on the role of users or prevent unauthorized users to access to any database. It provides token (JWT format) and can be seen as a "Token factory" for all others micro-services.

see: [README.md](ventalis_msecurity%2FREADME.md) for more informations

    Note : the authentication/authorization system ('msecurity') is in progress. It is part of the 1st round of development lifecycle.

---
2. **'mproducts' deals with the catalog of products (+ their categories)**. It is the only micro-service that is accessible from **authorized AND unauthorized** users. 
Unauthorized users can read data contents, while some (not all) authorized users (= employees) can add/remove/disable products and/or categories.
  (note : this service is partially available, and is part of the 1st round of development cycle)

see: [README.md](ventalis_mproducts%2FREADME.md) for more informations

    Note : the catalog/products system ('mproducts') is in progress. It is part of the 1st round of development lifecycle.

---
3. **'morders' deals with client orders**. Only users will have read/write access to it. While, Employees will have only read access (to consult and prepare orders).

see: [README.md](ventalis_morders%2FREADME.md) for more informations

    Note : the messaging system ('morders') is progress and will the 2nd part of development lifecycle.

---
4. **'mmessages' is a messaging system**. As it has no relationship with other services (except authentication/authorization), it was pretty obvious to "detach" this service from the others.

see: [README.md](ventalis_mmessages%2FREADME.md) for more informations

    Note : the messaging system ('mmessages') is progress and will the 3rd part of development lifecycle.

---
5. **'mmail'** is actually not poart of the micro-service system itself* : it's a simple mail server and is supposed to work as a standalone part and should NOT interact with other micro-services nor gateway. Also, by nature, it does not hold or iteract with any database.

see: [README.md](ventalis_mmail%2FREADME.md) for more informations

    Note : the mail server ('mmail') is in progress too (not tested yet), and is part of the 1st round of dev's cycle too.

*The main reasons to detach this service are :
- to prevent any attack from non-secured endpoint. The mail server will filter messages, then forward them a main contact mailbox. 
This main mailbox can also filter again and then redirect to the actual mailbox (let say 'contact@ventalis.fr').
- there is no direct contact email text stored on the website's public pages themselves. 
- 'mmail' doesn't have any database under the hood neither. So no persistent datas will be stored by this service and, therefore, no data to steal and/or to be protected against any attacking.

## Functional details

Employee account are created and managed by special users (= Administrators or 'Admin').
While User accounts (for clients) are directly created on the website itself.
All those 3 types of account can log in the website, then will have access to a special dedicated space.

    This section is not fully edited yet. Please come back later for any update

### Reference Documentation and Guide
[See HELP.md file](./HELP.md)