FROM openjdk:latest
ADD target/bill.jar bill.jar
EXPOSE 8088
ENTRYPOINT ["java" ,"-jar", "bill.jar"]