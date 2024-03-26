# Dockerfile for building the Maven project

# Use an official Maven image as a base
FROM maven:3.6.3-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files into the container
COPY . .

# Build the Maven project
RUN mvn clean install

# Use a lightweight base image for the application
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled application JAR file from the build stage into the container
COPY --from=build /app/target/*.jar app.jar

# Specify the command to run the application
CMD ["java", "-jar", "app.jar"]
