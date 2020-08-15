#!/usr/bin/env bash

./gradlew clean build && \
docker build . -t analysis-service:latest