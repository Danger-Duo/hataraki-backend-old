# Hataraki Backend

RESTful API service for Hataraki in Java Spring 5.

## Pre-requisite Installation

- Java JDK 17 (any dist)
- GNU Make

## Recommended tools

- VSCode

## First time setup

1. Duplicate file `config/application.properties.example` and rename it to `config/application.properties`
2. Fill in the new file with appropriate values

## Running the app

```bash
# run in development mode
make run

# package and run jar (production)
make build
./bootstrap.sh
```
