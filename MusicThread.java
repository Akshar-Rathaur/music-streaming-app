public class MusicThread extends Thread {
    private Track t;
    public MusicThread(Track t){ this.t=t; }
    public void run(){ synchronized(t){ t.play(); } }
}
