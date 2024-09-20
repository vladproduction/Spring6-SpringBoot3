FROM eclipse-temurin:17

LABEL mentainer="vproductionsd@gmail.com"

WORKDIR /app

COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/sb-docker-demo.jar

ENTRYPOINT ["java", "-jar", "sb-docker-demo.jar"]