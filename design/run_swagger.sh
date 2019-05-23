#!/bin/bash

docker run -d -p 80:8080 -v $PWD/api:/usr/share/nginx/html/api -e API_URL=api/manage_sys.yaml swaggerapi/swagger-ui
