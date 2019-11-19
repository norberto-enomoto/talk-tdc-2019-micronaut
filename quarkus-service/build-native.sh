#!/bin/bash
echo "Building image"
mvn clean package -Pnative -Dquarkus.native.container-build=true
docker build -f src/main/docker/Dockerfile.native -t quarkus-native .

echo "Running image"
docker run -i --rm --net=host quarkus-native