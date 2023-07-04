/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author DELL
 */
abstract public class Plant {
    protected int x ;
    protected int y;
    protected int health;
    protected int cost;
    protected int waitingTime;
    protected ImageView image;

    public Plant(int x, int y, int health,int cost , int waitingTime, Image image) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.cost =cost;
        this.waitingTime = waitingTime;
        this.image = new ImageView(image);
    }
    
    public Plant(){}

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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        System.out.println("health =" + health);
        this.health = health;
        if(health == 0){
            TheGame_Scenee.plants.remove(this);
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image.setImage(image);
    }
    
    
}
