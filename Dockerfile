FROM openjdk:24-slim-bullseye
COPY JobPosts-Spring-React-1.jar .
EXPOSE 8080
CMD ["java","-jar","JobPosts-Spring-React-1.jar"]
