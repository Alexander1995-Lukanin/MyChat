package auth;

import entity.User;
import error.WrongCredentialsException;

import java.sql.SQLException;

import static DatabaseChat.Database.AuthRead;
import static DatabaseChat.Database.preparedStatementExample;

public class SQLAuthService implements AuthService{

    @Override
    public boolean start() {
        System.out.println("Auth service started");
        return true;
    }


    @Override
    public boolean stop() {
        System.out.println("Auth service stopped");
        return true;
    }



    @Override
    public String authorizeUserByLoginAndPassword(String login, String password) throws SQLException {
        return AuthRead (login,password);
    }


    @Override
    public String changeNick(String login, String newNick) throws SQLException {
        return  preparedStatementExample(login, newNick);
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
