public class Main {
    public static void main(String[] args){
        Track t1=new Track("SongA","Artist1");
        Track t2=new Track("SongB","Artist2");
        new MusicThread(t1).start();
        new MusicThread(t2).start();
        Database.saveTrack("SongA","Artist1");
    }
}