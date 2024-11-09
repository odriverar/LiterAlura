# Usa una imagen base de JDK para compilar la aplicación
FROM maven:3.8.4-openjdk-17 AS build
# Establece el directorio de trabajo
WORKDIR /app
# Copia el archivo de configuración de Maven y el archivo pom.xml
COPY pom.xml .
# Descarga las dependencias de Maven
RUN mvn dependency:go-offline
# Copia el código fuente de la aplicación
COPY src ./src
# Compila el proyecto y empaqueta en un archivo JAR
RUN mvn clean package -DskipTests
# Usa una imagen de JRE para ejecutar la aplicación
FROM openjdk:17-jdk-slim
# Copia el archivo JAR desde el contenedor de compilación
COPY --from=build /app/target/*.jar app.jar
# Exponer el puerto configurado en Spring Boot (8181)
EXPOSE 8181
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]