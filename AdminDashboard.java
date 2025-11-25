import java.util.*;
import java.util.stream.Collectors;

public class AdminDashboard {
    App app;
    Scanner sc = new Scanner(System.in);

    public AdminDashboard(App app) {
        this.app = app;
    }

    public void show() {
        while (true) {
            System.out.println("\n--- ADMIN DASHBOARD ---");
            System.out.println("1. View Users");
            System.out.println("2. Approve Music");
            System.out.println("3. Music Overview");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int c = Integer.parseInt(sc.nextLine());

            switch (c) {
                case 1 -> users();
                case 2 -> approveMusic();
                case 3 -> overview();
                case 0 -> { return; }
            }
        }
    }

    void users() {
        System.out.println("\n--- USERS ---");
        for (User u : app.userManager.list()) {
            System.out.println(u.email + " | " + u.role);
        }
    }

    void approveMusic() {
        System.out.println("\n--- PENDING MUSIC ---");
        List<Music> pending = app.musicManager.listAll()
                .stream()
                .filter(m -> !m.approved)
                .collect(Collectors.toList());

        if (pending.isEmpty()) {
            System.out.println("No pending music.");
            return;
        }

        for (int i = 0; i < pending.size(); i++) {
            System.out.println((i + 1) + ". " + pending.get(i).title);
        }

        System.out.print("Approve which? (0 exit): ");
        int c = Integer.parseInt(sc.nextLine());
        if (c > 0) {
            pending.get(c - 1).approved = true;
            System.out.println("Approved!");
        }
    }

    void overview() {
        System.out.println("\n--- MUSIC OVERVIEW ---");

        List<Music> all = app.musicManager.listAll();

        long approved = all.stream().filter(m -> m.approved).count();
        long streams = all.stream().mapToLong(m -> m.streams).sum();

        System.out.println("Total Songs: " + all.size());
        System.out.println("Approved Songs: " + approved);
        System.out.println("Total Streams: " + streams);

        List<Music> top = all.stream()
                .sorted((a, b) -> Long.compare(b.streams, a.streams))
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop Songs:");
        for (Music m : top) {
            System.out.println(m.title + " | " + m.artistName + " | " + m.streams + " streams");
        }
    }
}