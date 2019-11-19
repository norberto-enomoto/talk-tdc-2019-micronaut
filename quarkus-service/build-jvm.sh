#!/bin/bash
echo "Building image"
mvn clean package
docker build -f src/main/docker/Dockerfile.jvm -t quarkus-jvm .

echo "Running image"
docker run -i --rm --net=host quarkus-jvm