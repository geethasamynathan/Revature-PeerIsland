# Maven and Central Repository in IntelliJ IDEA

**Project: Java FS**

Below is a detailed beginner-friendly explanation of **Maven**, **Maven Central Repository**, and **how to use Maven in IntelliJ IDEA step by step**.

---

## 1. What is Maven?

**Maven** is a **build automation and project management tool** used mainly for Java projects.

In simple words, Maven helps you:

- create Java project structure
- add external libraries
- compile code
- run tests
- package project into JAR/WAR
- manage dependencies
- manage plugins
- standardize project development

### Real-world meaning

Suppose you are developing a Java application and you need:

- MySQL JDBC driver
- JUnit for testing
- Spring Boot dependencies
- Log4j or SLF4J logging library

Without Maven, you would have to:

- manually download each JAR
- add them one by one to project
- track versions yourself
- handle dependency conflicts manually

With Maven, you just write dependency details in one file called:

```text
pom.xml
```

and Maven automatically downloads and manages them.

---

## 2. Why Maven is used

Maven is used because it makes Java project development:

- easier
- faster
- organized
- repeatable
- standard across teams

### Example

If 10 developers work on the same project, Maven ensures all use:

- same dependencies
- same versions
- same build process
- same folder structure

That is why Maven is widely used in real-time Java projects.

---

## 3. What does Maven do?

Maven can do many things.

### Maven helps in:

- dependency management
- project build
- compilation
- testing
- packaging
- deployment
- documentation generation
- code quality integration
- plugin execution
- version management
- standard project structure

---

## 4. What is `pom.xml`?

The heart of Maven project is:

```text
pom.xml
```

`POM` means:

**Project Object Model**

This file contains:

- project name
- group id
- artifact id
- version
- dependencies
- plugins
- build settings

### Example simple `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ittechgenie</groupId>
    <artifactId>MavenDemo</artifactId>
    <version>1.0-SNAPSHOT</version>

</project>
```

---

## 5. What is Maven Central Repository?

**Maven Central Repository** is the **main online storage location** where Maven downloads Java libraries and plugins from.

It contains thousands of ready-made Java libraries such as:

- JUnit
- MySQL Connector
- Spring Framework
- Hibernate
- Jackson
- Log4j
- Lombok

### In simple words

Maven Central is like a **library warehouse** for Java dependencies.

When you add a dependency in `pom.xml`, Maven goes to the central repository, downloads it, and stores it in your local machine.

---

## 6. What is local repository and central repository?

Maven works with repositories.

### A. Central Repository
This is the internet repository from where dependencies are downloaded.

### B. Local Repository
This is the folder in your machine where downloaded dependencies are stored.

Usually local repository path is:

```text
C:\Users\YourUserName\.m2\repository
```

For your system, it may look like:

```text
C:\Users\LENOVO\.m2\repository
```

### How it works

1. You add dependency in `pom.xml`
2. Maven checks local repository
3. If dependency is not found locally, Maven downloads it from central repository
4. Then stores it in `.m2\repository`

---

## 7. Real-world example of Central Repository

Suppose you need MySQL driver.

You add this in `pom.xml`:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```

Then Maven:

- downloads `mysql-connector-j`
- saves it in local repo
- adds it to your project automatically

---

## 8. Main concepts in Maven

### 1. Group ID
Represents company or organization name.

Example:

```xml
<groupId>com.ittechgenie</groupId>
```

### 2. Artifact ID
Represents project name.

Example:

```xml
<artifactId>student-management</artifactId>
```

### 3. Version
Project version.

Example:

```xml
<version>1.0-SNAPSHOT</version>
```

### 4. Dependency
External library needed for project.

### 5. Plugin
Tool used by Maven to perform tasks like compile, test, package.

---

## 9. What is dependency management?

Dependency management means Maven handles external JAR files for your project.

### Without Maven
You manually:
- download JAR
- add build path
- manage versions
- fix missing dependencies

### With Maven
You only write dependency details in `pom.xml`.

Maven does the rest.

---

## 10. What are all the things we can do with Maven in IntelliJ IDEA?

With Maven in IntelliJ IDEA, you can do many tasks.

