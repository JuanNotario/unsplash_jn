FROM openjdk:11
ADD target/webservice_unsplash_jn-0.0.1-SNAPSHOT.jar webservice_unsplash_jn-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "webservice_unsplash_jn-0.0.1-SNAPSHOT.jar"]