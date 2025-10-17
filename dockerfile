FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
ENV PORT=8081
EXPOSE 8081
COPY --from=build /app/target/*.jar app.jar
CMD ["sh","-c","java -jar app.jar"]
