package auth;

import DatabaseChat.Database;
import entity.User;
import error.WrongCredentialsException;

import java.sql.SQLException;


public class SQLAuthService implements AuthService {
    private Database dbservice;

    @Override
    public boolean start() {
        dbservice = Database.getInstance();
        System.out.println("Auth service started");
        return true;
    }


    @Override
    public boolean stop() {
        dbservice.closeConnection();
        System.out.println("Auth service stopped");
        return true;
    }


    @Override
    public String authorizeUserByLoginAndPassword(String login, String pass) {
        return dbservice.getClientNameByLoginPass(login, pass);
    }


    @Override
    public String changeNick(String login, String newNick) throws SQLException {
        return dbservice.changeUsername(login, newNick);
    }

    @Override
    public User createNewUser(String login, String password, String nick) {
        return null;
    }

    @Override
    public void deleteUser(String login, String pass) {

    }

    @Override
    public void changePassword(String login, String oldPass, String newPass) {

    }

    @Override
    public void resetPassword(String login, String newPass, String secret) {

    }
}
