


# AzugaTraining

- Table of Contents

1. [About The Project](##About-The-Project)
3. [Prerequisites](##Prerequisites)
4. [API Reference](##API-Reference)
5. [Features](##Features)
7. [Roadmap](##Roadmap)
8. [License](##License)
9. [Acknowledgements](##Acknowledgements)
10. [Used By](##Used-By)
11. [Authors](##Authors)
12. [Badges](##Badges)
13. [FAQ](##FAQ)
14. [Feedback](##Feedback)

## About The Project
This Project contains the java files for different programs and also added all the jar files that are required for the programs to run.

### Prerequisites 
The Project has some Prerequisites, jar files / libraries must be installed or added to the dependency’s. Following are required Jar files to add to the classPath for different features,
1. [pdfunit-java-2016.05.jar](http://www.pdfunit.com/en/download/)
2. [javax.mail.jar](https://jar-download.com/artifacts/com.sun.mail/javax.mail/1.6.1/source-code)
3. [activation-1.1.1.jar](https://jar-download.com/artifacts/javax.activation/activation/1.1.1/source-code)
4. [jfreechart-1.5.3.jar](https://search.maven.org/artifact/org.jfree/jfreechart/1.5.3/jar)
5. [Underscore-1.81.jar](https://mavenlibs.com/jar/file/com.github.javadev/underscore)
6. [opencsv-1.7.jar](https://jar-download.com/?search_box=opencsv-1.7)
7. [jflat-core-1.3.8.jar](https://jar-download.com/?search_box=JFlat)
8. [commans.io.2.11.0.jar](https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0)
9. [itextpdf-5.1.0.jar](https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.1.0)
10. [zip4j-2.11.2.jar](https://mvnrepository.com/artifact/net.lingala.zip4j/zip4j/2.11.2)
## API Reference

#### Get all items

```http
  Weather API_URL
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `API_URL` | `string` | http://api.weatherapi.com/v1/current.json?key=95c78ce997844bb184340839222809&q=" + city[i] + "&aqi=yes 

#### Get item

```http
  Fake Store API_URL
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `API_URL`      | `string` | https://fakestoreapi.com/products |




## Features

- Linux-commands
The project contains programs that mimics some of the basic Linux-Commands like cat, wc, mv, mkdir, sort, ls etc.

- Rest API
Using Weather API, fetch the data and use them to create the .csv and .json files. 

- Charts Creation
The Api's data in the files are used for graphical representation such as Bar chart, Pie Chart and Line Chart are created.

- OOps Concepts
OOps concepts like interface, methods, objects, classes, constructors, abstraction etc were also used in the java codes.

- Email, Zip And UnZip
The reports created from the API calls are  zipped, unzipped and sent through the mail programatically using java language.



## Roadmap
 
 
- LINUX COMMANDS 

    -    [ LINUX COMMANDS ](https://github.com/Adarshs-12/AzugaTraining/tree/develop/Linux%20Command)
- REST API

    - [Weather API ](https://github.com/Adarshs-12/AzugaTraining/blob/develop/RestAPI/RestAPI.java)
    

- FILES GENERATION

    -  [ PDF FILE](https://github.com/Adarshs-12/AzugaTraining/blob/develop/RestAPI/CSVtoPDF.java)
    -   [ HTML FILE](https://github.com/Adarshs-12/AzugaTraining/blob/develop/RestAPI/CSVtoHTML.java)
    -    [ XML FILE](https://github.com/Adarshs-12/AzugaTraining/blob/develop/RestAPI/JSONtoXML.java)
- CREATION OF CHARTS

    -  [ BAR GRAPH ](https://github.com/Adarshs-12/AzugaTraining/blob/develop/charts/BarGraph.java)
    -   [ PIE CHART](https://github.com/Adarshs-12/AzugaTraining/blob/develop/charts/PIEchart.java)
- OOPS 

    -   [ OOPs Implementation ](https://github.com/Adarshs-12/AzugaTraining/tree/develop/OOPs)
    
- Email, Zip AND Unzip

    -   [ ZIP ](https://github.com/Adarshs-12/AzugaTraining/blob/develop/Email%20Zip%20UnZip/ZipClass.java)
    -   [ UNZIP ](https://github.com/Adarshs-12/AzugaTraining/blob/develop/Email%20Zip%20UnZip/UnzipClass.java)
    -   [ MAIL ](https://github.com/Adarshs-12/AzugaTraining/blob/develop/Email%20Zip%20UnZip/EmailProgram.java)

## Acknowledgements

 - [Javatpoint](https://awesomeopensource.com/project/elangosundar/awesome-README-templates) helps to write the correct code snippet.
 - [GeeksforGeeks](https://github.com/matiassingers/awesome-readme)helps in understanding all the basic doubts related to the programming.
 - [Baeldung](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)helps in understanding all the queries related to logging, and zip-UnZip program.


## Authors

- [Adarsh Sahu](https://github.com/Adarshs-12)


## FAQ

#### Question 1. What to do if the console shows "API key disabled "?

Answer 1. Generate the new API key by login into the account that you created in the Weather API.

#### Question 2. Which API use to send e-mail through  java program?

Answer 2. Javax mail Sender API


## Feedback

If you have any feedback, please reach out to us at adarshkumarsahu@gmail.com

