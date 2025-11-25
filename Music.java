public class Music {
    String title, artistName, album, genre;
    boolean approved = false;
    long streams = 0;

    public Music(String title, String artistName, String album, String genre) {
        this.title = title;
        this.artistName = artistName;
        this.album = album;
        this.genre = genre;
    }
}