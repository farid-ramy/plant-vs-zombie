/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class Sun extends Thread{
    private int x ;
    private int y;
    private ImageView image = new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\sun.png");

    public Sun() {
        this.x = 500;
        this.y = -50;
        this.start();
    }
     
    public void run(){
        Random rand = new Random();
        while(true){
            //System.out.println("new sun is created ->   x= " + x + " y= " + y);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), image);
            transition.setFromX(x);
            transition.setFromY(y);
                int newX = rand.nextInt(700)+200;
                int newY = rand.nextInt(650);
                transition.setToX(newX);
                transition.setToY(newY);
            transition.play();
            FadeTransition fade = new FadeTransition(Duration.seconds(0.7), image);
            fade.setFromValue(0);
            fade.setToValue(1);            
            fade.play();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                System.out.println("error from sun");
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageView getImage() {
        return image;
    }
}
