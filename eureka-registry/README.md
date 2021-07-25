# eureka-registry
Microservices Registration and Discovery

# Build Jar file
Use maven to build jar file `mvn clean install -DskipTests`

# Build Docker image
Use `Dockerfile` to build & run the app on Docker container
- Command `docker build -t turong/eureka-registry .` to build the image with tag
- Command `docker run -e "SPRING_PROFILES_ACTIVE=docker" -p 8761:8761 turong/eureka-registry` to run the app on Docker container

Note: the docker service should be installed at your local.