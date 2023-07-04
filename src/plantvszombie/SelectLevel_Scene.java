 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class SelectLevel_Scene extends Scene{
    
    private Button b1 ,b2,b3,b4,b5,b6,b7;
    private Player player;
    
    private Button CreateButton(double x , double y ,int num){
        Button button = new Button(""+num); 
        button.setFocusTraversable(false);
        button.setBorder(Border.EMPTY);
        button.setBackground(Background.EMPTY);
        if(num <= player.getLevelsUnlocked())
            button.setGraphic(new ImageView(Load_Images.images.get(0)));
        else
            button.setGraphic(new ImageView(Load_Images.images.get(1)));
        
        button.setLayoutX(x);
        button.setLayoutY(y);     
        button.setOnAction(new actions_on_Click());
        button.setOnMouseEntered(new actions_on_enter());
        button.setOnMouseExited(new actions_on_exit());
        return button;
    }
    
    public SelectLevel_Scene(ScrollPane scroll, double d, double d1) {
        super(scroll, d, d1);
        Load_Images.selectLevel_Scene_Images();
        
        this.player = MainMenu_Scene.player;
        
        StackPane stack = new StackPane();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        Pane pane = new Pane();
        b1 = CreateButton(135,390 ,1);
        b2 = CreateButton(355,515 ,2);
        b3 = CreateButton(560,600 ,3);
        b4 = CreateButton(730,500 ,4);
        b5 = CreateButton(580,365 ,5);
        b6 = CreateButton(380,290 ,6);
        b7 = CreateButton(200,90 ,7);
        pane.getChildren().addAll(b1 ,b2,b3,b4,b5,b6,b7);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        ImageView fog =  new ImageView(Load_Images.images.get(4));
        TranslateTransition fogMove = new TranslateTransition(Duration.seconds(1.5),fog);
         fogMove.setFromX(0);
         fogMove.setToX(10);
         fogMove.setCycleCount(Integer.MAX_VALUE);
         fogMove.setAutoReverse(true);
         fogMove.play();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////                       
        stack.getChildren().addAll(new ImageView(Load_Images.images.get(3)),pane , fog);
           
        scroll.setContent(stack);
        scroll.setPannable(true);
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
    
    class actions_on_enter implements EventHandler<Event>{

        @Override
        public void handle(Event t) {
            Button b = (Button)t.getSource();
            if(Integer.parseInt(b.getText()) <= player.getLevelsUnlocked())
                b.setGraphic(new ImageView(Load_Images.images.get(2)));
        }      
    }
    
    class actions_on_exit implements EventHandler<Event>{

        @Override
        public void handle(Event t) {
            Button b = (Button)t.getSource();
            if(Integer.parseInt(b.getText()) <= player.getLevelsUnlocked())
                b.setGraphic(new ImageView(Load_Images.images.get(0)));
        }      
    }
    
        class actions_on_Click implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            Button b = (Button)t.getSource();
            if(Integer.parseInt(b.getText()) <= player.getLevelsUnlocked())
                PlantVsZombie.stage.setScene(new TheGame_Scenee(new StackPane() , 1000,720 , Integer.parseInt(b.getText())));
        }
    }
}
