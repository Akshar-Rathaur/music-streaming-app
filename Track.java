public class Track implements Playable {
    private String title,artist;
    public Track(String t,String a){ title=t; artist=a; }
    public void play(){ System.out.println("Playing "+title+" by "+artist); }
    public String getTitle(){ return title; }
    public String getArtist(){ return artist; }
}