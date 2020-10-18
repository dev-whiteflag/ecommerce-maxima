FROM openjdk:14.0.2-oraclelinux8

# ENV Variables
ENV TZ=America/Sao_Paulo
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

# Setting up Git
RUN microdnf install git -y

# Creating User and Permissions
RUN adduser MaximaBot
USER root
RUN chmod a+w usr
USER MaximaBot

#Setting Git config
WORKDIR /home/MaximaBot
RUN git config --global user.email "bot@gitbot.com"
RUN git config --global user.name "Git Bot"

# Creating local Git repository for Config Server
RUN mkdir deployment
WORKDIR /home/MaximaBot/deployment
RUN mkdir maxima-config && cd maxima-config && git init

# Moving initial configurations from repo to local
COPY ./repo/** /home/MaximaBot/deployment/maxima-config/
RUN cd maxima-config && git add . && git commit -m "feat: initial commit"

# Copying config server's jar
COPY target/config**.jar /home/MaximaBot/deployment/
RUN mv config**.jar app.jar

# Wrapping it all up
EXPOSE 8091/tcp
USER root
RUN chown MaximaBot app.jar
USER MaximaBot
ENTRYPOINT ["java", "-jar", "app.jar"]
