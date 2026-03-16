public class MongoDatabase implements Database {
    @Override
    public void saveUser(String username) {
        System.out.println("MongoDB: user " + username + " has been saved");
    }
}
