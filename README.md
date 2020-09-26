# Xian dev assessment server

Please follow below steps to run the application

Prerequisites.

* JDK 8 or above *
* MySQL 5.7 or above *
* Apache Maven 3.6.3 or above
* Intellij Idea (Optional)

1. clone the repository

2. 1. if using Intellij Idea 
    * click file -> new -> project from existing sources -> 
    * select the cloned repo folder and click OK. 
    * then in the pop-up, select import project project from existing sources radio button 
    * then select maven as the source below.
    * then the project will be opened and open its pom.xml and 
    right click -> maven -> download sources. 
    * then the required dependencies will be downloaded.
    * after finishing run the application by right clicking the
    XianDevAssessmentApplication class.  
====================================================================

    2. if using command line
    * go to the project folder.
    * run command - mvn clean install
    * wait until downloading
    * after finishing run -> mvn spring-boot:run 

   The DB schema will be created automatically.

3. import the provided xian_dev.sql file (in project root) to your local database.