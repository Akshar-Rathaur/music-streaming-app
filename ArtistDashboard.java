import java.util.*;

public class ArtistDashboard {
    App app;
    User artist;
    Scanner sc = new Scanner(System.in);

    public ArtistDashboard(App app, User artist) {
        this.app = app;
        this.artist = artist;
    }

    public void show() {
        while (true) {
            System.out.println("\n--- ARTIST DASHBOARD ---");
            System.out.println("1. Upload Music");
            System.out.println("2. View My Music");
            System.out.println("3. Track Performance");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> upload();
                case 2 -> listMyMusic();
                case 3 -> performance();
                case 0 -> { return; }
            }
        }
    }

    void upload() {
        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Album: ");
        String a = sc.nextLine();
        System.out.print("Genre: ");
        String g = sc.nextLine();

        Music m = new Music(t, artist.name, a, g);
        app.musicManager.upload(m);

        System.out.println("Uploaded! Waiting for admin approval.");
    }

    void listMyMusic() {
        System.out.println("\n--- MY MUSIC ---");

        for (Music m : app.musicManager.listAll()) {
            if (m.artistName.equals(artist.name)) {
                System.out.println(m.title + " | " + (m.approved ? "Approved" : "Pending"));
            }
        }
    }

    void performance() {
        System.out.println("\n--- PERFORMANCE REPORT ---");

        for (Music m : app.musicManager.listAll()) {
            if (m.artistName.equals(artist.name)) {
                System.out.println(m.title + " | Streams: " + m.streams);
            }
        }
    }
}