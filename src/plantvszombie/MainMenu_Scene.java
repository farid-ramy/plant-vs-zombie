/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author DELL
 */
public class MainMenu_Scene extends Scene{
    
    private Button select_Level ,my_profile, log_out,exit;
    private ImageView mainMenu_background;
    public static Player player;

    private Button createButton(double w , double h , double x , double y , double r){
        Button button = new Button();
        button.setPrefWidth(w);
        button.setPrefHeight(h);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setRotate(r);
        button.setOpacity(0);
    
        return button;
    }
    
    public MainMenu_Scene(StackPane root , double d1 , double d2 , Player player) {
        super(root,d1,d2);
        Load_Images.MainMenu_Scene_Images();
        
        this.player = player;
        
        mainMenu_background = new ImageView(Load_Images.images.get(0));
        
        Pane pane = new Pane();
        //user name
        Label name = new Label(player.getFirstName());
        name.setLayoutX(70);
        name.setLayoutY(107);
        name.setPrefWidth(280);
        name.setAlignment(Pos.CENTER);
        name.setTextFill(Color.BEIGE);
        name.setFont(Font.font("Algerian",FontWeight.NORMAL,20));     
        //create button
        select_Level = createButton(400,90,510,120,7);
        my_profile = createButton(360,90,525,254,10);
        log_out = createButton(330,80,525,354,12);
        exit = createButton(325,75,525,450,14.5);
        //select_Level setting
        select_Level.setOnMouseEntered(new actions_on_enter());      
        select_Level.setOnMouseExited(new actions_on_exit());
        select_Level.setOnAction(new actions_on_Click());
        //my_profile setting
        my_profile.setOnMouseEntered(new actions_on_enter());
        my_profile.setOnMouseExited(new actions_on_exit());
        my_profile.setOnAction(new actions_on_Click());
        //log_out setting
        log_out.setOnMouseEntered(new actions_on_enter());
        log_out.setOnMouseExited(new actions_on_exit());
        log_out.setOnAction(new actions_on_Click());
        //exit setting
        exit.setOnMouseEntered(new actions_on_enter());
        exit.setOnMouseExited(new actions_on_exit());
        exit.setOnAction(new actions_on_Click());
        
        pane.getChildren().addAll(name ,select_Level,my_profile,log_out,exit);
        root.getChildren().addAll(mainMenu_background,pane);
    }
    
    class actions_on_enter implements EventHandler<Event>{
        @Override
        public void handle(Event t) {
            if(t.getSource() == select_Level){
                mainMenu_background.setImage(Load_Images.images.get(1));
            }else if(t.getSource() == my_profile){
                mainMenu_background.setImage(Load_Images.images.get(2));
            }else if(t.getSource() == log_out){
                mainMenu_background.setImage(Load_Images.images.get(3));
            }else if(t.getSource() == exit){
                mainMenu_background.setImage(Load_Images.images.get(4));
            }
        }  
    }
    
    class actions_on_exit implements EventHandler<Event>{
        @Override
        public void handle(Event t) {
            mainMenu_background.setImage(Load_Images.images.get(0));
        }  
    }
    
    class actions_on_Click implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            if(t.getSource() == select_Level){
                PlantVsZombie.stage.setScene(new SelectLevel_Scene(new ScrollPane(), 1000,720));
                PlantVsZombie.stage.centerOnScreen();
            }else if(t.getSource() == my_profile){
                
            }else if(t.getSource() == log_out){
                PlantVsZombie.stage.setScene(new LoginPage_Scene(new StackPane(), 600,500));
                PlantVsZombie.stage.centerOnScreen();
            }else if(t.getSource() == exit){
                System.exit(0);
            }
        }
    }
}

