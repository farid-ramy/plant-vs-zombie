/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plantvszombie;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author DELL
 */
public class PlantVsZombie extends Application{
    
    public static Stage stage;
   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception { 
        this.stage = stage;
        
        Music.start_MainMenu();
        
        stage.setTitle("Plant Vs Zombie");
        stage.getIcons().add(new Image("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\icon.png"));
        stage.setScene(new LoginPage_Scene(new StackPane(), 600,500));
        //stage.setScene(new TheGame_Scenee(new StackPane() , 1000,720 ,1));
        stage.setResizable(false);

        stage.show();
    }   
}
