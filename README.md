# Course Feedback
***Object Oriented Programming II Course Project***

This program receives data of student, teacher and course from the database and update the feedback information back to database when student sends feedback for each course.

## Members
1. Pawat Nakpiphatkul (@guitarpawat)
1. Noppawan Kulchol (@Septima777)

## About the Program

### Installation

This program runs on Java 8 with **Internet Connection**.

#### Required Library

* JBCrypt — http://www.mindrot.org/projects/jBCrypt/
* MySQL Connector/J for JDBC — https://dev.mysql.com/downloads/connector/j/
* JFoenix — https://github.com/jfoenixadmin/JFoenix

Or you can use JAR file in library folder in our project.

#### How to Run

##### Option 1

1. Download **whole** dist folder that contains runnable CourseFeedback.jar and lib folder.
1. Runs CourseFeedback.jar file.

##### Option 2

1. Download the latest release of this program.
1. Open Java text editor.
1. Create Java project and include JAR file in library folder.
1. Runs the program.

#### Demo User

##### Teachers

| Username | Password |
|----------|----------|
|eng       |hum       |
|mathsci   |ihatemaths|
|philo     |42answertoeverything|

##### Students

| Username | Password |
|----------|----------|
|student1  |std1      |
|student2  |nisit2    |
|student3  |ilikesleeping|

### Packages
* *default* — Contains important class for this program.
* data — Contains model and data object class.
* db — Contains class related about database.
* gui — Contains graphic user interface class.
* test — Contains some class to check that program works correctly before doing GUI, and contains some class to make dummy data in console.

### Patterns

There are some patterns that had use in this program.
* MVC Pattern — Separate the responsibility for control, model and view for GUI.
* Singleton Pattern — Use all same object for the same class in the program.
* Observer Pattern — Use to sent an object from one class to another class.

### Technology

#### Password Hashing and Salting

**Password hashing** is a Mathematic function that provides one way encryption of password string to some hash string. Each password string has their own hash and hash string is irreversible. If you want to verify the password, you should hash the password and check that they are the same. Because each hash string are unique to one password string, some hackers can know the password by hash if the password is frequently used, **password salting** adds some random string at the end of password before it hash to prevent this kind of attack.

Try this :
``` java
import org.mindrot.jbcrypt.BCrypt;
import java.util.Scanner;

public static void main(String[] args) {
  Scanner input = new Scanner(System.in);
  System.out.println("Enter the some words : ");
  String inString = input.nextLine();
  // Hash string by using BCrypt.hashpw(Password,Salt).
  String hashString = BCrypt.hashpw(inString, BCrypt.gensalt());
  System.out.println("Enter the some words : ");
  // Try "Be sure to drink your Ovaltine"!
  String newString = input.nextLine();
  // Check these string are the same by using BCrypt.checkpw(NewString,HashedString).
  if(BCrypt.checkpw(newString,hashString)) {
    System.out.println("Hash Matched!");
  } else {
    System.out.println("Hash Mismatched.");
  }
  // Check that two plain string are the same.
  if(inString.equals(newString)) {
    System.out.println("Plain text Matched!");
  } else {
    System.out.println("Plain text Mismatched.");
  }
}
```

##### Also See
* http://www.mindrot.org/projects/jBCrypt/
* https://crackstation.net/hashing-security.htm
* https://en.wikipedia.org/wiki/Cryptographic_hash_function
* https://en.wikipedia.org/wiki/Salt_(cryptography)


#### Database Connection

**Database** is the better way to store the data rather than just a file. It makes more easier to find and store the data with queries and can be on the internet with user permission control.

##### Simple Database Queries

To create new database :
```sql
CREATE DATABASE database_name;
```
To create new table :
```sql
CREATE TABLE table_name (column_name1 datatype, column2_name datatype, ...);
```
To drop (delete) database : ***ALL OF YOUR DATA IN THE DATABASE WILL BE LOST***
```sql
DROP DATABASE database_name;
```
To drop (delete) table :
```sql
DROP TABLE table_name;
```
To select some data in the table :
```sql
SELECT column_name1,column_name2, ... FROM table_name WHERE id=1 AND [condition]...;
```
To insert new data to the table :
```sql
INSERT INTO table_name (column_name1,column_name2,...) VALUES (value1,value2,...);
```
To update the data to the table :
```sql
UPDATE table_name SET column_name1=value1, column_name2=value2 WHERE [condition]...;
```
To delete data from the table :
```sql
DELETE FROM table_name WHERE [condition]...;
```

#### Connect from java to the database
You can connect your Java to the database by using JDBC (Java Database Connectivity) to connect to the database driver, Almost popular database programs have a driver for JDBC. In our program uses MySQL database and MySQL Connector/J to connect the database's driver with Java

