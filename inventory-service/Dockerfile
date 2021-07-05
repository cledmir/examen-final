FROM openjdk:11
VOLUME /tmp
ARG build/libs/*.jar
EXPOSE 8091
COPY build/libs/*.jar social-service.jar
ENTRYPOINT ["java","-jar","/social-service.jar"]