1. Create Maven project
2. Add dependencies
3. Auto-download JARs
4. Compile project
5. Run tests
6. Package application
7. Clean project
8. Install to local repository
9. Build Spring Boot projects
10. Run Maven lifecycle commands
11. Manage plugins
12. Maintain standard project structure

---

## 11. Standard Maven project structure

A Maven project usually follows this structure:

```text
MyProject
 ┣ src
 ┃ ┣ main
 ┃ ┃ ┣ java
 ┃ ┃ ┗ resources
 ┃ ┗ test
 ┃   ┣ java
 ┃   ┗ resources
 ┣ pom.xml
 ┗ target
```

### Meaning

- `src/main/java` → application code
- `src/main/resources` → config files
- `src/test/java` → test classes
- `target` → generated build output
- `pom.xml` → project configuration

---

## 12. Maven lifecycle phases

Maven has predefined lifecycle phases.

### Important Maven phases

#### 1. `validate`
Checks whether project structure and `pom.xml` are correct.

#### 2. `compile`
Compiles source code.

#### 3. `test`
Runs test cases.

#### 4. `package`
Creates JAR or WAR.

#### 5. `verify`
Performs additional verification.

#### 6. `install`
Installs package into local repository.

#### 7. `deploy`
Copies package to remote repository.

---

## 13. Common Maven commands

### Clean
```bash
mvn clean
```

Deletes previous build files from `target`.

### Compile
```bash
mvn compile
```

Compiles source code.

### Test
```bash
mvn test
```

Runs test cases.

### Package
```bash
mvn package
```

Creates JAR/WAR.

### Install
```bash
mvn install
```

Builds and places artifact in local repository.

---

## 14. What is Maven plugin?

A plugin is used by Maven to perform a task.

Examples:

- compiler plugin
- surefire plugin
- jar plugin
- spring-boot-maven-plugin

### Example

Compiler plugin compiles Java code:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>21</source>
                <target>21</target>
            </configuration>
        </plugin>
    </plugins>
</build>
```

---

## 15. How Maven works in IntelliJ IDEA

When you create or import a Maven project in IntelliJ:

1. IntelliJ reads `pom.xml`
2. identifies dependencies
3. downloads missing dependencies
4. configures project automatically
5. shows Maven lifecycle and plugins in Maven window

So IntelliJ and Maven work together very well.

---

## 16. Step-by-step: how to create Maven project in IntelliJ IDEA

### Step 1: Open IntelliJ IDEA
Launch IntelliJ IDEA.

### Step 2: Click New Project
Choose **New Project**.

### Step 3: Select Maven
From the left panel, select:

- **Maven**

### Step 4: Select JDK
Choose installed JDK, for example:

- Java 17
- Java 21

### Step 5: Enter project details
Give:

- **GroupId** → `com.ittechgenie`
- **ArtifactId** → `MavenDemo`

### Step 6: Click Create
Now IntelliJ creates Maven project.

---

## 17. Folder structure after project creation

You will see something like:

```text
MavenDemo
 ┣ src
 ┃ ┣ main
 ┃ ┗ test
 ┣ pom.xml
```

Then under `main`, create `java` folder if not already visible, depending on template.

---

## 18. Step-by-step: add dependency in IntelliJ Maven project

Suppose you want MySQL driver.

### Step 1
Open `pom.xml`

### Step 2
Add this inside `<dependencies>` tag:

```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.4.0</version>
    </dependency>
</dependencies>
```

### Step 3
Save the file

### Step 4
IntelliJ will show **Load Maven Changes** or **Reload**

Click it.

### Step 5
Maven downloads dependency automatically

---

## 19. Full example `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ittechgenie</groupId>
    <artifactId>MavenDemo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.4.0</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

---

## 20. Step-by-step: create Java class in IntelliJ Maven project

### Step 1
Go to:

```text
src/main/java
```

### Step 2
Create package:

```text
com.ittechgenie
```

### Step 3
Create class:

```text
Main.java
```

### Step 4
Write code:

```java
package com.ittechgenie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Maven with IntelliJ IDEA");
    }
}
```

### Step 5
Run the class

Output:

```text
Hello Maven with IntelliJ IDEA
```

---

## 21. Step-by-step: how to run Maven commands in IntelliJ

There are 2 ways.

