FROM openjdk:latest
ADD target/pizza-catalogue.jar PizzaCatalogue.jar
EXPOSE 8086
ENTRYPOINT ["java" ,"-jar", "PizzaCatalogue.jar"]