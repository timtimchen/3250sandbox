
"""
This script compiles, runs, tests, and style checks Java source files for CS 3250 
Project 1: Adventure version1 program.

This script assumes:
1. Java source files are one directory below this script's working directory.
2. All Java source files are in the same directory.
3. JUnit 5 jar files are in c:\junit, including the standalone Console Launcher.
4. checkstyle utility jar file and style file are in directory c:\checkstyle.
   This one uses the sun style guidelines.
"""

import os
import subprocess
from os import path
mydir = "."
dirs = [x[1] for x in os.walk(mydir)]
dirs = dirs[0]
for f in dirs:
	print(f)
	os.chdir("./"+f)
	subprocess.call(["javac", "-cp", ".;~/javaLibrary/apiguardian-api-1.0.0.jar;~/javaLibrary/junit-jupiter-api-5.3.0-M1.jar;~/javaLibrary/junit-platform-commons-1.3.0-M1.jar;~/javaLibrary/opentest4j-1.1.0.jar", "*.java"], shell=True)
	subprocess.call(["java", "-jar", "~/javaLibrary/junit-platform-console-standalone-1.3.0-M1.jar", "-cp", ".", "-c", "Hex2DecTest"], shell=True)
	
	subprocess.call(["java", "-jar", "c:/checkstyle/checkstyle-8.12-all.jar", "-c", "~/javaLibrary/sun_checks.xml", "Hex2Dec.java"], shell=True)
	os.chdir("..")