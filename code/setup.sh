#!/bin/bash

#installs JeroMQ in Maven to facilitate building and packaging
mvn install:install-file -Dfile=dependencies/jeromq-0.5.2.jar -DgroupId=org.zeromq -DartifactId=jeromq -Dversion=0.5.2 -Dpackaging=jar