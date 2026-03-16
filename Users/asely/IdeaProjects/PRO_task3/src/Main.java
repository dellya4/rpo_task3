public class Main {
    public static void main(String[] args) {
        // Create mySQL database object, service and add user
        Database mySQL = new MySQLDatabase();
        UserService serviceMySQL = new UserService(mySQL);
        serviceMySQL.registerUser("Adel");
        System.out.println();

        // Create Mongo database object, service and add user
        Database mongo = new MongoDatabase();
        UserService serviceMongo = new UserService(mongo);
        serviceMongo.registerUser("Valeriya");
        System.out.println();

        // Create Postgres database object, service and add user
        Database postgresSQL = new PostgresSQLDatabase();
        UserService servicePostgresSQL = new UserService(postgresSQL);
        servicePostgresSQL.registerUser("Anastasiya");
        System.out.println();

        // Create Mock database object, service and add user
        MockDatabase mock = new MockDatabase();
        UserService serviceMock = new UserService(mock);
        serviceMock.registerUser("Sofia");
        serviceMock.registerUser("Darya");

        // Print user from database
        System.out.println("List of users: " + mock.getUsers());
    }
}