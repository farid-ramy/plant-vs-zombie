/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author DELL
 */
public class Music {
    
    private static Clip clip;
    
    public static void start_MainMenu(){
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream( new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\music\\main.wav"));
            clip =AudioSystem.getClip();
            clip.open(audioStream); 
            clip.loop(Integer.MAX_VALUE);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error can't get the main menu music");
        } finally {
            try {
                audioStream.close();
            } catch (IOException ex) {
                System.out.println("Error can't get the main menu music");
            }
        }
    }
    
    public static void end_MainMenu(){
        clip.close();
    }
    
    public static void start_chooseYourSeed(){
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream( new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\music\\PlantsVsZombiesChooseYourSeeds.wav"));
            clip =AudioSystem.getClip();
            clip.open(audioStream); 
            clip.loop(Integer.MAX_VALUE);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error can't get the choose your seed music");
        } finally {
            try {
                audioStream.close();
            } catch (IOException ex) {
                System.out.println("Error can't get the choose your seed music");
            }
        }
    }
    
    public static void end_chooseYourSeed(){
        clip.close();
    }
    
    public static void start_game(){
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream( new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\music\\background.wav"));
            clip =AudioSystem.getClip();
            clip.open(audioStream); 
            clip.loop(Integer.MAX_VALUE);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error can't get the start game music");
        } finally {
            try {
                audioStream.close();
            } catch (IOException ex) {
                System.out.println("Error can't get the start game music");
            }
        }
    }
    
    public static void end_game (){
        clip.close();
    }
    
    public static void Plane_plant(){
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream( new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\music\\sounds\\plant.wav"));
            clip =AudioSystem.getClip();
            clip.open(audioStream); 
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error can't get the start game music");
        } finally {
            try {
                audioStream.close();
            } catch (IOException ex) {
                System.out.println("Error can't get the start game music");
            }
        }
    }
}
