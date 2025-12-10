import java.util.*;
public class MusicLibrary {
    private ArrayList<Track> tracks=new ArrayList<>();
    public void addTrack(Track t){ tracks.add(t); }
    public void sortTracks(){ tracks.sort(Comparator.comparing(Track::getTitle)); }
    public ArrayList<Track> getTracks(){ return tracks; }
}
