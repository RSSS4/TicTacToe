package tictactoe.view;

import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

    private File mfile;
    private Clip music;

    public void playMusic() {

        try {
            mfile = new File("res/music/music.wav");
            music = AudioSystem.getClip();
            music.open(AudioSystem.getAudioInputStream(mfile));
            music.start();
            music.loop(10);
        } catch (Exception e) {
        }
    }

    public Clip getMusic() {
        return music;
    }
}
