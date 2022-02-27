FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.1.13-slim
VOLUME /tmp
EXPOSE 8080
ADD target/*jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.edge=file:/dev/./urandom -jar /app.jar"]
