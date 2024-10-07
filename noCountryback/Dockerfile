# Paso 1: Usar una imagen de Maven para construir el JAR
FROM maven:3.8.4-amazoncorretto-21 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y las dependencias del proyecto
COPY pom.xml .

# Descargar las dependencias del proyecto (esto se hace primero para aprovechar el cache de Docker)
RUN mvn dependency:go-offline -B

# Copiar el resto del código del proyecto
COPY src ./src

# Construir el proyecto y empaquetarlo en un JAR
RUN mvn clean package -DskipTests

# Paso 2: Crear una nueva imagen para la ejecución del JAR
FROM amazoncorretto:21-alpine3.20

# Establecer el directorio de trabajo para la imagen final
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/noCountry-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que la aplicación correrá
EXPOSE 8090

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]