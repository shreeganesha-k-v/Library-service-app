# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file to the container
COPY target/libraryservice-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your service runs on
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

LABEL maintainer="shreeganeshakv444@gmail.com"
