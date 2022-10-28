FROM openjdk:latest
ADD target/user.jar User.jar
EXPOSE 8083
ENTRYPOINT ["java" ,"-jar", "User.jar"]