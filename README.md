# Udacity Project - Joke Teller

## Project Overview
Android Project for [Udacity Android Developer Nanodegree.](https://eu.udacity.com/course/android-developer-nanodegree-by-google--nd801) 

In this project, you will create an app with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app will consist
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project
As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What Will I Learn?
You will learn the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. You'll learn to:

* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server
* Add Interstitial Ad
* Add Loading Indicator
* Configure Test Task

To tie it all together, create a Gradle task that:
1. Launches the GCE local development server
2. Runs all tests
3. Shuts the server down again

## Components
* Java library for supplying jokes
* Android library with an activity that displays jokes passed to it as intent extras
* Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task
* Connected tests to verify that the async task is indeed loading jokes
* Paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies
* Retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library
