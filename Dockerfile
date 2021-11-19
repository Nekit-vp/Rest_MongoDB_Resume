FROM adoptopenjdk/openjdk11
WORKDIR /restMongoDB
COPY /target/restMongoDB-0.0.1-SNAPSHOT.jar /restMongoDB
CMD ["java", "-jar", "/restMongoDB/restMongoDB-0.0.1-SNAPSHOT.jar"]