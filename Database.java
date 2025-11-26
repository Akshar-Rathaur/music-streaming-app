import java.sql.*;
public class Database {
    private static final String URL="jdbc:mysql://localhost:3306/musicdb";
    private static final String USER="root";
    private static final String PASS="root";
    public static Connection connect() throws SQLException { return DriverManager.getConnection(URL,USER,PASS); }
    public static void saveTrack(String t,String a){
        try(Connection c=connect()){
            PreparedStatement ps=c.prepareStatement("INSERT INTO tracks(title,artist) VALUES(?,?)");
            ps.setString(1,t); ps.setString(2,a);
            ps.executeUpdate();
            System.out.println("Saved in DB");
        }catch(Exception e){ e.printStackTrace(); }
    }
}