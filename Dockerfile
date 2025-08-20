FROM ubuntu:latest
LABEL authors="maythe"

ENTRYPOINT ["top", "-b"]