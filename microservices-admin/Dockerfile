# Dockerfile for microservice-admin

FROM openjdk:17-jdk-slim
COPY target/microservices-admin-1-SNAPSHOT.jar /app/microservice-admin.jar
WORKDIR /app
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "microservice-admin.jar"]
