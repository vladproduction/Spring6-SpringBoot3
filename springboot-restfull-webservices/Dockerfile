FROM eclipse-temurin:17

LABEL mentainer="vladproduction.net@gmail.com"

WORKDIR /app

COPY target/springboot-restfull-webservices-0.0.1-SNAPSHOT.jar /app/springboot-restfull-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-restfull-webservices.jar"]