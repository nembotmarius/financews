FROM openjdk:11-jre-slim
COPY target/clients-0.0.1-SNAPSHOT.jar /usr/local/lib/clientservice.jar
EXPOSE 28183
ENTRYPOINT ["java","-jar","/usr/local/lib/clientservice.jar"]