FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/Employee-management-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]