# Dockerfile for management-service
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven/Gradle-built JAR file into the container
COPY target/librarymanagement-0.0.1-SNAPSHOT.jar library-management-service.jar

# Expose the port the service runs on
EXPOSE 8082

# Run the JAR file
ENTRYPOINT ["java", "-jar", "library-management-service.jar"]