This is some example syntax :
```java
import java.sql.*;

static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/database_name";
static final String USER = "username";
static final String PASS = "password";

public static void main(String[] args) throws SQLException, ClassNotFoundException {
  // Register JDBC driver.
  Class.forName("com.mysql.jdbc.Driver");
  // Open a connection.
  Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
  // Create a statement.
  Statement stmt = conn.createStatement();
  // Execute a query.
  stmt.execute([some query command string]);
  // Close the statement and connection.
  if(stmt != null) stmt.close();
  if(connect != null) connect.close();
}
```

#### SQL Injection
It is very dangerous to run a command like :
```java
stmt.execute("INSETRT INTO students (name) VALUES (\'" + inString +"\')");
```
This is vulnerable to the SQL injection as if when `inString = "Robert'); DROP TABLE students; ..."`
This command will adds Robert to the column `name` of table `students` and then drop the table `students`! This command is very destructive. This is called **SQL Injection**

##### Prepared Statement and Bind Value
One of the solution to prevent SQL injection is to use prepared statement and bind value. Please look at the example code below
``` java
Connection connect = DriverManager.getConnection(DB_URL, USER, PASS);
// Set prepared statement.
PreparedStatement stmt = connect.prepareStatement("INSERT INTO students (name,surname,age) VALUES (?,?,?)");
// Bind first value (1st ? sign).
stmt.setString(1,"Robert");
// Bind second value (2nd ? sign).
stmt.setString(2,"Table");
// Bind third value (3rd ? sign).
stmt.setInt(3,16);
// Execute query command.
stmt.execute();
// Don't forget to close statement and connection!
```
The bind values will replace some special character like `'` and `"` with escape character like `\'` and `\"`. This solution is very popular in many languages like Java and PHP.

##### Also See
* https://www.w3schools.com/sql/default.asp
* https://www.tutorialspoint.com/jdbc/jdbc-create-database.htm
* https://en.wikipedia.org/wiki/SQL_injection
* http://php.net/manual/en/security.database.sql-injection.php

#### Creation of user interface
We use JavaFX, it is a set of graphics and media packages that enables developers to design, create, test, debug, and deploy rich client applications that operate consistently across diverse platforms. With JavaFX, you can build many types of applications. Typically, they are network-aware applications that are deployed across multiple platforms and display information in a high-performance modern user interface that features audio, video, graphics, and animation.
Next is the code example for start the program's window.
Try this :
```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Student.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Feedback for Student");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Stage loginStage = (Stage) login.getScene().getWindow();
            loginStage.close();
            Sender.getInstance().send(new StudentModel(user), "UPDATE STUDENT DATA");

       }
    }
}
```

#### Decoration of user interface
Beside JavaFX, "jfoenix" is an open source Java library, that implements Google Material Design using Java components.

##### Inline-style:
![alt text](https://camo.githubusercontent.com/63c06acda6da12b96a077f879dec3570469e809b/687474703a2f2f6a666f656e69782e636f6d2f6769662f627574746f6e2e676966)

From above, to show decoration of button from jfoenix. For button there are 2 styles, Flat and Raised. Following the picture. (You can do it on scene builder)


#### Add Code to Handle an Event
Now make the Text control display a message when the user presses the button. You do this in the FXMLExampleController.java file. Delete the code that Eclipse IDE generated and replace it with the code example is the code below.
The @FXML annotation is used to tag nonpublic controller member fields and handler methods for use by FXML markup. The handleSubmtButtonAction method sets the actiontarget variable to Sign in button pressed when the user presses the button.
Try this :
```java
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class FXMLExampleController {
    @FXML private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Sign in button pressed");
    }

}
```

#### Style the Application with CSS
The final task is to make the application look attractive by adding a Cascading Style Sheet (CSS).
 Try this :
 For link with style sheets on GridPane layout.
```xml
 <stylesheets>
   <URL value="@Login.css" />
 </stylesheets>

</GridPane>
```

For create GridPane
```xml
<GridPane fx:controller="fxmlexample.FXMLExampleController"
    xmlns:fx="http://javafx.com/fxml" alignment="center" hgap="10" vgap="10"
    styleClass="root">
```

For create text ID
```xml
<Text id="welcome-text" text="Welcome"
        GridPane.columnIndex="0" GridPane.rowIndex="0"
        GridPane.columnSpan="2"/>
```

#### Scene Builder
SceneBuilder is an application where you can drag and drop JavaFX UI components, and then tell your JavaFX program to use the fxml file(s) to display the user interface.
So, it is so easy to use and to spend less time for user interface.
![alt text](https://i.stack.imgur.com/kqFHf.png)

#### Also see
* http://docs.oracle.com/javafx/2/overview/jfxpub-overview.htm
* http://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm#CHDCCHII
* https://github.com/jfoenixadmin/JFoenix/blob/master/README.md
