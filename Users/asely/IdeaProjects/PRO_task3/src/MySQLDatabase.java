// Realization abstraction for MySQL


public class MySQLDatabase implements Database {

    @Override
    public void saveUser(String username) {
        System.out.println("MySQL: user " + username + " has been saved");
    }
}
