FROM openjdk:14.0.2-oraclelinux8

# ENV Variables
ENV TZ=America/Sao_Paulo
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

# Creating User
RUN adduser MaximaBot
USER MaximaBot
WORKDIR /$HOME/

# Setting Permissions
USER root
RUN chmod a+w usr
USER MaximaBot

#Setting Git config
WORKDIR /$HOME/usr

# Creating local Git repository for Config Server
RUN mkdir deployment
WORKDIR /usr/deployment

# Copying config server's jar
COPY target/discovery**.jar /usr/deployment/
RUN mv discovery**.jar app.jar

# Wrapping it all up
EXPOSE 8092/tcp
USER root
RUN chown MaximaBot app.jar
USER MaximaBot
ENTRYPOINT ["java", "-jar", "app.jar"]
