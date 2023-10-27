FROM openjdk:17-jdk-slim-buster
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=build/libs/bits-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/app.jar"]