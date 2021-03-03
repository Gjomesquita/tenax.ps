FROM openjdk

WORKDIR /app

COPY target/tenax-0.0.1-SNAPSHOT.jar /app/tenax.jar

ENTRYPOINT ["java", "-jar", "tenax.jar"]