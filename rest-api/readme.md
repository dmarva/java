To execute the program it must be downloaded and compiled from (https://github.com/dmarva/java/tree/master/rest-api), it must execute the following sql sentences:

CREATE SCHEMA 'dani_api';

CREATE USER 'dani'@'localhost' IDENTIFIED BY 't3st1ng';
GRANT ALL ON *.* TO 'dani_api'@'localhost';
FLUSH PRIVILEGES;

The table creation is done via flyway when starts the microservice.
The project can be deployed in any microservice environment, if haven't one, can be deployed one from https://github.com/dmarva/java/tree/master/api-gateway and https://github.com/dmarva/java/tree/master/eureka-server.

I chose to create it as a microservice, because it grants more scalability, and allows to upload a new microservice instance instead of upload the whole application, that usually consumes more resources.

