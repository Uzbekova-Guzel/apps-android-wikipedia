#!/bin/bash

IMAGE_NAME="wikipedia-android-sdk"
CONTAINER_NAME="wikipedia-build-container"

docker run --rm -d --name "$CONTAINER_NAME" \
    -v ".:/project" \
    -w /project \
    "$IMAGE_NAME" \
    sleep infinity

docker exec "$CONTAINER_NAME" sh -c \
    "sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew app:clean"

docker stop "$CONTAINER_NAME"