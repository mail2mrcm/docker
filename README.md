### This project is all about deploying various container through docker compose container management tool and create inter communication with in containers
docker compose manages 3 containers
- Database container - **Postgresql**
- Databse administrator - **PgAdmin**
- Backend application  -**Spring boot rest api**
###  Postgresql Container
This container is for databse application. Spring boot application will connect to postgres databse. We have used ** postgres:latest** image for creating postgres container. please refer for details [https://hub.docker.com/_/postgres]
