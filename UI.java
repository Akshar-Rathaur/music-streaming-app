import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application {
    @Override
    public void start(Stage stage){
        Label title=new Label("Music Streaming Platform");
        Button playlistBtn=new Button("Show Playlists");

        playlistBtn.setOnAction(e->{
            var list=Database.getPlaylists();
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            StringBuilder sb=new StringBuilder();
            for(var p:list) sb.append(p.getId()+": "+p.getName()+"\n");
            a.setHeaderText("Playlists");
            a.setContentText(sb.toString());
            a.show();
        });

        VBox root=new VBox(10,title,playlistBtn);
        stage.setScene(new Scene(root,400,300));
        stage.setTitle("Music App GUI");
        stage.show();
    }
}
