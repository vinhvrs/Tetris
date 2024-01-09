package main;
import java.net.url;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip musicClip;
    URL url[] = new URL [10];

    public Sound() {
        url[0] = getClass().getResource("/bgm.wav"); //background music
        url[0] = getClass().getResource("/rotation.wav");
        url[0] = getClass().getResource("/delete line.wav");
        url[0] = getClass().getResource("/gameover.wav");
        url[0] = getClass().getResource("/touchfloor.wav");
    }

    public void play(int i, boolean music) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(url[i]);
            Clip clip = AudioInputStream.getClip();
        } catch (Exception e) {
        }
    }
}
