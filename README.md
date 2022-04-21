# Demo MicroService for DroidCon

## _A Kotlin and Micronaut Microservice_

This Service the demonstrates about the similarities with respect to the android development process for a starter.
Especially in the areas of:
- Architecture
- Unit Testing
- Programming Languages
- Database Layers and ORMs
- etc..

More Information can be found in the DroidCon [Presentation](https://docs.google.com/presentation/d/11Z7xTuXT9QSo3By-sy_1XR5EXlfW1e70SgWEMTHYGDI/edit?usp=sharing)


## Build
In order to build the service (locally), the project uses gradle build tool:

###Set Up the Database
Install and open [Docker](https://www.docker.com/get-started/) application.

And just run the docker compose file from project root.

```sh
docker-compose -f docker-compose-local.yml up
```
✨your db is up and running✨

###Run the service
Execute below commands to run the service that connects to the db running in docker.

```sh
./gradlew build
./gradlew assemble
java -jar ~/build/libs/droidconmicroservice-0.1-all.jar
```

The server should be up and running at:
http://localhost:8080/
