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

# Testing

## Intellij

Open the file `test.http` and enjoy