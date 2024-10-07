# Paso 1: Usar una imagen de Maven con OpenJDK 21 para construir el JAR
FROM maven:3.9.9-amazoncorretto-21 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias
COPY pom.xml .
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
COPY --from=build /app/target/noCountry-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponer el puerto en el que la aplicación correrá
EXPOSE 8090

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]