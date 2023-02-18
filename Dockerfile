FROM openjdk:8
EXPOSE 8084
ADD target/ecommerce-docker.jar  ecommerce-docker.jar  
ENTRYPOINT ["java" ,"-jar", "/ecommerce-docker.jar"]