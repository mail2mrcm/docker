FROM eclipse-temurin:17.0.8_7-jre-jammy
RUN mkdir /opt/app
ADD target/helloworld-rest-api-1.0.0.jar /opt/app/demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app/demo.jar"]