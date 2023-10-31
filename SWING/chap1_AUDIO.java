package SWING;
import javax.sound.sampled.*;
import java.io.File;
import java.util.*;

public class chap1_AUDIO {
    public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);
    File fi = new File("C:\\Users\\SAMI\\IdeaProjects\\untitled2\\src\\SWING\\play.wav");

    try {
                AudioInputStream   ai = AudioSystem.getAudioInputStream(fi);
                Clip cl = AudioSystem.getClip();
                cl.open(ai);
                cl.start();
            } catch (Exception e) {
        System.out.println(e);
    }
            String st = sc.nextLine();
        }
    }

