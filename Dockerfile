FROM openjdk:17

COPY target/mofulusi-0.0.1-SNAPSHOT.jar /app/mofulusi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/mofulusi-0.0.1-SNAPSHOT.jar"]
