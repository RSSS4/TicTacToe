package view;

import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

    private Clip musicPlay;

    public void playMusic() {

        try {
            File mfile = new File("res/music/music.wav");
            musicPlay = AudioSystem.getClip();
            musicPlay.open(AudioSystem.getAudioInputStream(mfile));
            musicPlay.start();
            musicPlay.loop(10);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public Clip getMusic() {
        return musicPlay;
    }
}
