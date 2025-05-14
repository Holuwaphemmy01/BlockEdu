# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the local code to the container
COPY target/BlockEdu-0.0.1-SNAPSHOT.jar /app/blockedu.jar

# Make port 8080 available to the world outside the container
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "blockedu.jar"]
