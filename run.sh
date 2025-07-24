#!/bin/bash

# Compile all .java files in the current directory
javac *.java

# If compilation succeeded, run the main class
if [ $? -eq 0 ]; then
  java Main
else
  echo "Compilation failed."
fi
