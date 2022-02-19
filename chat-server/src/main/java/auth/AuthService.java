package auth;

import entity.User;

import java.sql.SQLException;

public interface AuthService {
    boolean start();
    boolean stop();
    String authorizeUserByLoginAndPassword(String login, String password) throws SQLException;
    String changeNick(String login, String newNick) throws SQLException;
    User createNewUser(String login, String password, String nick);
    void deleteUser(String login, String pass);
    void changePassword(String login, String oldPass, String newPass);
    void resetPassword(String login, String newPass, String secret);
}
