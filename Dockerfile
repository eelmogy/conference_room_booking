FROM openjdk:17-jdk-slim

LABEL maintainer="em.elmogy@gmail.com"

VOLUME /tmp

COPY target/conference-room-booking-0.0.1-SNAPSHOT.jar conference-booking-api.jar

ENTRYPOINT ["java", "-jar", "/conference-booking-api.jar"]

