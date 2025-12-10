import java.sql.*;
import java.util.*;

public class Database {
    private static final String URL="jdbc:mysql://localhost:3306/musicdb";
    private static final String USER="root";
    private static final String PASS="root";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }

    // Save track
    public static void saveTrack(String title,String artist){
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("INSERT INTO tracks(title,artist) VALUES(?,?)");
            ps.setString(1,title);
            ps.setString(2,artist);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
    }

    // Playlist CRUD
    public static void createPlaylist(String name){
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("INSERT INTO playlists(name) VALUES(?)");
            ps.setString(1,name);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
    }

    public static ArrayList<Playlist> getPlaylists(){
        ArrayList<Playlist> list=new ArrayList<>();
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("SELECT * FROM playlists");
            ResultSet rs=ps.executeQuery();
            while(rs.next()) list.add(new Playlist(rs.getInt("id"),rs.getString("name")));
        } catch(Exception e){ e.printStackTrace(); }
        return list;
    }

    public static void deletePlaylist(int id){
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("DELETE FROM playlists WHERE id=?");
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
    }
}
