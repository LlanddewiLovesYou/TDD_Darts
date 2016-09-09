# Java Skeleton

This skeleton uses [Gradle](http://gradle.org) to compile and run the tests. Gradle is self contained within the project so you won't need to install anything manually.

## Steps

1. Using a terminal, change into the `java` directory.
2. Run `./gradlew test` to run the tests. 
	* If all tests pass you will will see `BUILD SUCCESSFUL` otherwise you will see a message describing the tests that failed.
	* This will create a directory named `build`, the compiled Java classes are placed into it.
3. Run `./gradlew clean` to remove the `build` directory and its contents.
