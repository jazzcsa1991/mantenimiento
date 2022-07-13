#STAGE 1
FROM maven:3.8.2-jdk-11-slim AS builder
LABEL url=""
RUN mkdir app
WORKDIR /app
COPY pom.xml .
RUN mvn -e -B dependency:go-offline
COPY src ./src
RUN mvn -e -B package -DskipTests

#Stage2
FROM amazoncorretto:11.0.12-alpine AS release
LABEL url="" project="Mantenimiento"
RUN addgroup -S htsgroup && adduser -S -s /bin/false htsuser -G htsgroup
RUN mkdir app && chown -R htsuser:htsgroup /app
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
USER htsuser:htsgroup
EXPOSE 5055
CMD ["java", "-jar", "backend-0.0.1-SNAPSHOT.jar"]