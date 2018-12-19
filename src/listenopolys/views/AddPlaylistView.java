package listenopolys.views;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import listenopolys.models.Playlist;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddPlaylistView {
	
	
	public AddPlaylistView(Stage primaryStage,  View view) {
		
		
		GridPane structAddPlaylist = new GridPane();
		TextArea newPlaylistName = new TextArea();
		Button addNewPlaylist= new Button("Add Playlist");
		
		
		Scene addPlaylistScene = new Scene(structAddPlaylist,500,500);
		Stage addPlaylist = new Stage();
		addPlaylist.setTitle("Add Playlist Window");
		
		addNewPlaylist.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		if(newPlaylistName.getText() != null && !newPlaylistName.getText().isEmpty()){
        			Playlist p = new Playlist(newPlaylistName.getText());
        			view.playlistService.addPlaylist(p);
		}
        		

        	}
        });
		
		addPlaylist.setX(primaryStage.getX()+100);
		addPlaylist.setY(primaryStage.getY()+200);
		
		structAddPlaylist.add(newPlaylistName, 0, 0);
		structAddPlaylist.add(addNewPlaylist, 0, 1);
		
		
		addPlaylist.setScene(addPlaylistScene);
		addPlaylist.show();

		
	}
	
}