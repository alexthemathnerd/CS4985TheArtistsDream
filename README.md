# The Artist's Dream

![The Artist's Dream Logo](https://github.com/alexthemathnerd/CS4985TheArtistsDream/blob/main/code/TheArtistsDreamClient/src/main/resources/edu/westga/devops/theartistsdreamclient/icon.png)

## Purpose
To provide artists a platform to promote and showcase their artworks. Other artists or connosseurs can view and commission are.

## Installation & Setup

### Running
Start by running the `setup.h` file in the code folder.

To start the server run the following commands in the TheArtistsDreamServer folder:
1. `mvn clean package`
2. `java -jar target/the-artists-dream-server-{VERSION}.jar`

To start the client run the following command in the TheArtistsDreamClient folder:
1. `mvn javafx:run`

If you want a fast start run the `start.sh` file in the code folder.

#### Logging In
To login you can use the following accounts:

|Username|Password|
|--------|--------|
|admin|admin|

### Testing

#### Unit Testing
To test unit testing for the client or server run the following in the respective folder:

```
mvn test
```

#### Integration Testing
To test integration for the client or server run the following in the respective folder:

```
mvn verify
```

## Documentation

To see the wireframe and use cases click on this [link](https://github.com/alexthemathnerd/CS4985TheArtistsDream/tree/main/documentation).

## Authors

* Aznella Joseph
* Alexander Schmidt
* Jamia Echols
