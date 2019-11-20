#!/bin/bash
echo "--------------------------------------------------------------------------------------------"
echo "Packing application"
echo "--------------------------------------------------------------------------------------------"
mvn clean package -Pnative -Dquarkus.native.container-build=true

echo "--------------------------------------------------------------------------------------------"
echo "Building image"
echo "--------------------------------------------------------------------------------------------"
docker build -f src/main/docker/Dockerfile.native -t quarkus-native .

echo "--------------------------------------------------------------------------------------------"
echo "Running image"
echo "--------------------------------------------------------------------------------------------"
docker run -i --rm --net=host quarkus-native