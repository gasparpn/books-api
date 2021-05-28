run:
	./gradlew bootRun --args="--spring.profiles.active=local"
build-gradle:
	./gradlew build
tests:
	./gradlew clean test
