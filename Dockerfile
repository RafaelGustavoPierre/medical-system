FROM eclipse-temurin:21

WORKDIR /app

COPY target/medical-system-0.0.1-SNAPSHOT.jar /app/api.jar

EXPOSE 8080

CMD ["java", "-jar", "api.jar"]