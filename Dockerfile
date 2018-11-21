# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="santanudey_bec@yahoo.co.in"

# Add a volume pointing to /tmp
VOLUME /tmp
VOLUME /logs

# Make port 3333 available to the world outside this container
EXPOSE 3333

# The application's jar file
ARG JAR_FILE=target/AccountService-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} accountService.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/accountService.jar"]
