# Read Me First
This projet is part of Ventalis project (back-end microservice).
This microservice is not supposed to work alone and must be run with other micro-services 
and their eco-system (Gateway, micro web-client, etc).

# Getting Started
To run this micro-service on a development environment, a MariaDB connection is needed and fully operational.
Though, you can set or reset the database content (data) and tables (schema)
by editing the application.yml configuration file :
see : src/main/resources/application.yml
Then, edit the line sql:init:mode and set to always : it will reset the database content 
(= executing the script 'data-mysql.sql' file)

**_TODO : check the assertion below about hibernate mode_**
Note that jpa:hibernate:ddl-auto: is set to 'validate' for production and testing
but should be set to and then to 'create-drop' on first launch
and then to 'none' or 'validate' for testing

### Reference Documentation and Guide
[See HELP.md file](./HELP.md)