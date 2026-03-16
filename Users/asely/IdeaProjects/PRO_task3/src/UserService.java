public class UserService {

    private Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public void registerUser(String username) {
        database.saveUser(username);
    }
}
