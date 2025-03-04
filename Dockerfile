# Use Maven to build the JAR inside the container
FROM eclipse-temurin:21 AS builder
WORKDIR /app
COPY . .
RUN chmod +x mvnw  # Add this line to make mvnw executable
RUN ./mvnw clean package -DskipTests

# Use a smaller JDK image for running the app
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/Employee-management-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]