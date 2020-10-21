FROM node:12.2.0

# ENV Variables
ENV TZ=America/Sao_Paulo
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

# Setting up Chrome for Protractor tests
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
RUN sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'
RUN apt-get update && apt-get install -yq google-chrome-stable

# Set working directory
WORKDIR /app

# Add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# Setting up app dependencies
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli

# Copying app files
COPY . /app

# Wrapping it all up
EXPOSE 4200/tcp
ENTRYPOINT ["npm", "start"]
