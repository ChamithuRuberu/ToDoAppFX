package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Apply singoltone
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // load the class hdd to the ram..
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","");//make connection..
        }

        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static DBConnection getInstance(){
        return (dbConnection==null)? dbConnection=new DBConnection():dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
