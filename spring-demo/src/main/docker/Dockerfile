FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD spring-demo-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Xms1g -Xmx1g"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]