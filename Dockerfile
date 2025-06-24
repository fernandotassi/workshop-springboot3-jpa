from ubuntu:latest as build

run apt update
run apt install openjdk-17-jdk -y
copy . .

run apt install maven -y
run mvn clean install

from openjdk:17-jdk-slim

expose 8080

copy --from=build /target/udem-0.0.1-SNAPSHOT.jar app.jar

entrypoint ["java", "-jar", "app.jar"]
