#!/bin/bash
curl -w "\n" \
-H "Content-Type: application/json" \
-d '{ "name" : "Luram Archanjo", "age" : 30 }' \
-X PUT \
http://localhost:8080/persons/$1