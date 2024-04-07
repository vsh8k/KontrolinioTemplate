# JavaFX Kontrolinio Template
This template provides a starting point for developing JavaFX applications using IntelliJ IDEA. It includes setup for FXML files and a database connector class.

## Install Steps:

- Get the Repo's git url:
	![Green "Code" button](https://i.ibb.co/s6KrzMz/image.png)
- Clone the Repo in IntelliJ IDEA
	![Get from Version Control selection](https://i.ibb.co/MfpbBYj/image.png)
	![Get from Version Control window](https://i.ibb.co/5kdFwTZ/image.png)

# MySQLConnector

`MySQLConnector` is a Java class designed to simplify interaction with MySQL databases in your Java applications. It provides methods for establishing a connection, executing queries, and performing CRUD operations (Create, Read, Update, Delete) on your database.

## Getting Started

1. **Include MySQLConnector in your Java class**: 

2. **Replace placeholders**:
   - Replace `"your_database_name"`, `"your_username"`, `"your_password"`, and `"your_table_name"` with appropriate values matching your MySQL setup.
   - 
3. **Create an instance of MySQLConnector**:
   ```java
   MySQLConnector connector = new MySQLConnector();
   ```

4. **Establish Connection:**
	- Connect to your MySQL database using the connect() method:
	```java  
	connector.connect();  
	```
5. **Perform Operations:**
	 - Use the provided methods to execute queries or perform CRUD operations.

6. **Close connection**

## Methods
- connect(): Establishes a connection to the MySQL database.

- executeQuery(query): Executes a SQL query and returns the result set.

- executeUpdate(query): Executes a SQL query that modifies the database (e.g., INSERT, UPDATE, DELETE) and returns the number of affected rows.

- closeConnection(): Closes the connection to the database.

## CRUD Operations
- insert(tableName, columns, values): Inserts a new row into the specified table.
- selectAll(tableName): Retrieves all rows from the specified table.
- update(tableName, setColumn, setValue, conditionColumn, conditionValue): Updates rows in the specified table based on a condition.
- delete(tableName, conditionColumn, conditionValue): Deletes rows from the specified table based on a condition.

## Example

```java  
MySQLConnector connector = new MySQLConnector();
connector.connect();

// Inserting data
String[] columns = {"name", "age"};//Column names
String[] values = {"John", "30"};//Values
int rowsInserted = connector.insert("your_table_name", columns, values);

// Reading data
ResultSet resultSet = connector.selectAll("your_table_name");
/*
OR
ResultSet resultSet = connector.executeQuery("SELECT column FROM table WHERE yada_yada");
*/
while (resultSet.next()) {
    resultSet.getInt("col_name");//Make sure to use the correct get method the data you want to access
    }



// Updating data
int rowsUpdated = connector.update("your_table_name", "age", "35", "name", "John");

// Deleting data
int rowsDeleted = connector.delete("your_table_name", "name", "John");

connector.closeConnection();  
```