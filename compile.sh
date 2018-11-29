#!/usr/bin/bash

FILENAME=${1?Error: no filename given}

javac -d . sources/*.java
javac -cp . $FILENAME.java
java -cp . $FILENAME