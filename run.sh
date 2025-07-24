#!/bin/bash

SRC_DIR="source"
OUT_DIR="class"

# Create output directory if it doesn't exist
mkdir -p "$OUT_DIR"

# Compile all .java files from source directory to class directory
javac -d "$OUT_DIR" $(find "$SRC_DIR" -name "*.java")

# If compilation succeeded, run the main class
if [ $? -eq 0 ]; then
  java -cp "$OUT_DIR" Main "$@"
else
  echo "Compilation failed."
fi
