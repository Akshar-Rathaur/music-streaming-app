import java.util.*;

public class App {
    UserManager userManager = new UserManager();
    MusicManager musicManager = new MusicManager();
    PlaylistManager playlistManager = new PlaylistManager();
    Scanner sc = new Scanner(System.in);

    public void seedData() {
        userManager.create(new User("admin@mail.com", "Admin", "admin"));
        userManager.create(new User("artist@mail.com", "ArtistUser", "artist"));
        userManager.create(new User("listener@mail.com", "ListenerUser", "listener"));
    }

    public void run() {
        System.out.print("Login email: ");
        String email = sc.nextLine();
        User u = userManager.find(email);

        if (u == null) {
            System.out.println("Invalid login!");
            return;
        }

        switch (u.role) {
            case "admin" -> new AdminDashboard(this).show();
            case "artist" -> new ArtistDashboard(this, u).show();
            case "listener" -> new ListenerDashboard(this, u).show();
        }
    }
}