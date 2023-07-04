/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author DELL
 */
public class Load_Images {
    
    public static ArrayList<Image> images = new ArrayList<Image>();
    public static ArrayList<Image> zombie = new ArrayList<Image>();
    public static ArrayList<Image> plants = new ArrayList<Image>();
    
    
    private static void clear(){
        images.clear();
        images = null;
        images = new ArrayList<Image>();
    }
    
    public static void LoginPage_Scene_Images(){
        clear();
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\loginBackground.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\openEye.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\closeEye.png"));   
    }
    
    public static void RegisterPage_Secene_Images(){
        clear();
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image1.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image2.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image3.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image4.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image5.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image6.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image7.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image8.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image9.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\image10.png"));
    }
    
    public static void MainMenu_Scene_Images(){
        clear();
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\main_menu.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\select_level.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\my_profile.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\log_out.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\exit.png"));
    }
    
    public static void selectLevel_Scene_Images(){
        clear();
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\button.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\button_locked.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\button_hover.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\map1.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\fog.png"));
    }
    
    public static void TheGame_Scene_Zombies1_Images(){
        clear();
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\lawn.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\lawn_night.png"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (8).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (2).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (4).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (3).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (1).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (6).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (5).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (7).gif"));
        images.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\walk\\z (9).gif"));
        System.out.println("ZOMBIE WALK LOADED");   
    }
    
    public static void TheGame_Scene_Zombies2_Images(){
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (6).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (8).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (1).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (9).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (2).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (4).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (3).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (7).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\eat\\zEat (5).gif"));
        zombie.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Zombie\\die.gif"));
    }
  
    public static void TheGame_Scene_plants_Images(){
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (12).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (11).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (6).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (9).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (8).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (3).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (7).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (10).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\Normal.gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\Bomb.gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (5).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Plant\\plant (2).gif"));
        plants.add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\sun.png")); 
    }  
}
