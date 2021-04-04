FROM openjdk:11-jre-slim
COPY target/security-0.0.1-SNAPSHOT.jar /usr/local/lib/securityservice.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/securityservice.jar"]