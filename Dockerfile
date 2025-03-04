# Use Maven to build the JAR inside the container
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Use JDK 21 for running the app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/Employee-management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]