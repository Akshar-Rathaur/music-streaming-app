import java.util.*;

public class PlaylistManager {
    List<Playlist> playlists = new ArrayList<>();

    public Playlist create(String title, String email) {
        Playlist p = new Playlist(title, email);
        playlists.add(p);
        return p;
    }

    public List<Playlist> listByUser(String email) {
        List<Playlist> out = new ArrayList<>();
        for (Playlist p : playlists)
            if (p.listenerEmail.equals(email))
                out.add(p);

        return out;
    }
}