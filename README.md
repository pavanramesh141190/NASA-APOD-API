# NASA-APOD-API
Explore the wonders of the universe! This site brings you NASA's Astronomy Picture of the Day (APOD) &amp; MARS Rover Photos, stunning daily images with fascinating explanations from astronomers.

Spring Boot Web Application - NASA-APOD-API - Installation Guide

This README provides instructions on how to install and run a Spring Boot web application.

Prerequisites:

1. Java Development Kit (JDK): Ensure you have a JDK installed (version 17 or higher recommended). You can download it from the official Oracle website or use an OpenJDK distribution.
2. Build Tool: Choose either Maven or Gradle to manage dependencies and build the application. In this code I have used Maven.
3. Maven: Download and install from the official Apache Maven website.

Note: If IDE is used then step 2 & 3 will not be required, as IDE will provide it.

Source Code:
Download the Source Code as zip or clone the repository to your local machine.

Building the Application:
Using IDE:
1. Import the project from the downloaded as zip or from GIT
2. Do Maven clean install. This will download dependencies and compile the code.

Code can also be built using terminal: Open a terminal in the project directory and run mvn clean install. This will download dependencies, compile the code, and package it into a JAR file.

Running the Application:
1. Using IDE: Most IDEs (Eclipse, IntelliJ IDEA, Spring Tool Suite) have built-in support for running Spring Boot applications. 
- Run as Spring boot application using the embedded tomcat.

2. Using JAR file: java -jar <file-path>/<jar-file-name>.jar 

Verification Steps:
Once the application starts, you should see log messages in the terminal or console of IDE indicating that it's running.
Open any web browser and access the application at the URL - http://localhost:8080/home.html