### Method 1: Maven tool window

#### Step 1
Open **Maven** panel in IntelliJ

Usually on right side

#### Step 2
Expand your project

You will see:
- Lifecycle
- Plugins
- Dependencies

#### Step 3
Under Lifecycle, you can double-click:
- clean
- compile
- test
- package
- install

### Method 2: Terminal

Open IntelliJ Terminal and run:

```bash
mvn clean
mvn compile
mvn test
mvn package
mvn install
```

---

## 22. What happens when you run these commands

### `mvn clean`
Deletes old build output.

### `mvn compile`
Compiles Java code and creates `.class` files.

### `mvn test`
Executes test cases.

### `mvn package`
Packages project as JAR or WAR.

### `mvn install`
Places built artifact in local `.m2` repository.

---

## 23. How to check downloaded dependencies

In IntelliJ, after Maven reload:

- open **External Libraries**
- you will see downloaded jars

Example:
- mysql-connector-j
- junit-jupiter

Or check local folder:

```text
C:\Users\LENOVO\.m2\repository
```

---

## 24. Real-world things we commonly do with Maven in IntelliJ

1. JDBC project
2. Spring Boot project
3. JUnit testing
4. Web application
5. Team collaboration
6. CI/CD

### Example use cases

- Add MySQL driver and build database connectivity project
- Manage Spring Boot dependencies easily
- Add JUnit dependency and run unit tests
- Package project as WAR
- Ensure everyone in the team uses same dependencies
- Jenkins and other tools run Maven commands for build and deploy

---

## 25. Example: add MySQL dependency and JDBC program

### `pom.xml`

```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.4.0</version>
    </dependency>
</dependencies>
```

### Java code

```java
package com.ittechgenie;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/companydb";
        String username = "root";
        String password = "root123";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

This is one practical use of Maven.

---

## 26. Benefits of Maven

Maven gives many benefits:

- automatic jar download
- easy dependency management
- standard structure
- less manual work
- easy builds
- team consistency
- CI/CD friendly
- plugin support
- easier maintenance

---

## 27. Maven vs manual Java project

### Manual project
- create folders manually
- download jars manually
- add build path manually
- manage versions manually

### Maven project
- standard structure
- dependencies managed through `pom.xml`
- build commands available
- plugins supported
- scalable for real projects

---

## 28. Maven vs Gradle

Both are build tools.

### Maven
- XML based
- easier for beginners
- very structured
- widely used in enterprise Java

### Gradle
- script based
- more flexible
- often faster
- common in Android and modern builds

For beginners and enterprise Java learning, Maven is a great starting point.

---

## 29. Important Maven terms for interview

### What is Maven?
Maven is a project management and build automation tool used mainly for Java projects.

### What is `pom.xml`?
It is the configuration file of Maven project.

### What is dependency?
A library needed by project.

### What is repository?
A storage location for dependencies.

### What is Central Repository?
Main online repository from which Maven downloads dependencies.

### What is local repository?
Local folder in user machine where Maven stores dependencies.

### What is plugin?
A tool that performs a task such as compile, test, package.

### What is lifecycle?
Sequence of build phases like compile, test, package, install.

---

## 30. Step-by-step summary for IntelliJ IDEA

### To create Maven project
1. Open IntelliJ IDEA
2. Click New Project
3. Choose Maven
4. Select JDK
5. Enter GroupId and ArtifactId
6. Click Create

### To add dependency
1. Open `pom.xml`
2. Add dependency
3. Save file
4. Click Reload Maven Changes

### To run build
1. Open Maven tool window
2. Choose lifecycle
3. Run compile/package/install

---

## 31. Mini complete example

### `pom.xml`

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ittechgenie</groupId>
    <artifactId>MavenStudentDemo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### `Main.java`

```java
package com.ittechgenie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Maven project created successfully in IntelliJ IDEA");
    }
}
```

---

## 32. Final simple definition

**Maven is a Java build and dependency management tool that uses `pom.xml` to manage project structure, external libraries, plugins, compilation, testing, and packaging. Maven Central Repository is the online storehouse from which Maven downloads required libraries automatically. In IntelliJ IDEA, Maven helps create projects, add dependencies, run builds, execute tests, and package applications easily.**
