
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConection {
    private static final String DB_NAME = System.getenv("DB_DATABASE");
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = System.getenv("DB_ROOT_PASSWORD");

    public static Connection gConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
