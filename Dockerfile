

FROM amazoncorretto:20

COPY target/back-0.0.1-SNAPSHOT.jar back-0.0.1-SNAPSHOT.jar 

ENTRYPOINT ["java","-jar","/back-0.0.1-SNAPSHOT.jar "]

#FROM amazoncorretto:20
#
#COPY target/back-0.0.1-SNAPSHOT.jar app.jar
#
#ENTRYPOINT ["java","-jar","/app.jar"]