#!/usr/bin/env sh

../gradlew clean build -p ../

docker rm border-state-collector-app

docker buildx create --use

docker buildx build \
  --platform linux/amd64,linux/arm64 \
  -t menkomihail/border-state-collector-app:v1.0.6 \
  -f app/Dockerfile \
  ../ \
  --push