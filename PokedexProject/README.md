After cloning this repository, if you have a Java environment on your machine, you can directly run the commands.


# Build the project

```
./gradlew build
```



# Run the application

```
./gradlew run
```

To run the application with command line arguments :

```
./gradlew run --args="<pokemonId> [-d <databasePath>] [-f <html/csv/text>]"
```

# Generate documentation
```
./gradlew javadoc
```
Then open [/build/docs/javadoc/index.html](./build/docs/javadoc/index.html) with your favorite web browser 