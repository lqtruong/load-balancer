# mail-service
mail-service microservice

# Build Jar file
Use maven to build jar file `mvn clean install -DskipTests`

# Build Docker image
Use `Dockerfile` to build & run the app on Docker container
- Command `docker build -t turong/mail-service .` to build the image with tag
- Command `docker run -e "SPRING_PROFILES_ACTIVE=docker" -p 8582:8582 turong/mail-service` to run the app on Docker container

Note: the docker service should be installed at your local.