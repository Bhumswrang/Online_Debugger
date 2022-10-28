FROM openjdk:latest
ADD target/order.jar order.jar
EXPOSE 8089
ENTRYPOINT ["java" ,"-jar", "order.jar"]