package auth;

import DatabaseChat.ClientsDatabaseService;
import entity.User;


public class DatabaseAuthService implements AuthService {
    private ClientsDatabaseService dbService;

    @Override
    public void start() {
        dbService = ClientsDatabaseService.getInstance();
    }

    @Override
    public void stop() {
        dbService.closeConnection();
    }

    @Override
    public String authorizeUserByLoginAndPassword(String login, String pass) {
        return dbService.getClientNameByLoginPass(login, pass);
    }

    @Override
    public String changeNick(String login, String newNick) {
        return dbService.changeNick(login, newNick);
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {

    }

    @Override
    public void resetPassword(String login, String newPass, String secret) {

    }

    @Override
    public User createNewUser(String login, String password, String nickname) {
        return null;
    }

    @Override
    public void deleteUser(String login, String pass) {

    }

    public void deleteUser(String nickname) {

    }
}
