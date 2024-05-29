FROM maven:3.8.5-openjdk AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.-jdk-slim
# COPY --from=build/target/emailWebAPI-0.0.1-SNAPSHOT.jar emailWebAPI.jar
COPY . .
EXPOSE  8080
CMD ["java","-jar","emailWebAPI-0.0.1-SNAPSHOT.jar"]

#ok
