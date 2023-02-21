package project;

import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private Map<String, String> users;

    public Authentication() {
        this.users = new HashMap<>();
    }

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean checkCredentials(String username, String password) {
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}

