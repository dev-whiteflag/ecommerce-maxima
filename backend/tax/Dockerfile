FROM openjdk:14.0.2-oraclelinux8

# ENV Variables
ENV TZ=America/Sao_Paulo
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

# Creating User and Permissions
RUN adduser MaximaBot
USER root
RUN chmod a+w usr
USER MaximaBot

#Setting up Deployment
WORKDIR /home/MaximaBot
RUN mkdir deployment
WORKDIR /home/MaximaBot/deployment

# Copying server jar
COPY target/tax**.jar /home/MaximaBot/deployment/
RUN mv tax**.jar app.jar

# Wrapping it all up
EXPOSE 8082/tcp
USER root
RUN chown MaximaBot app.jar
USER MaximaBot
ENTRYPOINT ["java", "-jar", "app.jar"]
