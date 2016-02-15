# hmvc-example
This is an example of a GUI application demonstrating the HMVC and EventBus design patterns.

## Running the example
To run the code you will need:

* [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* Maven 2 or later

If you do not have Maven installed please refer to the **Maven installation** section below.

To compile the example run from the command-line:

```
mvn compile
```

To compile and run the example run from the command-line:

```
mvn compile  exec:java -Dexec.mainClass=ch.paranor.example.hmvc.Calculator
```

## Maven installation


Maven is downloadable as a zip file at [http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi).
Only the binaries are required, so look for the link to *apache-maven-{version}-bin.zip* or *apache-maven-{version}-bin.tar.gz*.

Once you have downloaded the zip file, unzip it to your computer. Then add the *bin* folder to your path.

To test the Maven installation, run *mvn* from the command-line:

```
mvn -v
```

If all goes well, you should be presented with some information about the Maven installation.

    Apache Maven 3.2.1 (ea8b2b07643dbb1b84b6d16e1f08391b666bc1e9; 2014-02-14T18:37:52+01:00)
    Maven home: /usr/share/maven
    Java version: 1.8.0_25, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "mac os x", version: "10.8.3", arch: "x86_64", family: "mac"

