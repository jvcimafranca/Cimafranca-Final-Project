
package music.player;

// imports
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *Loads the music into the app.
 * @author JV RENZ CIMAFRANCA
 */
public class MusicLoader {
    
    static MusicLoader player = new MusicLoader();
    
    static Clip clip;
    
    private MusicLoader(){
    
    }
    /**
     * Method to get the instance of the MusicLoader.
     * @return player
     */
    public static MusicLoader getInstance(){
    
        return player;
    
    }
    /**
     * Method to load the music.
     * @param filePath
     * @throws UnsupportedAudioFileException 
     */
    
    
    public static void loadMusic(String filePath) throws UnsupportedAudioFileException{
        try{
            File musicPath = new File(filePath);
            
            if(musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                
            }
        }
        
        catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            System.out.println(e);
        }
    }
   
}
