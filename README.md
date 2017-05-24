# Course Feedback
***Object Oriented Programming II Course Project***

This program receives data of student, teacher and course from the database and update the feedback information back to database when student sends feedback for each course.

## Members
1. Pawat Nakpiphatkul (@guitarpawat)
1. Noppawan Kulchol (@Septima777)

## About the Program

### Required Library

* JBCrypt — http://www.mindrot.org/projects/jBCrypt/
* MySQL Connector/J for JDBC — https://dev.mysql.com/downloads/connector/j/
* JFoenix — https://github.com/jfoenixadmin/JFoenix

Or you can use JAR file in library folder in our project.

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
stmt.execute("INSETRT INTO students (name) VALUES (" + inString +")");
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
