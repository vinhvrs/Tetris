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

            if (music) {
                musicClip = clip;
            }

            clip.open(ais);
            clip.addLineListener(new addLineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == Type.STOP) {
                        clip.close();  
                    }
                }
            });
            ais.close();
            clip.start()

        } catch (Exception e) {

        }
    }

    public void loop() {
        musicClip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        musicClip.stop();
        musicClip.close();
        
    }
}
