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
		#rm manual - run 'rm --help'
		rm -r maven/
	fi
	#curl manual - run 'curl --help'
	curl -o maven.zip https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip
	#unzip manual - run 'unzip --help'
	unzip maven.zip
	rm maven.zip
	#mv manual - run 'mv --help'
	mv apache-maven-* maven
	#alias manual - run 'alias --help'
	#PWD is the dynamic environment variable storing the current working directory
	alias mvn=$PWD"/maven/bin/mvn"
	
	# setup jeromq dependencies
	mvn install:install-file -Dfile=dependencies/jeromq-0.5.2.jar -DgroupId=org.zeromq -DartifactId=jeromq -Dversion=0.5.2 -Dpackaging=jar
elif [[ $1 == "compile" ]]
then
	for project in *
	do
		if [ -f $project"/pom.xml" ]
		then
				echo "Compiling "$project
			cd $project
			mvn clean compile
			cd ..
		fi
	done
elif [[ $1 == "test" ]]
then
	for project in *
	do
		if [ -f $project"/pom.xml" ] 
		then 
			echo "Testing "$project
			cd $project
			mvn clean test
			cd ..
		fi
	done
elif [[ $1 == "run" ]]
then
	# Launch server
	echo "Launching "$project_title"Server"
	cd $project_title"Server"
	mvn clean package -q
	java -jar "target/"$project_id"-server-"$project_version".jar" > serverlog.txt &
	cd ..
	# Wait 3 seconds to ensure server has launched
	sleep 3
	# Launch client application
	echo "Launching "$project_title"Client"
	cd $project_title"Client"
	mvn javafx:run -q
	cd ..
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