import java.util.*;

public class UserManager {
    List<User> users = new ArrayList<>();

    public void create(User u) {
        users.add(u);
    }

    public User find(String email) {
        return users.stream()
                .filter(u -> u.email.equals(email))
                .findFirst()
                .orElse(null);
    }

    public List<User> list() {
        return users;
    }
}