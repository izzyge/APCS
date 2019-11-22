import javafx.embed.swing.JFXPanel;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.HashMap;

public class Sound {
    private static final JFXPanel soundPanel = new JFXPanel();
    private static HashMap<String, Media> sounds = new HashMap<>();

    private Sound() {};

    private static Media getSound(String sound) {
        try {
            Media soundMedia = new Media(Sound.class.getResource(sound).toURI().toString());
            return soundMedia;
        } catch (Exception e) {
            System.out.println("Error loading sound file: " + sound);
        }
        return null;
    }

    /**
     * This method is used to initialize a sound prior to playing. It can be manually called or with the playSound
     * method. Use this if the first time you play a sound requires a quick load time (such as firing a shot in a game).
     * @param sound The string of the sound file to initialize.
     * @return boolean Returns true if the load was successful, false otherwise.
     */
    public static boolean initializeSound(String sound) {
        if(!sounds.containsKey(sound)) {
            Media soundMedia = getSound(sound);
            if(soundMedia != null) {
                sounds.put(sound, soundMedia);
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     * This method plays the sound specified by the sound parameter.
     * @param sound The string of the sound file to play.
     * @return MediaPlayer object. This can be discarded if not needed.
     */
    public static MediaPlayer playSound(String sound) {
        return playSound(sound, 1, false);
    }

    /**
     * This method plays the sound specified by the sound parameter allowing looping.
     * @param sound The string of the sound file to play.
     * @param loop True if the audio should loop (such as a background track), false otherwise.
     * @return MediaPlayer object. This can be discarded if not needed.
     */
    public static MediaPlayer playSound(String sound, boolean loop) {
        return playSound(sound, 1, loop);
    }

    /**
     * This method plays the sound specified by the sound parameter allowing volume specification.
     * @param sound The string of the sound file to play.
     * @param double A double from 0-1 specifying the volume.
     * @return MediaPlayer object. This can be discarded if not needed.
     */
    public static MediaPlayer playSound(String sound, double volume) {
        return playSound(sound, volume, false);
    }

    /**
     * This method plays the sound specified by the sound parameter allowing looping and volume specification.
     * @param sound The string of the sound file to play.
     * @param double A double from 0-1 specifying the volume.
     * @param loop True if the audio should loop (such as a background track), false otherwise.
     * @return MediaPlayer object. This can be discarded if not needed.
     */
    public static MediaPlayer playSound(String sound, double volume, boolean loop) {
        if(!initializeSound(sound))
            return null;

        final MediaPlayer player = new MediaPlayer(sounds.get(sound));
        player.play();
        if(loop) {
            player.setCycleCount(AudioClip.INDEFINITE);
        } else {
            player.setOnEndOfMedia(() -> player.dispose());
        }
        player.setVolume(volume);
        return player;
    }
}
