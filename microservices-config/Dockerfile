#Usar la imagen base de OPENJDK
FROM openjdk:17-jdk-slim

#Copiar el archiovo desde tarjet al contenedor
COPY target/microservices-config-1-SNAPSHOT.jar /app/microservice-config.jar

#Establecer el directorio de trabajo
WORKDIR /app

#Puerto que se ejecutara la aplicacion
EXPOSE 8888

#Comando para ejecutar la aplicacion
ENTRYPOINT ["java", "-jar", "microservice-config.jar"]