docker build . -t micronaut-service
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -d --net=host --name=micronaut-service micronaut-service:latest"