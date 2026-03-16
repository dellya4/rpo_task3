public class Main {
    public static void main(String[] args) {
        Database mySQL = new MySQLDatabase();
        UserService serviceMySQL = new UserService(mySQL);
        serviceMySQL.registerUser("Adel");

        Database mongo = new MongoDatabase();
        UserService serviceMongo = new UserService(mongo);
        serviceMongo.registerUser("Valeriya");

        Database postgresSQL = new PostgresSQLDatabase();
        UserService servicePostgresSQL = new UserService(postgresSQL);
        servicePostgresSQL.registerUser("Anastasiya");
    }
}