# client-account
client-account microservice for load balancing

# Build Jar file
Use maven to build jar file `mvn clean install -DskipTests`

# Build Docker image
Use `Dockerfile` to build & run the app on Docker container
- Command `docker build -t turong/client-account .` to build the image with tag
- Command `docker run -e "SPRING_PROFILES_ACTIVE=docker" -p 8580:8580 turong/client-account` to run the app on Docker container

Note: the docker service should be installed at your local.