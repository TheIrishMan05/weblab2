FROM gradle:8.8-jdk17 AS build
WORKDIR /app

COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon || return 0

COPY src /app/src
RUN gradle clean build --no-daemon

FROM quay.io/wildfly/wildfly:latest-jdk17

ENV JBOSS_HOME=/opt/jboss/wildfly
ENV PATH="${JBOSS_HOME}/bin:${PATH}"
ENV WILDFLY_USER=admin
ENV WILDFLY_PASSWORD=Admin@123

COPY --from=build /app/build/libs/*.war ${JBOSS_HOME}/standalone/deployments/

RUN chmod +x ${JBOSS_HOME}/bin/add-user.sh

CMD ["/bin/bash", "-c", "${JBOSS_HOME}/bin/add-user.sh $WILDFLY_USER $WILDFLY_PASSWORD --silent && ${JBOSS_HOME}/bin/standalone.sh -b 0.0.0.0"]