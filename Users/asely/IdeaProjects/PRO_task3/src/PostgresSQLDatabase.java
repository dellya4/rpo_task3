public class PostgresSQLDatabase implements Database {
    @Override
    public void saveUser(String username) {
        System.out.println("PostgresSQL: user " + username + " has been saved");
    }
}
