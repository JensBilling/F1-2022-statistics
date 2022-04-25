FROM openjdk:17
COPY ./target/F1-2022-statistics-0.0.1-SNAPSHOT.jar /usr/src/f1-2022-statistics/
WORKDIR /usr/src/f1-2022-statistics/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "F1-2022-statistics-0.0.1-SNAPSHOT.jar"]