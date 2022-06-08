FROM openjdk:8
EXPOSE 8082
ADD target/projectone1.jar app.jar
ENTRYPOINT [ "java" , "-jar" , "/app.jar"]