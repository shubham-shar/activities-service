FROM alpine:3.16.0 as builder
RUN apk add --no-cache openjdk17-jre
WORKDIR source
ARG JAR_FILE=target/movie-service.jar
COPY ${JAR_FILE} movie-service-SNAPSHOT.jar
EXPOSE 8095
RUN java -Djarmode=layertools -jar movie-service-SNAPSHOT.jar extract

FROM alpine:3.16.0 as runtime
RUN apk add --no-cache openjdk17-jre openssl=1.1.1q-r0 procps
WORKDIR app
ARG env_var=dev
ENV var=$env_var
COPY --from=builder source/dependencies/ ./
COPY --from=builder source/spring-boot-loader/ ./
COPY --from=builder source/snapshot-dependencies/ ./
COPY --from=builder source/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
CMD ["--spring.config.location=/config/", "--spring.profiles.active=${var}"]
