/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantvszombie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author DELL
 */
public class TheGame_Scenee extends Scene{
    
    public static GridPane grid = new GridPane();
    public static Pane pane = new Pane();
    private ArrayList<ImageView> cards = new ArrayList<ImageView>();
    public static ArrayList<Plant> plants = new ArrayList<Plant>();
    public static ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    public static Label sunCounter = new Label("500"); 
    private ImageView moveWithDrage = new ImageView();
    public static int [][]matrix = new int [5][9];
    private int Num_Normal_Zombie ;
    private int Num_Cone_Zombie ;
    private int Num_Bucket_Zombie ;
    private int Num_of_waves ;
    private int Level_Number;
    Random rand = new Random();
    private void spawnZombie(){
        File data = new File("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\LevelsDetails.txt");
        Scanner in = null;
        try {
            in = new Scanner(data);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        if(data.exists()){
            int x;
            while(in.hasNext()){
                x = Integer.parseInt(in.next());
                Num_Normal_Zombie = Integer.parseInt(in.next());
                Num_Cone_Zombie = Integer.parseInt(in.next());
                Num_Bucket_Zombie = Integer.parseInt(in.next());
                Num_of_waves = Integer.parseInt(in.next());
                if(x == Level_Number)
                    break;
            }
        }
        int x , y;
        for (int i = 0; i < Num_Normal_Zombie; i++) { 
            x = rand.nextInt(100)+ 1000;
            y = rand.nextInt(540);
            Zombie z = new Zombie(x,y,7,1,Load_Images.images.get(2));
            zombies.add(z);
            pane.getChildren().add(z.getImage()); 
            }
        for (int i = 0; i < Num_Cone_Zombie; i++) {
            x = rand.nextInt(100)+ 1000;
            y = rand.nextInt(540);
            Zombie z = new Zombie(x,y,10,1,Load_Images.images.get(4));
            zombies.add(z);
            pane.getChildren().add(z.getImage()); 
        }
        for (int i = 0; i < Num_Bucket_Zombie; i++) {
            x = rand.nextInt(100)+ 1000;
            y = rand.nextInt(540);
            Zombie z = new Zombie(x,y,15,1,Load_Images.images.get(6));
            zombies.add(z);
            pane.getChildren().add(z.getImage()); 
        } 
    }
    
    private void cards_enterance(double x , ImageView image){
        TranslateTransition translatetransition = new TranslateTransition(Duration.seconds(0.5), image);
        translatetransition.setDelay(Duration.seconds(x));
        translatetransition.setFromX(0);
        translatetransition.setToX(200);
        translatetransition.play();
        image.setOpacity(1);
    }
    
    public TheGame_Scenee(StackPane root, double d, double d1,int levelNumber) {
        super(root, d, d1);
        this.Level_Number = levelNumber;
        
        Load_Images.TheGame_Scene_Zombies1_Images();
        Load_Images.TheGame_Scene_Zombies2_Images();
        Load_Images.TheGame_Scene_plants_Images();
        Music.end_MainMenu();           
        Music.start_chooseYourSeed();
        
        ImageView lawn = new ImageView(Load_Images.images.get(0));

        for (int i = 0; i < 9; i++) {
            ColumnConstraints column = new ColumnConstraints(75);
            grid.getColumnConstraints().add(column);
        }for (int i = 0; i < 5; i++) {
            RowConstraints row = new RowConstraints(115);
            grid.getRowConstraints().add(row);
        }
        
        //grid.setGridLinesVisible(true);
        grid.setLayoutX(240);
        grid.setLayoutY(105);
        pane.getChildren().addAll(lawn,grid);
        root.getChildren().add(pane);
          
        spawnZombie();
        TranslateTransition lawnTransition_right = new TranslateTransition(Duration.seconds(2), pane);
        lawnTransition_right.setDelay(Duration.seconds(1));
        lawnTransition_right.setFromX(0);
        lawnTransition_right.setToX(-330);
        lawnTransition_right.play();
        lawnTransition_right.setOnFinished((t) -> {
            TranslateTransition lawnTransition_left = new TranslateTransition(Duration.seconds(2), pane);
            lawnTransition_left.setDelay(Duration.seconds(1));
            lawnTransition_left.setFromX(-330);
            lawnTransition_left.setToX(0);
            lawnTransition_left.play();
            lawnTransition_left.setOnFinished((T) -> {
                Music.end_chooseYourSeed();
                Music.start_game();
                
                cards.add(new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Cards\\sunflowerCard.png"));
                cards_enterance(0.1 , cards.get(0));
                cards.add(new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Cards\\peashooterCard.png"));
                cards_enterance(0.2 , cards.get(1));
                cards.add(new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Cards\\wallnutCard.png"));
                cards_enterance(0.3 , cards.get(2));
                cards.add(new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Cards\\repeaterCard.png"));
                cards_enterance(0.4 , cards.get(3));
                cards.add(new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Cards\\jalapenoCard.png"));
                cards_enterance(0.5 , cards.get(4));
                cards.add(new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\Cards\\cherrybombCard.png"));
                cards_enterance(0.6 , cards.get(5));
                VBox vbox = new VBox();
                vbox.setSpacing(5);
                for (ImageView c: cards) {
                    
                    vbox.getChildren().add(c);
                    c.setOnMouseEntered((tt) -> {
                        c.setScaleX(0.9);
                        c.setScaleY(0.9);
                    });
                    c.setOnMouseExited((tt) -> {
                        c.setScaleX(1);
                        c.setScaleY(1); 
                    });
                    c.setOnMousePressed((tt) -> {
                        if(tt.getSource() == cards.get(0))
                            moveWithDrage = new ImageView(Load_Images.plants.get(0));
                        else if(tt.getSource() == cards.get(1))
                            moveWithDrage = new ImageView(Load_Images.plants.get(2));
                        else if(tt.getSource() == cards.get(2))
                            moveWithDrage = new ImageView(Load_Images.plants.get(4));
                        else if(tt.getSource() == cards.get(3))
                            moveWithDrage = new ImageView(Load_Images.plants.get(6));
                        else if(tt.getSource() == cards.get(4))
                            moveWithDrage = new ImageView(Load_Images.plants.get(10));
                        else
                            moveWithDrage = new ImageView(Load_Images.plants.get(8));
                        
                        pane.getChildren().add(moveWithDrage);
                        moveWithDrage.setOpacity(0.5);
                        moveWithDrage.setLayoutX(tt.getSceneX()-50);
                        moveWithDrage.setLayoutY(tt.getSceneY()-50);
                    });
                    
                    c.setOnMouseDragged((tt) -> {
                        moveWithDrage.setLayoutX(tt.getSceneX()-50);
                        moveWithDrage.setLayoutY(tt.getSceneY()-50);
                    });
                    
                    c.setOnMouseReleased(new placePlant());     
                }
                pane.getChildren().add(vbox);
                vbox.setTranslateX(-200);
                
                ImageView sun_board = new ImageView("C:\\Users\\DELL\\Documents\\NetBeansProjects\\PlantVsZombie\\images\\startBoard.png");
                sun_board.setLayoutX(110);
                sunCounter.setFont(Font.font("Tahoma",FontWeight.BOLD,30));
                sunCounter.setLayoutX(160);
                sunCounter.setLayoutY(3);
                sunCounter.setPrefWidth(100);
                sunCounter.setAlignment(Pos.CENTER);
                
                generateZombie z = new generateZombie();
                z.start();
                
                Sun sun = new Sun();
                sun.getImage().setOnMouseClicked((tt) -> {
                    TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), sun.getImage());
                    transition.setToX(80);
                    transition.setToY(0);
                    transition.play();
                    FadeTransition fade = new FadeTransition(Duration.seconds(0.7), sun.getImage());
                    fade.setToValue(0);
                    fade.play();
                    fade.setOnFinished((ttt) -> {
                        int sunScore = Integer.parseInt(sunCounter.getText()) +50;
                        sunCounter.setText("" + sunScore);
                   });
                });
                pane.getChildren().addAll(sun_board,sunCounter ,sun.getImage());
            });
        }); 
    }  
    
    
    class placePlant implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent t) {            
            pane.getChildren().remove(moveWithDrage);
            moveWithDrage=null;
            int x = (int)((t.getSceneX())-240)/75;
            int y = (int)((t.getSceneY())-105)/115;
                     
            Plant plant =null;            
            if(x >= 0 && x < 9 && y>=0 && y< 5 && matrix[y][x] == 0){
                if(t.getSource() == cards.get(0) && Integer.parseInt(sunCounter.getText()) >=50)
                    plant = new SunFlower(x,y);   
                else if(t.getSource() == cards.get(1) && Integer.parseInt(sunCounter.getText()) >=100)
                    plant = new PeaShooter(x,y);
                else if(t.getSource() == cards.get(2) && Integer.parseInt(sunCounter.getText()) >=50)
                    plant = new Wall_Nut(x,y);
                else if(t.getSource() == cards.get(3) && Integer.parseInt(sunCounter.getText()) >=200)
                    plant = new Repeater(x,y);
                else if(t.getSource() == cards.get(4) && Integer.parseInt(sunCounter.getText()) >=150)
                    plant = new Jalapeno(x,y);
                else if(t.getSource() == cards.get(5) && Integer.parseInt(sunCounter.getText()) >=125)
                    plant = new CherryBomb(x,y);
                
                if(plant != null){
                plants.add(plant);
                ImageView plantImage=plant.getImage();
                plantImage.setTranslateX(-15);
                grid.add(plantImage,x,y);
                Music.Plane_plant();
                matrix[y][x]=1;
                sunCounter.setText("" +(Integer.parseInt(sunCounter.getText())-plant.getCost()));
                }
            }
        }  
    }
    
    
    class generateZombie extends Thread{
       
        @Override
        public void run(){
            for (int i = 0; i < Num_Normal_Zombie+Num_Cone_Zombie+Num_Bucket_Zombie; i++) {
                zombies.get(i).start();
                try {
                    Thread.sleep(rand.nextInt(10000)+3000);
                } catch (InterruptedException ex) {
                    System.out.println("error from generateZombie");
                }       
            }
        }
    }
}
       
    
 

