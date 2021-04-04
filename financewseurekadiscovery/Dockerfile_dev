FROM openjdk:11-jre-slim
COPY target/eureka-0.0.1-SNAPSHOT.jar /usr/local/lib/eurekadiscovery.jar
EXPOSE 28761
ENTRYPOINT ["java","-jar","/usr/local/lib/eurekadiscovery.jar"]