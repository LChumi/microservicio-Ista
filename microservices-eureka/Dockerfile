# Dockerfile for microservice-eureka

FROM openjdk:17-jdk-slim
COPY target/microservices-eureka-1-SNAPSHOT.jar /app/microservice-eureka.jar
WORKDIR /app
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "microservice-eureka.jar"]