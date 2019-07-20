FROM openjdk:11-jdk-stretch

ADD /target/routing-server-0.0.1-SNAPSHOT.jar /usr/src/routing-server-0.0.1-SNAPSHOT.jar

ADD /src/main/java/com/stackroute/seedData/foodavailabilityseed.xlsx /usr/src/foodavailabilityseed.xlsx

WORKDIR /usr/src

ENTRYPOINT ["java","-jar","routing-server-0.0.1-SNAPSHOT.jar"]
