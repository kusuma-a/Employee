# Use Maven to build the JAR inside the container
FROM maven:3.8.5-openjdk-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a smaller JDK image for running the app
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/Employee-management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]