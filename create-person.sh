#!/bin/bash
curl -w "\n" \
-H "Content-Type: application/json" \
-d '{ "name" : "Luram Archanjo", "age" : 25 }' \
-X POST \
http://localhost:8080/persons