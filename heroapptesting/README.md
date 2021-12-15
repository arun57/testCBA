CBA Task-3:
*********************************** File Descriptions *****************************************************************************************

Build management tool - Maven
Test framework - Junit

File and folder Descriptions:

All the test resources and UI locators are stored under /src/main/java
1. src\test\resources\.env -  This is the properties file where we will define the configuration parameters,urls or any local paths, for now I had just included a parameter "browser=chrome", this can be changed to "IE" or "Firefox" as per requirement
2. src\test\java\com\herotesting\automation\tests\BaseTest.java - This is the class file that will read the .env file above initialize the driver and navigate the url.
3. src\test\java\com\herotesting\automation\support - This folder contains the java classes and methods to initialize respective browsers and the "MyScreenRecorder.java" contains the methods to capture video recordings after every test
4. recordings\ChromeRecording.fbr - This is the execution video for Chrome Browser
5. src\test\java\com\herotesting\automation\tests\SampleTest.java -  This is the file which calls the HomePage class and from where the tests are driven
6. src\test\java\com\herotesting\automation\model\pages\HomePage.java - This is the page where the locators are defined for HomePage.
7. src\test\java\com\herotesting\automation\model\data\QuesAnsData.java - This is the class which defines the record structure of the question and answers.


pom.xml - This is the most important file which will drive our test execution, all the additional plugins and software dependencies are added to this file along with the testng.xml

****************************************Execution Instructions *************************************************************************************
1. As the above framework is driven by pom.xml, we need to install maven as a pre-requisite(ensure java8 or above is already installed). Download the Maven zip file from the link - https://www.strategylions.com.au/mirror/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.zip
2. Ensure latest chromedriver is downloaded and its path is set under system variables along with JAVA_HOME and MAVEN_HOME.
2. Extract the above zip file, go to command prompt and run the below commands:
SET MAVEN_HOME = <your local path where maven is extracted>\apache-maven-3.8.1-bin\apache-maven-3.8.1
SET PATH= <your local path where maven is extracted>\apache-maven-3.8.1-bin\apache-maven-3.8.1\bin
3. Access the Github repository, navigate to Code-> Download ZIP alternatively clone the resources from Github to your local machine using command "git clone https://github.com/arun57/testCBA.git"
4. On the command prompt navigate to the project directory (more specifically path where pom.xml is located) using command "cd <your local path where code is extracted>\heroapptesting"
5. From the same directory trigger the test using command "mvn test -Dtest="SampleTest". May take a while to execute for the first time as it will download the dependencies.This same command can be configured in a CI/CD tool like Jenkins and we can configure it in a cron job.
6. The recordings for the execution will be generated under recordings folder.
