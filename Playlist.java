import java.util.*;

public class Playlist {
    String title;
    String listenerEmail;
    List<Music> songs = new ArrayList<>();

    public Playlist(String title, String listenerEmail) {
        this.title = title;
        this.listenerEmail = listenerEmail;
    }
}