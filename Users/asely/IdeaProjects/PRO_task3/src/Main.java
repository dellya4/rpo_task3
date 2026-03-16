public class Main {
    public static void main(String[] args) {
        Database mySQL = new MySQLDatabase();
        UserService serviceMySQL = new UserService(mySQL);
        serviceMySQL.registerUser("Adel");
        System.out.println();

        Database mongo = new MongoDatabase();
        UserService serviceMongo = new UserService(mongo);
        serviceMongo.registerUser("Valeriya");
        System.out.println();

        Database postgresSQL = new PostgresSQLDatabase();
        UserService servicePostgresSQL = new UserService(postgresSQL);
        servicePostgresSQL.registerUser("Anastasiya");
        System.out.println();

        MockDatabase mock = new MockDatabase();
        UserService serviceMock = new UserService(mock);

        serviceMock.registerUser("Sofia");
        serviceMock.registerUser("Darya");

        System.out.println("List of users: " + mock.getUsers());
    }
}