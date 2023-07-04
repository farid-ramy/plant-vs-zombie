/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class Zombie extends Thread{
    private int x ;
    private int y ;
    private int helath;
    private int damage;
    private ImageView image;
    private int y_index[] ={25,140,270,365,500};
    private int x_index = 900;
    private int row;
    private Random rand = new Random();

    public Zombie(int x, int y, int health, int damage, Image image) {
        this.x = x;
        this.y = y;
        this.helath = health;
        this.damage = damage;
        this.image = new ImageView(image);
        this.image.setLayoutX(x);
        this.image.setLayoutY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        image.setLayoutX(x);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        image.setLayoutY(y);
        this.y = y;
    }

    public int getHelath() {
        return helath;
    }

    public int getRow() {
        return row;
    }
    

    public void setHelath(int helath) {
        System.out.println("zombie health = " + helath);
        if(helath == 4 ){
            setImage(Load_Images.images.get(10));
        }else if(helath == 0){
            setImage(Load_Images.zombie.get(9));
            //TheGame_Scenee.zombies.remove(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
            }
            getImage().setVisible(false);
        }
        this.helath = helath;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image.setImage(image);
    }
    
    private synchronized void change(Plant p){
      //  System.out.println(Load_Images.images.indexOf(getImage().getImage()));
        setImage(Load_Images.zombie.get(Load_Images.images.indexOf(getImage().getImage()) - 2 ));
        while(p.getHealth() > 0 && getHelath() > 0){
            p.setHealth(p.getHealth()-1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        TheGame_Scenee.plants.remove(p);
        System.out.println(TheGame_Scenee.plants.size());
        TheGame_Scenee.matrix[p.getY()][p.getX()]=0;
        p.getImage().setVisible(false);
        setImage(Load_Images.images.get(Load_Images.zombie.indexOf(getImage().getImage()) +2));
    }
    
    private synchronized void moving(){
        setX(getX()-5); // speed 
        System.out.println("moving");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Error from zombie");
        }
    }
    
    public void run(){
        Random rand = new Random();
        row = rand.nextInt(5);
        setY(y_index[row]);
        
        setX(x_index);
        while(true){
            if(getHelath() > 0)
            moving();  
            if(TheGame_Scenee.plants.size()>0){
                for (Plant p : TheGame_Scenee.plants) {
                    if(getY()==25 && p.getY() == 0 && getX()- p.getImage().getLayoutX() < 250){
                        change(p);
                    }
                    else if(getY()==140 && p.getY() == 1 && getX()- p.getImage().getLayoutX() < 250){
                        change(p);
                    }
                    else if(getY()==270 && p.getY() == 2 && getX()- p.getImage().getLayoutX() < 250){
                        change(p);
                    }
                    else if(getY()==365 && p.getY() == 3 && getX()- p.getImage().getLayoutX() < 250){
                        change(p);
                    }
                    else if(getY()==500 && p.getY() == 4 && getX()- p.getImage().getLayoutX() < 250){
                        change(p);
                    }
                }
            }
        }
    }
}
