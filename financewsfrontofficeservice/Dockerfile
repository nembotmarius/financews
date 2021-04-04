FROM openjdk:11-jre-slim
COPY target/foffice-0.0.1-SNAPSHOT.jar /usr/local/lib/fofficeservice.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/fofficeservice.jar"]