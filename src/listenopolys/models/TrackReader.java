/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listenopolys.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author enmora
 */
public class TrackReader {

    private Collection<TrackReaderListener> listeners;
    private Media music;
    private MediaPlayer player;
    
    public TrackReader(Track track, boolean repeat){
        listeners = new ArrayList<>();
        File file = new File(track.getFilePath());
        music = new Media(file.toURI().toString());
        player = new MediaPlayer(music);
        player.setOnEndOfMedia(() -> {
            notifyEndOfMedia();
        });
        player.setCycleCount((repeat) ? MediaPlayer.INDEFINITE : 1);
    }

    public void addListener(TrackReaderListener listener){
        listeners.add(listener);
    }

    public void removeListener(TrackReaderListener listener){
        listeners.remove(listener);
    }

    public void notifyEndOfMedia(){
        for (TrackReaderListener listener : listeners) {
            listener.endOfMedia();
        }
    }

    public void pause(){
        player.pause();
    }

    public void play(){
        player.play();
    }
    
    public void stop(){
        player.stop();
        player.seek(new Duration(0));
    }

    public void setRepeatTo(boolean repeat){
        player.setCycleCount((repeat) ? MediaPlayer.INDEFINITE : 1);
    }

    public MediaPlayer getPlayer(){
        return player;
    }


    public String getStatus(){
        return player.getStatus().toString();
    }
    
}
