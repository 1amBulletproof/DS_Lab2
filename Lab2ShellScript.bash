#!/bin/bash
project_dir = "/Users/Tarney/Desktop/Data Structure Lab 2/Code"
cd project_dir
echo "Compiling  project...."
if [ javac -cp.Lab2.java ] 
then
	echo "Compilation succesful! Running project now"
	java Lab2 Lab2RequiredInput.txt Output.txt
else
	echo "Compilation failed. Cannot run project"

