import auth.InMemoryAuthService;
import auth.SQLAuthService;
import server.Server;

import java.sql.SQLException;

import static DatabaseChat.Database.*;

public class App {
    public static void main(String[] args) {
        try {
            connect();
            createTable();
            //simpleInsertExample();
            //massInsertBatchExample();
            //dropExample();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        //new Server(new InMemoryAuthService()).start();
        new Server(new SQLAuthService()).start();

    }
}
