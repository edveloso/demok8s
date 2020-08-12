FROM harbor.ctn.prevnet/library/maven:3.6-openjdk-8 as builder
ARG  VERSION_APP_ARG
ENV  VERSION_APP=$VERSION_APP_ARG
LABEL maintainer="Ednilson Veloso <ednilson.veloso@dataprev.gov.br>" 
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build
RUN mvn versions:set -DnewVersion=${VERSION_APP} -f pom.xml
RUN mvn package -Dmaven.test.skip=true 
FROM harbor.ctn.prevnet/redhat/openjdk-11-rhel8 as package
ARG  VERSION_APP_ARG
ENV  VERSION_APP=$VERSION_APP_ARG
COPY --from=builder /build/target/demo-${VERSION_APP}.jar /home/jboss/demo-${VERSION_APP}.jar
CMD java $JAVA_OPTIONS -jar /home/jboss/demo-${VERSION_APP}.jar
EXPOSE 8181