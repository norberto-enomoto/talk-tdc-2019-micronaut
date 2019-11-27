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

`docker run -d -p 5432:5432 --name postgres postgres`

`docker exec -it postgres bash`

`psql -U postgres`

`CREATE DATABASE "spring-service";`

# Testing

## Intellij

Open the file `test.http` and enjoy
