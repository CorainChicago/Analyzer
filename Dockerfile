FROM openjdk:11

RUN mkdir -p /app
WORKDIR /app

COPY ./build/libs/app.jar .

CMD ["java", "-jar", "-Dspring.data.mongodb.uri=mongodb://mongo/test", "app.jar"]