FROM maven:3.8.7-openjdk-18 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build/
RUN mvn clean package -Dmaven.test.skip

FROM openjdk:17
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/librarysystem-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "librarysystem-0.0.1-SNAPSHOT.jar"]