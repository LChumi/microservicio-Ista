# Dockerfile for microservice-gateway

FROM openjdk:17-jdk-slim
COPY target/microservices-gateway-1-SNAPSHOT.jar /app/microservice-gateway.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "microservice-gateway.jar"]
