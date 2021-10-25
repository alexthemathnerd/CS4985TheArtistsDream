#!/bin/bash

project_title="TheArtistsDream"
project_id="the-artists-dream"
project_version="1.0-SNAPSHOT"

#installs JeroMQ in Maven to facilitate building and packaging

if [[ $1 == "setup" ]]
then
	#SETUP Maven
	echo "Setting up Maven"
	if [ -d "maven" ] 
	then
		rm -r maven/
	fi
	curl -o maven.zip https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip
	unzip maven.zip
	rm maven.zip
	mv apache-maven-* maven
	#PWD is the dynamic environment variable storing the current working directory
	#alias mvn=$PWD"/maven/bin/mvn"
	
	# setup jeromq dependencies
	mvn install:install-file -Dfile=dependencies/jeromq-0.5.2.jar -DgroupId=org.zeromq -DartifactId=jeromq -Dversion=0.5.2 -Dpackaging=jar
elif [[ $1 == "compile" ]]
then
	for project in *
	do
		if [ -f "$project""/pom.xml" ]
		then
			echo "Compiling '$project'"
			cd "$project" || exit 255
			mvn clean compile
			cd ..
		fi
	done
elif [[ $1 == "test" ]]
then
	for project in *
	do
		if [ -f "$project""/pom.xml" ]
		then 
			echo "Testing '$project'"
			cd "$project" || exit 255
			mvn clean test
			cd ..
		fi
	done
elif [[ $1 == "run" ]]
then
	# Launch server
	echo "Launching '$project_title'Server"
	cd $project_title"Server" || exit 255
	mvn clean package -q
	java -jar "target/$project_id-server-$project_version.jar" &
	trap 'kill $!' SIGINT SIGTERM ERR EXIT
	cd ..
	# Wait 3 seconds to ensure server has launched
	sleep 3
	# Launch client application
	echo "Launching '$project_title'Client"
	cd $project_title"Client" || exit 255
	mvn javafx:run -q
	cd ..
elif [[ $1 == "verify" ]]
then
	for project in *
  do
		if [ -f "$project""/pom.xml" ]
		then
			echo "Verifying '$project'"
			cd "$project" || exit 255
			mvn clean verify
			cd ..
		fi
  done
else
	echo "Expected Usage: setup.sh [command]"
	echo "Possible commands:"
	echo "  setup       will setup the system including all project "
	echo "               specific setup defined in a project's setup.sh"
	echo "  compile     will compile all projects"
	echo "  test        will test all projects"
	echo "  run         will launch the client system and locally launch"
	echo "               any necessary services"
fi
