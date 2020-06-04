FROM openjdk:11-jdk-slim
ADD build/libs/converter.jar .
EXPOSE 8000
CMD java -jar converter.jar
