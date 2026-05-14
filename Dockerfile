# === Stage 1: Build Maven ===
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copia o pom primeiro pra aproveitar cache de dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o codigo fonte e builda
COPY src ./src
RUN mvn clean package -DskipTests -B

# === Stage 2: Runtime ===
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia somente o JAR final do stage de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
