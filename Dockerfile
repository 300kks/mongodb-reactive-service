FROM adoptopenjdk/openjdk11
LABEL "Description" = "World Service"
COPY target/*.jar world-service.jar
ENTRYPOINT ["java", "-jar", "/world-service.jar"]