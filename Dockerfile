# Stage 1: Build the Spring Boot application using Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy pom.xml first
COPY pom.xml .

# Download dependencies (helps caching)
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests

# Stage 2: Lightweight runtime image
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy generated jar
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8082

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]

