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
public class SunFlower extends Plant implements Runnable{
    
    private ImageView sun = new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\sun.png");

    
    public SunFlower(int x, int y ) {
        super(x, y, 5, 50, 5, Load_Images.plants.get(0)); 
                     
    
        sun.setOnMouseClicked((tt) -> {
                TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), sun);
                transition.setToX(80);
                transition.setToY(0);
                transition.play();
                FadeTransition fade = new FadeTransition(Duration.seconds(0.7), sun);
                fade.setToValue(0);
                fade.play();
                fade.setOnFinished((ttt) -> {
                    int sunScore = Integer.parseInt(TheGame_Scenee.sunCounter.getText()) +50;
                    TheGame_Scenee.sunCounter.setText("" + sunScore);
               });
            });
        
        TheGame_Scenee.pane.getChildren().add(sun);
        
        Thread t = new Thread(this);
        t.start();
    }
    


    @Override
    public void run() {
        while(true){
            try {
                if(getHealth() == 0)
                    Thread.sleep(Long.MAX_VALUE);
                TranslateTransition transition = new TranslateTransition(Duration.seconds(2), sun);
                transition.setFromX((x*75)+240);
                transition.setFromY((y*115)+105);
                transition.setToX((x*75)+240+70);
                transition.setToY((y*115)+105+50);
                transition.play();
                
                FadeTransition fade = new FadeTransition(Duration.seconds(0.7), sun);
                fade.setFromValue(0);
                fade.setToValue(1);            
                fade.play();
                
                Thread.sleep(10000);

            } catch (InterruptedException ex) {
                System.out.println("error from sunflower sun");
            }       
        }
    }
}
    


