# Overview

# Setup

## GraalVM

First, install the [SDK Man]

Then, run the command:

`sdk install java 19.2.1-grl`

and

`sdk use java 19.2.1-grl`

[SDK Man]: https://sdkman.io/

## Postgres

Run the command bellow

`docker run -d --name postgres --net=host postgres`

`docker exec -it postgres bash`

`psql -U postgres`

`CREATE DATABASE "quarkus-service";`

# Testing

## GraalVM

Before, build the application:

`mvn clean package`

then, build the image:

`docker build -f src/main/docker/Dockerfile.jvm -t quarkus-jvm .`

Start the application:

`docker run -i --rm --net=host quarkus-jvm`

## Native Image

Before, build the application:

`mvn clean package -Pnative -Dquarkus.native.container-build=true`

Then, build the image:

`docker build -f src/main/docker/Dockerfile.native -t quarkus-native .`

Start the application:

`docker run -i --rm --net=host quarkus-native`

## Intellij

Open the file `test.http` and enjoy
