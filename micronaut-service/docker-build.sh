docker build . -t micronaut-service
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run --rm --net=host --name=micronaut-service micronaut-service"