# Overview

# Native image with GraalVM

1. First go to the root directory and execute the command:

`docker build . -t micronaut-service`

2. Now it is time to run our container:

`docker run -d --net=host --name=micronaut-service micronaut-service:latest`

## Testing

1. Open a terminal and execute the command:

`docker logs -f micronaut-service`

2. Make a request:

`http://localhost:8080/persons`

3. Test the memory used:

`docker exec -it micronaut-service ps -eo rss,comm`

# Utils commands

ps -eo pid,rss,comm | grep $(lsof -t -i :8080 -s TCP:LISTEN)