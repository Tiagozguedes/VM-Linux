FROM maven:3.9-eclipse-temurin-17
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
ENTRYPOINT ["java", "-jar", "/app/target/dimdim-1.0.jar"]
