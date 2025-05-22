# Use lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Copy the built JAR to the image
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render uses $PORT automatically)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
