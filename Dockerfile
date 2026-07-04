# Use a slim, official JDK runtime image
FROM openjdk:21-slim

# Set working directory inside container
WORKDIR /app

# Expose port (documentational; port mapping is done at `docker run`)
EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
