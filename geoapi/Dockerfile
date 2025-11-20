
#Etapa 1 — Build de la app
FROM maven:3.9.8-eclipse-temurin-21 AS builder

# Crear carpeta de trabajo
WORKDIR /app

# Copiar solo el pom primero (para aprovechar cache de dependencias)
COPY pom.xml .

# Descargar dependencias
RUN mvn -q -e dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar y empacar sin tests
RUN mvn -q -e clean package -DskipTests

# ---------------------------------------------------

# Etapa 2 — Imagen final ligera
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiar el JAR generado
COPY --from=builder /app/target/*.jar app.jar

# Variable de entorno para Google API Key
# (puede venir desde docker-compose)
ENV GOOGLE_MAPS_APIKEY=""

# Exponer el puerto (si tu microservicio usa 8088)
EXPOSE 8088

# Comando de ejecución
ENTRYPOINT ["java", "-jar", "app.jar"]