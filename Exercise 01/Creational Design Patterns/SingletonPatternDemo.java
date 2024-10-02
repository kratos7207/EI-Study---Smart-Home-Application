
class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor to restrict instantiation
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Database connected!");
    }
}

// Example usage
public class SingletonPatternDemo {

    public static void main(String[] args) {
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        dbConnection1.connect();

        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        dbConnection2.connect();

        System.out.println(dbConnection1 == dbConnection2); // true, both references are the same
    }
}
