# client-profile
client-profile microservice for load balancing

# Build Jar file
Use maven to build jar file `mvn clean install -DskipTests`

# Build Docker image
Use `Dockerfile` to build & run the app on Docker container
- Command `docker build -t turong/client-profile .` to build the image with tag
- Command `docker run -e "SPRING_PROFILES_ACTIVE=docker" -p 8581:8581 turong/client-profile` to run the app on Docker container

Note: the docker service should be installed at your local.