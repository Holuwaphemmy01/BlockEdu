## Use an official Java runtime as a parent image
#FROM openjdk:17-jdk-slim
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the local code to the container
#COPY target/BlockEdu-0.0.1-SNAPSHOT.jar /app/blockedu.jar
#
## Make port 8080 available to the world outside the container
#EXPOSE 8080
#
## Run the Spring Boot app
#CMD ["java", "-jar", "blockedu.jar"]


# Use Maven to build the app
FROM maven:3.9.5-eclipse-temurin-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Run the built JAR using a smaller Java image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/BlockEdu-0.0.1-SNAPSHOT.jar blockedu.jar
EXPOSE 8080
CMD ["java", "-jar", "blockedu.jar"]
