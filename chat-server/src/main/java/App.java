import auth.DatabaseAuthService;
import server.Server;



public class App {
    public static void main(String[] args) {
        new Server(new DatabaseAuthService()).start();


    }


}
