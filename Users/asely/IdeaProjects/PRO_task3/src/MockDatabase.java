import java.util.ArrayList;
import java.util.List;

public class MockDatabase implements Database {

    private final List<String> users = new ArrayList<>();

    @Override
    public void saveUser(String username) {
        users.add(username);
        System.out.println("MongoDB: user " + username + " has been saved in memory");
    }

    public List<String> getUsers() {
        return users;
    }
}
