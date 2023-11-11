FROM openjdk:17-jre-slim
ADD /target/characterCounter-0.0.1-SNAPSHOT.jar characterCounter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","characterCounter-0.0.1-SNAPSHOT.jar"]
