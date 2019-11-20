#!/bin/bash
curl -w "\n" \
-X DELETE \
http://localhost:8080/persons/$1