FROM openjdk:11

RUN mkdir -p /app
WORKDIR /app

COPY ./java.sh .
RUN chmod 777 java.sh
COPY ./build/libs/app.jar .

#ENTRYPOINT ["/bin/bash", "/app/java.sh"]
CMD ["java", "-jar", "app.jar"]