# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the project’s build artifact (JAR file) to the container
COPY ./homepage-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Make port 8080 available to the world outside this container
EXPOSE 8080