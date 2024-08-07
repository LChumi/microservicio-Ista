# Dockerfile for microservice-retail

FROM openjdk:17-jdk-slim
COPY target/microservice-retail-1-SNAPSHOT.jar /app/microservice-retail.jar
WORKDIR /app
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "microservice-retail.jar"]
