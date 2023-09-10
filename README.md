### This project is all about deploying various container through docker compose container management tool and create inter communication with in containers
docker compose manages 3 containers
- Database container - **Postgresql**
- Databse administrator - **PgAdmin**
- Backend application  -**Spring boot rest api**
###  Postgresql Container
This container is for databse application. Spring boot application will connect to postgres databse. We have used **postgres:latest** image for creating postgres container. please refer for details [https://hub.docker.com/_/postgres]

> :notes: Below enviornment variables must be provided for successful this container creation 
  + POSTGRES_DB: < Name of the database >
  + POSTGRES_USER: < User Name of the database > 
  + POSTGRES_PASSWORD: < Password of the databse >

###  PgAdmin Container
This container is for administrative purpose. We have connected to the databse and insterded one record in 'student' table which is used in the spring boot application. please check below screenshot to connect the database using pgadmin application running as container. we have used **dpage/pgadmin4:latest** image for creating pgAdmin container. please refer for details [https://www.pgadmin.org/docs/pgadmin4/latest/container_deployment.html]
+ [Application url - http://localhost:8080]
  
![image](https://github.com/mail2mrcm/docker/assets/118661926/ef3a3ffd-8b15-40e9-86df-4add4028b8a8)

![image](https://github.com/mail2mrcm/docker/assets/118661926/bc7e59e8-cdd1-48ab-8740-2e37d34c9575)

> ⚠️: While creating server in pgAdmin to connect database please remeber databse name should be exactly same as mentioned in the service name of the container in docker compose file.

> :notes: Below enviornment variables must be provided for successful this container creation 
  + PGADMIN_DEFAULT_PASSWORD: < Name PgAdmin master password >
  + PGADMIN_DEFAULT_EMAIL: [mail2mrcm@gmail.com]

###  Spring Boot Container
This is a very simple restful GET API for displying `Hello World!` if there is no entry in the 'student' table of the above database.  This application checks entry in student table and if there is entry then it displays `Hello Chandan` **[Name of the stdent]** othersie it displays `Hello World!`

+ [Application url - http://localhost:8081]
  
> ⚠️: As this application depends on postgresql database so databse to be started before this application hence we have used **dependes_on** attribute of docker compose. please put attention on this atribute.

> ⚠️: Remember databse host name should be exactly same as the service name of the postgresql i.e., `db`.

> :notes: Below enviornment variables must be provided for successful this container creation 
  + DB_HOST_URL: **jdbc:postgresql://db:5432/postgres**
  + DB_USER: < Name of the databse user>
  + DB_PASSWORD: < databse password>

Please follow spring boot project for the details and also ```application.properties``` file for understanding the use of above said  environmen varibales.
```diff
- Dockerfile - This is used to build the image of spring boot application.
- application.properties  - Contains all databse related properties and set corresponding enviornment variables which is provided in dcker compose file.
``` 
###  Command to be executed after setting up the project
+ application build - **mvn clean install**
+ docker build - **docker build -t <repositoryname/imagename:tag name> ./**
                   docker build mail2mrcm/helloworld-api:latest ./
+ docker push - **docker push <repositoryname/imagename:tag name>**
                  docker push mail2mrcm/helloworld-api:latest ./
+ docker compose run -  **docker-compose up -d**
+ stop all containers - **docker-compose stop**
