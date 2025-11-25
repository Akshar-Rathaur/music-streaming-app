import java.util.*;

public class MusicManager {
    List<Music> musicList = new ArrayList<>();

    public void upload(Music m) {
        musicList.add(m);
    }

    public List<Music> listAll() {
        return musicList;
    }
}