FROM openjdk:11-jre-slim
COPY target/gateway-0.0.1-SNAPSHOT.jar /usr/local/lib/gatewayservice.jar
EXPOSE 28762
ENTRYPOINT ["java","-jar","/usr/local/lib/gatewayservice.jar"]