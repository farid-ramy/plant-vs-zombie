/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

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
public class PeaShooter extends Plant implements Runnable{
    
    private ImageView pea = new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\pea.png");

    
    public PeaShooter(int x, int y ) {
        super(x, y, 5, 100, 5, Load_Images.plants.get(2));
        pea.setVisible(false);
        TheGame_Scenee.pane.getChildren().add(pea);
        Thread t = new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        while(true){
            if(TheGame_Scenee.zombies.size()>0){
                for (Zombie z : TheGame_Scenee.zombies) {
                    if(z.getRow() == getY()&& z.getHelath() >0){
                        pea.setVisible(true);
                        pea.setLayoutX((getX()*75)+300);
                        pea.setLayoutY((getY()*115)+140);
                        while(pea.getLayoutX() < z.getX()+50&& z.getHelath() >0 ){
                            try { 
                                Thread.sleep(40);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(PeaShooter.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            pea.setLayoutX(pea.getLayoutX()+10) ;
                           // setImage(Load_Images.plants.get(2));
                        }
                        pea.setVisible(false);
                        z.setHelath(z.getHelath()-1);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PeaShooter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }
    
}
