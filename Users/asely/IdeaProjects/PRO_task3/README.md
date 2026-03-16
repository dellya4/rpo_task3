**Software development fundamentals: Task 3**

**Interface:**
- Database

**Implements:** 
- MySQLDatabase
- MongoDatabase
- PostgresDatabase
- MockDatabase for testing 

**Explanation:**

In the original, the UserService class depend on the concrete class, MySQLDatabase, 
which created connection between the service and the database. It creates a difficult 
to switch database or test the service. I create an abstraction Database was introduced
as an interface. And the different implementation: MongoDB, MySQL, PostgresSQL. The UserService
depend on the abstraction, and we can easier change the database in service. In this task I use 
Dependency Inversion Principle. 
