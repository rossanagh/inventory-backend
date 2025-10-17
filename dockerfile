# ---- build stage ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

# ---- runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# portul folosit de Render (Render setează variabila PORT)
ENV PORT=8080
EXPOSE 8080

# copiem jar-ul
COPY --from=build /app/target/*.jar app.jar

# pornim aplicația Spring Boot
CMD ["java", "-jar", "app.jar"]
