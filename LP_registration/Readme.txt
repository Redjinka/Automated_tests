How to run the tests.

Preconditions:

1. Install JDK (Java Development Kit) http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
P.S. Check your Java version using command "java –version" in console.

2. Install Eclipse IDE for Java Developers 
http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/keplersr1

You can run 'eclipse.exe' directly from the Eclipse folder. You don't need to install Eclipse in your system.

3. Download the Selenium Standalone Server http://www.seleniumhq.org/download/ http://prntscr.com/co5050
4. Download the Chrome driver https://sites.google.com/a/chromium.org/chromedriver/downloads http://prntscr.com/co56gv
5. Download Apache log4j 1.2.17 https://logging.apache.org/log4j/1.2/download.html http://prntscr.com/co6g95


Work in Eclipse:

1. Download project with tests in Workspace folder. (by default Workspace will be located in C:\Users\user.name\workspace)

2. Open Eclipse. Accept Workspace location

3. Import project. 
Click on File->Import->Existing Projects into Workspace->Next. 
In 'Import Projects' window select 'Browse' and select needed project in 'Workspace' directory http://prntscr.com/co4h0h

4. Add jars. 

For usability keep your jar files in Workspace folder.
 
Right-click on the project->click on 'Properties' http://prntscr.com/co4jth . 
In the opened window select 'Java Build Pass'-> 'Liblaries' tab -> click on 'Add external jars' http://prntscr.com/co4l18. 

We need
:
- selenium-server-standalone.jar http://prntscr.com/co50th

- chromedriver.zip http://prntscr.com/co5a3u

- log4j.jar http://prntscr.com/co5foo

5. Add JUnit library. 
Right-click on the project->click on 'Properties', in the opened window select 'Add Library', select 'JUnit' http://prntscr.com/co5jrg http://prntscr.com/co5lf6

6. Run a test.
 
Open needed project->src->tests->select any test. Right-click on the test>Run As>JUnit Test http://prntscr.com/co65y1
Check executing in the Eclipse console.



How to edit tests:

1) Change count of leads - Open the test wich executes several leads registration, change 'i' value in cycle http://prntscr.com/co6py0 
(e.g i <= 100 will register 100 leads)

2) Change country - Open the test wich executes leads registration with selected country, change this value http://prntscr.com/co6vij
(e.g. registrationPage.selectValueFromDD("Austria") will register leads from Austria country) 