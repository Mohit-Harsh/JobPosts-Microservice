# JobPosts-Microservice

# Deploy using docker compose v2

### By cloning the repository

* Clone git repository
  
  ```git
   git clone https://github.com/Mohit-Harsh/JobPosts-Microservice.git
  ```
* Change directory
  
  ```linux
    cd JobPosts-Microservice/
  ```
* Use docker compose to create and start the containers
  
  ```docker
    docker compose -f docker-compose.yml up
  ```

### Without cloning the repository

* create a docker-compose.yml

  ```linux
  touch docker-compose.yml
  ```

* contents of docker-compose.yml file

  ```yml
  services:
  microservice:
    build: https://github.com/Mohit-Harsh/JobPosts-Microservice.git#main:JobPosts
    ports:
      - "8080:8080"
    links:
      - "database:jobsdb"
    depends_on:
      - database

  database:
    build: https://github.com/Mohit-Harsh/JobPosts-Microservice.git#main:PostgresDB
    ports:
      - "5432:5432"
  ```

* Run the following command to create and start the containers
 
    ```docker
    docker compose -f docker-compose.yml up
    ```

### Deploy using docker

* Build the image of PostgresDB

  ```docker
  docker build -t postgresdb:latest https://github.com/Mohit-Harsh/JobPosts-Microservice.git#main:PostgresDB
  ```

* Build the image of Jobposts microservice

  ```docker
  docker build -t jobposts:latest https://github.com/Mohit-Harsh/JobPosts-Microservice.git#main:JobPosts
  ```
  
* create and start postgres container first

  ```docker
  docker run --rm -d -p 5432:5432 --name jobsdb postgresdb:latest
  ```

* create and start jobposts container

  ```docker
  docker run --rm -it -p 8080:8080 --name jobs --links jobsdb:jobsdb jobposts:latest
  ```
