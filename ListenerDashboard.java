import java.util.*;

public class ListenerDashboard {
    App app;
    User user;
    Scanner sc = new Scanner(System.in);

    List<String> followedArtists = new ArrayList<>();

    public ListenerDashboard(App app, User user) {
        this.app = app;
        this.user = user;
    }

    public void show() {
        while (true) {
            System.out.println("\n--- LISTENER DASHBOARD ---");
            System.out.println("1. Stream Music");
            System.out.println("2. Create Playlist");
            System.out.println("3. View Playlists");
            System.out.println("4. Follow Artist");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> stream();
                case 2 -> createPlaylist();
                case 3 -> viewPlaylists();
                case 4 -> followArtist();
                case 0 -> { return; }
            }
        }
    }

    void stream() {
        System.out.println("\n--- MUSIC LIST ---");
        List<Music> approved = app.musicManager.listAll()
                .stream()
                .filter(m -> m.approved)
                .toList();

        if (approved.isEmpty()) {
            System.out.println("No approved music available.");
            return;
        }

        for (int i = 0; i < approved.size(); i++) {
            System.out.println((i+1) + ". " + approved.get(i).title);
        }

        System.out.print("Play which? ");
        int c = Integer.parseInt(sc.nextLine());

        Music m = approved.get(c - 1);
        m.streams++;

        System.out.println("Playing: " + m.title);
    }

    void createPlaylist() {
        System.out.print("Playlist name: ");
        String name = sc.nextLine();
        app.playlistManager.create(name, user.email);
        System.out.println("Playlist created!");
    }

    void viewPlaylists() {
        List<Playlist> list = app.playlistManager.listByUser(user.email);

        if (list.isEmpty()) {
            System.out.println("No playlists found.");
            return;
        }

        System.out.println("\n--- YOUR PLAYLISTS ---");
        for (Playlist p : list) {
            System.out.println(p.title + " | " + p.songs.size() + " songs");
        }
    }

    void followArtist() {
        System.out.print("Enter artist name: ");
        String name = sc.nextLine();

        followedArtists.add(name);

        System.out.println("You followed " + name);
    }
}