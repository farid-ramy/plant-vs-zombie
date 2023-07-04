/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;


/**
 *
 * @author DELL
 */
public class Wall_Nut extends Plant{
    
    public Wall_Nut(int x, int y ) {
        super(x, y, 15, 50, 7, Load_Images.plants.get(4));
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health); 
        if (health == 7)
            setImage(Load_Images.plants.get(5));
    }
    
}
