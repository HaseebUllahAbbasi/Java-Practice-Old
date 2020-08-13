import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

public class audio_play
{
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("naat.mp3");

        System.out.println(file.getTotalSpace());

        play(file);
    }
    public static void play(File file) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(file));
        clip.start();
    }
}
