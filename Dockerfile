FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar BlockEdu.jar
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "BlockEdu.jar"]
