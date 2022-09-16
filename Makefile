# Language: makefile
# Path: Makefile
build:
	./mvnw clean install

build-image:
	./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=hataraki/backend

run:
	./mvnw spring-boot:run

clean:
	./mvnw clean
