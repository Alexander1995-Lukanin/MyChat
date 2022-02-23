import DatabaseChat.Database;
import auth.SQLAuthService;
import server.Server;



public class App {
    public static void main(String[] args) {
        new Server(new SQLAuthService()).start();


    }


}
