FROM openjdk:21-slim

WORKDIR /app

COPY target/transaction-tracking-service-0.0.1-SNAPSHOT.jar transaction-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]