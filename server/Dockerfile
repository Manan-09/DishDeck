# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/dishdeck-0.0.1-SNAPSHOT.jar /app/
EXPOSE 8080

# Specify the command to run on container startup
CMD ["java", "-jar", "dishdeck-0.0.1-SNAPSHOT.jar"]