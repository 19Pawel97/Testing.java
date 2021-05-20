package pl.sda.db;

public class Authentication {
    private Database database;
    private String loggedIn;

    public Authentication(Database database) {
        this.database = database;
        this.loggedIn = null;
    }

    public void logout() {
        this.loggedIn = null;
    }

    public void login(User user) throws AuthenticationException {
        if (user == null) {
            throw new AuthenticationException("Authentication failed");
        }
        User userFromDb = this.database.findUser(user.getLogin());
        if (userFromDb == null || !userFromDb.getPassword().equals(user.getPassword())) {
            throw new AuthenticationException("Authentication failed");
        }

        loggedIn = user.getLogin();
    }

    public String getLoggedIn() {
        return loggedIn;
    }
}
